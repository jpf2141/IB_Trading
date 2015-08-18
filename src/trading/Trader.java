
package trading;


public class Trader { 
	
	public static int clientID = 1;
	public Socket socket;

	
	public Trader() { 
		socket = new Socket();
		if(socket.connect(null, 7496, clientID)) {
			socket.connectionID = clientID;	//associate the client with a client
			clientID++;		//if another connection is made later, 
							//clientID must remain unique
		}
	}
	
	public static void main(String[] args) {
		Trader trader = new Trader();
		//System.out.println(trader.socket.connection.isConnected());
		
		
		
		
		trader.socket.disconnect();
		
	
	}
	
}