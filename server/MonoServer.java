package linda.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;


import linda.Callback;
import linda.Tuple;

public class MonoServer implements LindaMethods {

	LindaMethods lm;
	String name;

	private static int port = 4000;

	public MonoServer(String name) throws RemoteException {		
		this.name = name;	
		this.lm = new LindaMethodsImpl();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void write(Tuple t) {
		try {
			this.lm.write(t);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Tuple take(Tuple template) {
        try {
	        return this.lm.take(template);
	    } catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Tuple read(Tuple template) {
		try {
			return this.lm.read(template);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Tuple tryTake(Tuple template) {
		try {
			return this.lm.tryTake(template);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Tuple tryRead(Tuple template) {
		try {
			return this.lm.tryTake(template);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Collection<Tuple> takeAll(Tuple template) {
		try {
			return this.lm.takeAll(template);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Collection<Tuple> readAll(Tuple template) {
		try {
			return this.lm.readAll(template);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void eventRegister(Tuple template, Callback callback) {
		
	}

	@Override
	public void debug(String prefix) {
		try {
			this.lm.debug(prefix);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {
			
			MonoServer obj = new MonoServer(args[0]);
			LindaMethods stub = (LindaMethods) UnicastRemoteObject.exportObject(obj,4000);			
			Registry registry = LocateRegistry.createRegistry(port);
			registry.bind("//localhost:" + port + "/" +obj.getName(),stub);
		
			System.err.println("Server Ready");
			
		} catch (Exception e) {
			System.out.println("Server exception :");
			e.printStackTrace();
		}

	}

	@Override
	public void eventRegisterAux(Tuple template, byte[] cbBytes) {
		try {
			
			Callback cb = Serializer.deserialize(cbBytes);
			this.lm.eventRegister(template,cb);
			System.out.println("coucou");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

