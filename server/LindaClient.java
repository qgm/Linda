package linda.server;

import java.util.Collection;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import linda.Callback;
import linda.Linda;
import linda.Tuple;

import linda.server.Serializer;

/** Client part of a client/server implementation of Linda.
 * It implements the Linda interface and propagates everything to the server it is connected to.
 * */
public class LindaClient implements Linda {
	
    private LindaMethods stub;
	private static int port = 4000;
    
	/** Initializes the Linda implementation.
     *  @param serverURI the URI of the server, e.g. "//localhost:4000/LindaServer".
     */
	
    public LindaClient(String serverURI) { 
		
    	try {
			Registry registry = LocateRegistry.getRegistry(port);
    		this.stub = (LindaMethods) registry.lookup(serverURI);
    	} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} 
    }
      
	public void write(Tuple t) {
		try {
			this.stub.write(t);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public Tuple take(Tuple template) {
		try {
			return this.stub.take(template);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Tuple read(Tuple template) {
		try {
			return this.stub.read(template);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Tuple tryTake(Tuple template) {
		try {	
			return this.stub.tryTake(template);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Tuple tryRead(Tuple template) {
		try {
			return this.stub.tryRead(template);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Collection<Tuple> takeAll(Tuple template) {
		try {
			return this.stub.takeAll(template);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Collection<Tuple> readAll(Tuple template) {
		try {
			return this.stub.readAll(template);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Callback non-sérialisable : on envoie le callback sérialisé
	public void eventRegister(Tuple template, Callback callback) {
	    
			byte[] cbBytes;
			try {
				cbBytes = Serializer.serialize(callback);
				this.stub.eventRegisterAux(template,cbBytes);
			} catch (Exception e) {
				Exception ex = e;
				for (;;) {
					UndeclaredThrowableException te = null;
					Throwable t;
					if (ex instanceof UndeclaredThrowableException) {
						te = ((UndeclaredThrowableException) ex);
						t = te.getUndeclaredThrowable();
					} else if (ex instanceof InvocationTargetException) {
						t = ((InvocationTargetException) ex).getTargetException();
					} else {
						break;
					}
					if (t instanceof Exception) {
						ex = (Exception) t;
					} else {
						if (te == null) {
							te = new UndeclaredThrowableException(t);
						}
						t.printStackTrace();
						throw te;
					}
				}
			}
	}
	
	public void debug(String prefix) {
		try {
			this.stub.debug(prefix);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}


}
