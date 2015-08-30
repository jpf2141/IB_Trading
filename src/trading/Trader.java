
package trading;


public class Trader { 
	
	public static final int clientID = 1;
	
	public Socket socket;

	
	public Trader() { 
		socket = new Socket();
		if(!socket.connect(null, 7496, clientID)) {	//if connection fails
			return;
		}
	}
	
	public static void main(String[] args) {
		Trader trader = new Trader();
		if(!trader.socket.connection.isConnected()) {
			return;		//connection failed, return
		}
		
		
		
		
		trader.socket.disconnect();
		
	
	}

	
}