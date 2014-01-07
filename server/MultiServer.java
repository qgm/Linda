package linda.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;



public class MultiServer {

	private static ArrayList<MonoServer> monoServers;
	private static int port = 4000;
	
	public MultiServer(String[] serverNames) throws RemoteException {
		this.monoServers = new ArrayList<MonoServer>(serverNames.length);
		for (int i=0; i<serverNames.length; i++) {
			monoServers.add(i,new MonoServer(serverNames[i]));
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
			Registry registry = LocateRegistry.createRegistry(port);
			MultiServer ms = new MultiServer(args);
			
			for (int i=0; i<args.length ; i++) {
					
				LindaMethods stub = (LindaMethods) UnicastRemoteObject.exportObject(monoServers.get(i),0);
				
				registry.bind("//localhost:" + port + "/" +monoServers.get(i).getName(),stub);
			
				System.err.println("Server "+ monoServers.get(i).getName()+ " Ready");
		
			}
		
		
		} catch (Exception e) {
			System.out.println("MultiServer exception :"+e.toString());
			e.printStackTrace();
		}
	}
}
