package linda.server;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import linda.Callback;
import linda.server.CallbackServer;


public class CallbackObjectOutputStream extends ObjectOutputStream {

	 public CallbackObjectOutputStream(OutputStream out) throws IOException {
	        super(out);
	        enableReplaceObject(true);
	    }
	 
	    protected CallbackObjectOutputStream() throws IOException, SecurityException {
	        super();
	        enableReplaceObject(true);
	    }
	 
	    @Override
	    protected Object replaceObject(Object obj) throws IOException {
	        if (obj instanceof Callback) {
	            return new CallbackServer((Callback) obj);
	        } else return super.replaceObject(obj);
	    }

}
