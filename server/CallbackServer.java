package linda.server;

import java.io.ObjectStreamException;
import java.io.Serializable;
import linda.Callback;

public class CallbackServer implements Serializable {

	private static final long serialVersionUID = 1L;
	private Callback cb;
	
	public CallbackServer(Callback cb) {this.cb = cb;}
	
	public Callback getCallback() {
		return this.cb;
	}
	
	public Object readResolve() throws ObjectStreamException {
		return new CallbackServer(cb);
	}

	
	
}
