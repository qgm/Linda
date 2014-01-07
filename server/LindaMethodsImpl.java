package linda.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;

import linda.Callback;
import linda.Tuple;
import linda.shm.CentralizedLinda;

public class LindaMethodsImpl extends UnicastRemoteObject implements LindaMethods {
	
	private static final long serialVersionUID = 1L;
	private CentralizedLinda cl;
	
	protected LindaMethodsImpl() throws RemoteException {
		
		this.cl = new CentralizedLinda();
		
	}

	public void write(Tuple t) throws java.rmi.RemoteException {
		cl.write(t);
	}

	public Tuple take(Tuple template) throws java.rmi.RemoteException {
		return this.cl.take(template);
	}

	public Tuple read(Tuple template) throws java.rmi.RemoteException {
		return this.cl.read(template);
	}

	public Tuple tryTake(Tuple template) throws java.rmi.RemoteException {
		return this.cl.tryTake(template);
	}

	public Tuple tryRead(Tuple template) throws java.rmi.RemoteException {
		return this.cl.tryRead(template);
	}

	public Collection<Tuple> takeAll(Tuple template)
			throws java.rmi.RemoteException {
		return this.cl.takeAll(template);
	}

	public Collection<Tuple> readAll(Tuple template)
			throws java.rmi.RemoteException {
		return this.cl.readAll(template);
	}

	public void eventRegister(Tuple template, Callback callback)
			throws java.rmi.RemoteException {
		this.cl.eventRegister(template, callback);
	}

	public void debug(String prefix) throws java.rmi.RemoteException {
		this.cl.debug(prefix);
	}

	@Override
	public void eventRegisterAux(Tuple template, byte[] cbBytes) {
		
	}
	
}
