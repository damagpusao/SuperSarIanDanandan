import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameStartPanel extends JPanel{	
	Image map = Toolkit.getDefaultToolkit().getImage("images/image.png");
	int x=200, y=200;
	JButton quit;
	JPanel chat;
	Character character;
	CharPanel charPanel;
	public GameStartPanel(JButton quit, JPanel chat){
		this.character = new Character(new String[]{"images/b_orange-1.png","images/b_orange-2.png"}); //default character
		this.setLayout(null);
		this.quit = quit;
		this.chat = chat;
	}

	public void init(){
		quit.setFont(new Font("Algerian", Font.BOLD,13));
		quit.setForeground(Color.white);
		quit.setBounds(10,10,100,30);
		quit.setBackground(Color.RED);

		//Chat panel
		chat.setBounds(0,620,1200,100);
		//temporary

		

		//creates the panel containing the avatar
	    charPanel = new CharPanel(this.character);
		charPanel.setLocation(500,500);
		charPanel.setSize(80,70);
		charPanel.setOpaque(false); // comment out to make visible

		//adds action to the panel containing the avatar
		MoveAvatars animation = new MoveAvatars(charPanel, 24);
		animation.addAction("LEFT", -1,  0);
		animation.addAction("RIGHT", 1,  0);
		//animation.addAction("UP",    0, -1);
		//animation.addAction("DOWN",  0,  1);

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

	public void setCharacter(Character c) {
		this.character = c;
		if(charPanel != null ) this.remove(charPanel);
		init();

	}


}
