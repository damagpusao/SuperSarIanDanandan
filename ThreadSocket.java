import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

class ThreadSocket extends Thread{
    private Socket SOCK;
    private BufferedReader input;
    private PrintStream output;
    private MessageDetector msg_detector;
    public ThreadSocket (Socket s, MessageDetector msg_detector){
        this.SOCK = s;
        this.msg_detector = msg_detector;
    }

    public void run() {
        try {
            InputStreamReader reader = new InputStreamReader(SOCK.getInputStream());
			input = new BufferedReader(reader);
			output = new PrintStream(SOCK.getOutputStream());
        
            while(true) {
                try {
                    String msg = input.readLine();

                    if(msg_detector != null) {
                        msg_detector.receivedMessage(this,msg);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
             }
        }

        catch (Exception e) {
            e.printStackTrace();
        }     		
    }

    public void sendMessage(String message) {
            if(message != null || message != "") {
                output.println(message);
                output.flush();
            } 
            
    }
}