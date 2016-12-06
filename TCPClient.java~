
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.awt.event.*;


public class TCPClient extends Thread implements MessageDetector,ActionListener{
	private String name;
	private String serverIP;
	private boolean isRunning;
	private Socket SOCK;
	private ThreadSocket threadsocket;
	private ChatGUI chatGUI;
	public TCPClient (String name, String serverIP) {
		this.name = name;
	}

	
	public void run() {
		isRunning = true;
		try{
		    SOCK = new Socket(serverIP,102);

		    threadsocket = new ThreadSocket(SOCK,this);
			threadsocket.start();

			while(isRunning){		
			}

		}

		catch(Exception e) {
			e.printStackTrace();
		}
		
	} //end of run()

	public void stopClient() {
		isRunning = false;
		threadsocket.stopThreadSocket();
		try {
			SOCK.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public void addGUI(ChatGUI chatGUI){
		this.chatGUI = chatGUI;
	} 

	public void receivedMessage (ThreadSocket ts, String msg) {
		this.chatGUI.addMessage(msg);
	}

	public void onDisconnected(ThreadSocket ts){
		System.out.println("disconnected");
	}

	public void actionPerformed(ActionEvent e) {
		threadsocket.sendMessage(name + ":" + this.chatGUI.getMessage());
		this.chatGUI.clearInput();
	}

}
