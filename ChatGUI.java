import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.text.DefaultCaret;

public class ChatGUI extends JPanel{
    private JTextArea textArea;
    private String content;
    private JScrollPane jScrollPane1;
    private JTextField myMessage;
    private JButton sendMsgBtn;
    private TCPClient client;
    //simple constructor
    public ChatGUI() {
        this.setBounds(0,700,1200,100);
        content = "";
        this.setLayout(new BorderLayout());
	    textArea = new JTextArea();
        textArea.setColumns(110);
        textArea.setLineWrap(true);
        textArea.setRows(4);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setText(content);
        DefaultCaret caret = (DefaultCaret)textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		jScrollPane1 = new JScrollPane(textArea);

        myMessage = new JTextField (102);
        myMessage.setText("Enter Message");
        myMessage.setEditable(true);
        sendMsgBtn = new JButton("Send");
      
        
        JPanel inputContainer = new JPanel();
        inputContainer.setLayout(new BorderLayout());
        inputContainer.add(myMessage,BorderLayout.LINE_START);
        inputContainer.add(sendMsgBtn,BorderLayout.LINE_END);

        this.add(jScrollPane1,BorderLayout.CENTER);
        this.add(inputContainer,BorderLayout.PAGE_END);

    }

    public void addClient(TCPClient client) {
        this.client = client;
        sendMsgBtn.addActionListener(client);
    }

    public void addMessage(String message) {
        content  = content + "\n" + message;
        textArea.setText(content);
    }  

    public String getMessage() {
        return myMessage.getText();
    }

    public void clearInput() {
        myMessage.setText("");
    }

  /*  public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sendMsgBtn) {
            this.addMessage(myMessage.getText());
            myMessage.setText("");
        } 
    }*/ 
}