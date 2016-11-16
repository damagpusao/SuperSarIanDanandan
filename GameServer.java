public class GameServer {
   public static void main (String [] args) throws Exception {
		TCPServer myServer = new TCPServer(); //start chat server
		myServer.start();
	}
}