import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.util.ArrayList;


public class TCPServer extends Thread implements MessageDetector{
	private boolean isRunning;
	private ServerSocket SERVERSOCK ;
	private Socket SOCK;
	public ArrayList<ThreadSocket> list = new ArrayList<ThreadSocket>();

/*
	public static void main (String [] args) throws Exception {
		TCPServer myServer = new TCPServer();
		myServer.start();
	}
*/	
	public void run() {
		isRunning = true;
		try{
			 SERVERSOCK = new ServerSocket(1254);
			
			while(isRunning) {
				 SOCK = SERVERSOCK.accept();
		
				ThreadSocket threadsocket = new ThreadSocket(SOCK,this);
				threadsocket.start();

				list.add(threadsocket);	
			}

		}

		catch (Exception e) {
				e.printStackTrace();
			System.out.println("TCPServer");
		}
		
		
	} //end of run()
	
	public void sendMessages(ThreadSocket ts,String m)
	{
		for(ThreadSocket t : list)
		{
			t.sendMessage(m);
		}
	}

	public void receivedMessage (ThreadSocket ts, String msg) {
			if(msg != null || !msg.equals("")){
				this.sendMessages(ts,msg);
				System.out.println(msg);
			}

			else if(msg.equals("exit")){
				list.remove(ts);
			}
	}

	public void onDisconnected(ThreadSocket ts){
		list.remove(ts);
	}
		 

}
