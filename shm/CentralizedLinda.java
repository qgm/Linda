
package linda.shm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import linda.Callback;
import linda.Linda;
import linda.Tuple;

/** Shared memory implementation of Linda. */
public class CentralizedLinda implements Linda {

    private List<Tuple> liste_tuples;

    private Lock moniteur;

    private Condition PrendrePossible;
    private Condition LirePossible;

    private Hashtable<Tuple,Callback> callbacks;
    
    /** Constructeur par defaut de Linda */
    public CentralizedLinda() {
        this.liste_tuples = new ArrayList<Tuple>();
        this.moniteur = new ReentrantLock();
        this.PrendrePossible = moniteur.newCondition();
        this.LirePossible = moniteur.newCondition();
        this.callbacks = new Hashtable<Tuple,Callback>();
    }

    @Override
    /** Ecrit un tuple dans Linda */
    public void write(Tuple t) {
    	this.moniteur.lock();
    		// Ajout du Tuple
        	this.liste_tuples.add(t);
            // On prévient les process en attente de lecture ou de take
        	this.LirePossible.signalAll();
        	this.PrendrePossible.signal();
            /* Si on a ajouté un Tuple possédant un abonnement, on l'enleve de l'espace
        	   et on met le callback a false */
        	Set<Tuple> tuple_callback = callbacks.keySet();
        	for ( Tuple t2 : tuple_callback) {
        			if (t.matches(t2)) {
        				eventRegister(t2,callbacks.get(t2));
        			}
        	}
        this.moniteur.unlock();
    }

    @Override
    /** Prend un tuple dans Linda (version bloquante) */
    public Tuple take(Tuple template) {

    	boolean trouve = false;
        this.moniteur.lock();
    
        // On cherche le Tuple
        while (!trouve) {
        	
        	for (Tuple t : this.liste_tuples) {
                if (t.matches(template)) {
                    trouve = true ;
                }
            }
        	
        	if(!trouve) {
        		 try {
                     this.PrendrePossible.await();
                     } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
        	}
        }
        
        // On take le Tuple correspondant au motif
        for ( Tuple t : this.liste_tuples) {
            if (t.matches(template)) {
                Tuple tres= t;
            	this.liste_tuples.remove(t);
                this.moniteur.unlock();
                return tres;
            }
        }
        
        this.moniteur.unlock();
        return null;
   
    }

    @Override
    /** Lit un tuple dans Linda */
    public Tuple read(Tuple template)  {

        boolean trouve = false;
        this.moniteur.lock();

        while(!trouve) {
            // Recherche du tuple
            for (Tuple t : this.liste_tuples) {
                if (t.matches(template)) {
                    trouve = true ;
                }
            }
            // On attend qu'il soit present sinon on attend
            if(!trouve){
                try {
                    this.LirePossible.await();
                    } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Renvoi du Tuple
        for ( Tuple t : this.liste_tuples) {
            if (t.matches(template)) {
                this.moniteur.unlock();
                return t;
            }
        }
        this.moniteur.unlock();
        return null;
    }

    @Override
    /** Version non bloquante de take */
    public Tuple tryTake(Tuple template) {

        int i = 0;
        int n = this.liste_tuples.size();

        if (n==0) {
            return null;
        }

        while (!(this.liste_tuples.get(i).matches(template)) && i<n) {
            i++;
        }

        if (i<n) {
            Tuple tres = this.liste_tuples.get(i);
            this.liste_tuples.remove(tres);
            return tres;
        }

        else {
            return null;
        }
    }

    @Override
    /** Version non bloquante de read */
    public Tuple tryRead(Tuple template) {

        int i = 0;
        int n = this.liste_tuples.size();

        if (n==0) {
            this.moniteur.unlock();
            return null;
        }

        while (!(this.liste_tuples.get(i).matches(template)) && i<n) {
            i++;
        }

        if (i<n) {
            Tuple tres = this.liste_tuples.get(i);
            return tres;
        }

        else {
            return null;
        }
    }

    @Override
    /** Prend tous les liste_tuples de ce motif dans Linda */
    public Collection<Tuple> takeAll(Tuple template) {
        List<Tuple> liste_tuples_res = new ArrayList<Tuple>();

        for (Tuple ti : this.liste_tuples) {
            if (ti.matches(template)) {
                liste_tuples_res.add(ti);
                this.liste_tuples.remove(ti);
            }
        }

        return liste_tuples_res;
    }

    @Override
    /** Lit tous les liste_tuples de ce motif dans Linda */
    public Collection<Tuple> readAll(Tuple template) {
        List<Tuple> liste_tuples_res = new ArrayList<Tuple>();

        for (Tuple ti : this.liste_tuples) {
            if (ti.matches(template)) {
                liste_tuples_res.add(ti);
            }
        }

        return liste_tuples_res;
    }

    @Override
    /** Fait un take non bloquant:
     * S'il trouve un motif correspondant, le take et appel le callback
     * Sinon il faut stocker dans une liste d'attente, jusqu'a ce qu'un write du bon motif soit effectué
     * Donc il faut que le process puisse continuer meme si on le trouve pas
     */
    public void eventRegister(Tuple template, Callback callback) {
    		
	    	boolean trouve = false;
    		
    		for (Tuple t : this.liste_tuples) {
	            
	    		if (t.matches(template)) {
	    			trouve = true;
	    			callback.call(template);
	    			this.liste_tuples.remove(t);
	    			break; // pour eviter une ConcurrentModificationException lors du parcours de liste_tuples
	    		}
	    	}
            
	    	if(!trouve) {
	    		this.callbacks.put(template,callback);
	    	}
    }   

    @Override
    public void debug(String prefix) {
        System.out.println(prefix + " liste_tuples : " + this.liste_tuples.size());
    }

}