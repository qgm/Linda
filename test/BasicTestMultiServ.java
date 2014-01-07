package linda.test;

import linda.*;

public class BasicTestMultiServ {

	public static void main(String[] args) {
		
		final Linda linda_a = new linda.server.LindaClient("//localhost:4000/a");
		final Linda linda_b = new linda.server.LindaClient("//localhost:4000/b");

        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Tuple motif = new Tuple(Integer.class, String.class);
                /*Tuple res_b = linda_b.take(motif);
                System.out.println("(Thread 1) Resultat:" + res_b);*/
                Tuple res_a = linda_a.take(motif);
                System.out.println("(Thread 1) Resultat:" + res_a);
            }
        }.start();
		
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Tuple t1 = new Tuple(4, 5);
                System.out.println("(Thread 2, Serveur a) write: " + t1);
                linda_a.write(t1);

                Tuple t2 = new Tuple("hello", 15);
                System.out.println("(Thread 2, Serveur b) write: " + t2);
                linda_b.write(t2);

                Tuple t3 = new Tuple(4, "foo");
                System.out.println("(Thread 2, Serveur b) write: " + t3);
                linda_b.write(t3);

            }
        }.start();
		
		
	}
	
}
