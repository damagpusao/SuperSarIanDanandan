
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;


public class TCPClient extends Thread implements MessageDetector{
	private String name;
	public static void main (String [] args) throws Exception {
		TCPClient myClient = new TCPClient();
		myClient.start();
	}
	
	public void run() {
		try{
			BufferedReader user = new BufferedReader(new InputStreamReader(System.in)); // scanf
			String mymessage = "";
			System.out.print("Enter your name:");
			name = user.readLine();
			System.out.print("Enter IP Address of Server:");
			String ip = user.readLine();
			Socket SOCK = new Socket(ip,102);

			ThreadSocket threadsocket = new ThreadSocket(SOCK,this);
			threadsocket.start();

			while(true){		
				System.out.println();
				System.out.print(name + ":");
				String message = user.readLine(); //scanf

				threadsocket.sendMessage(name + ":" + message);
				
			}

		}

		catch(Exception e) {
			e.printStackTrace();
		}
		
	} //end of run()

	public void receivedMessage (ThreadSocket ts, String msg) {
		System.out.println();
		System.out.println("****** "+msg);
		System.out.print( name+":");
	}

}
