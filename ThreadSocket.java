import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.IOException;

class ThreadSocket extends Thread{
    private Socket SOCK;
    private BufferedReader input;
    private PrintStream output;
    private MessageDetector msg_detector;
    private boolean isRunning;
    public ThreadSocket (Socket s, MessageDetector msg_detector){
        this.SOCK = s;
        this.msg_detector = msg_detector;
        isRunning = true;
    }

    public void run() {
        try {
            InputStreamReader reader = new InputStreamReader(SOCK.getInputStream());
			input = new BufferedReader(reader);
			output = new PrintStream(SOCK.getOutputStream());
        
            while(isRunning) {
                try {
                    String msg = input.readLine();

                    if(msg_detector != null) {
                        msg_detector.receivedMessage(this,msg);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                   System.out.println("ThreadSocket loop");
                   this.stopThreadSocket();
                }
             }
             if(msg_detector != null)
				msg_detector.onDisconnected(this);
        }

         catch (Exception e) {
            e.printStackTrace();
           System.out.println("ThreadSocket out");
        }     		
    }

    public void sendMessage(String message) {
            if(message != null || message != "") {
                output.println(message);
                output.flush();
            } 
            
    }

    public void stopThreadSocket() {
        isRunning = false;
       try {
            SOCK.close();
       }
       catch(IOException err) {
           err.printStackTrace();
          System.out.println("neww tread");
       }
       
    }
}