import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameStartPanel extends JPanel{	
	Image map = Toolkit.getDefaultToolkit().getImage("image.png");
	int x=200, y=200;
	JButton quit;
	JPanel chat;
	ImageIcon image2 = new ImageIcon(this.getClass().getResource("fish.png"));

	public GameStartPanel(JButton quit, JPanel chat){
		this.setLayout(null);
		this.quit = quit;
		this.chat = chat;

		init();
	}

	public void init(){
		quit.setFont(new Font("Algerian", Font.BOLD,13));
		quit.setForeground(Color.white);
		quit.setBounds(10,10,100,30);
		quit.setBackground(Color.RED);

		//Chat panel
		chat.setBounds(0,620,1200,100);

		//creates the panel containing the avatar
		CharPanel charPanel = new CharPanel();
		charPanel.setLocation(500,500);
		charPanel.setSize(80,70);
		charPanel.setOpaque(false); // comment out to make visible

		//adds action to the panel containing the avatar
		MoveAvatars animation = new MoveAvatars(charPanel, 24);
		animation.addAction("LEFT", -3,  0);
		animation.addAction("RIGHT", 3,  0);
		animation.addAction("UP",    0, -3);
		animation.addAction("DOWN",  0,  3);

		this.add(quit);
		this.add(charPanel);
		this.add(chat);
		this.setBackground(new Color(10,0,40));
	}

	public void paintComponent(Graphics g){
	
		super.paintComponent(g);
		
		//draws the map
		g.drawImage(map,0,0,this);
	}


}
