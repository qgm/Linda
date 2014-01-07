package linda.server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import linda.Callback;

public class Serializer {
	
	public static byte[] serialize(Object o) throws Exception {
		    
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ObjectOutputStream oos = new CallbackObjectOutputStream(baos);
	    oos.writeObject(o);
	    oos.flush();
	    oos.close();
	    return baos.toByteArray();
	
	}
	
	public static Callback deserialize(byte[] bytes) throws Exception {
	    
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
	    ObjectInputStream ois = new ObjectInputStream(bais);
	    Object o = ois.readObject();
	    CallbackServer cbs = new CallbackServer((Callback) o);
		Callback cb = (Callback) cbs.readResolve();
	    ois.close();
	    return cb;

	}
	
}
