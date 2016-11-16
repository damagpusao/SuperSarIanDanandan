import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameStartPanel extends JPanel implements KeyListener{	
	Image map = Toolkit.getDefaultToolkit().getImage("images/bg.jpg");
	int x=200, y=200;
	JButton quit;
	Character character;
	CharPanel charPanel;
//	BummRoyalGame game;
	public GameStartPanel(JButton quit){
	//	this.character = new Character(new String[]{"images/b_orange-1.png","images/b_orange-2.png"}); //default character
		this.setLayout(null);
		this.quit = quit;

	}

	public void init(){
		quit.setFont(new Font("Algerian", Font.BOLD,13));
		quit.setForeground(Color.white);
		quit.setBounds(10,10,100,30);
		quit.setBackground(Color.RED);		

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

		JPanel controlsPane = new JPanel();
		controlsPane.setLayout(new FlowLayout());
		JTextField powerField = new JTextField();
		JTextField angle = new  JTextField();

		this.add(quit);
		this.add(charPanel);
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

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
			case KeyEvent.VK_UP:
				// handle up 
				break;
			case KeyEvent.VK_DOWN:
				// handle down 
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

//	public void addGame(BummRoyalGame game) {
//		this.game = game;
//	} 

}
