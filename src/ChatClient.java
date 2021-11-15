import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
 
public class ChatClient {
	public static void main (String[] argv) {
	    try {
		    	System.setSecurityManager(new RMISecurityManager());
		    	Scanner s=new Scanner(System.in);
		    	System.out.println("Ingrese su nombre:");
		    	String name=s.nextLine().trim();		    		    	
		    	ChatInterface client = new Chat(name);
 
		    	ChatInterface server = (ChatInterface)Naming.lookup("rmi://localhost/ABC");
		    	String msg="["+client.getName()+"] conectado";
		    	server.send(msg);
		    	System.out.println("Ingrese un mensaje:");
		    	server.setClient(client);
 
		    	while(true){
		    		msg=s.nextLine().trim();
		    		msg="["+client.getName()+"] "+msg;		    		
	    			server.send(msg);
		    	}
 
	    	}catch (Exception e) {
	    		System.out.println("Problema de conexion " + e);
	    	}
		}
}