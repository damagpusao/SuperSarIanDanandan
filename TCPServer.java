import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;


public class TCPServer extends Thread implements MessageDetector{
	public ArrayList<ThreadSocket> list = new ArrayList<ThreadSocket>();

	public static void main (String [] args) throws Exception {
		TCPServer myServer = new TCPServer();
		myServer.start();
	}
	
	public void run() {
		try{
			ServerSocket SERVERSOCK = new ServerSocket(102);
			
			while(true) {
				Socket SOCK = SERVERSOCK.accept();
		
				ThreadSocket threadsocket = new ThreadSocket(SOCK,this);
				threadsocket.start();

				list.add(threadsocket);	
			}

		}

		catch (Exception e) {
				e.printStackTrace();
		}
		
		
	} //end of run()
	
	public void sendMessages(ThreadSocket ts,String m)
	{
		for(ThreadSocket t : list)
		{
			if(t!=ts)
				t.sendMessage(m);
		}
	}

	public void receivedMessage (ThreadSocket ts, String msg) {
		this.sendMessages(ts,msg);
		System.out.println(msg);
	
	}

}
