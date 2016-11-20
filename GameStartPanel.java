import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class GameStartPanel extends JPanel implements KeyListener{	
	Image map = Toolkit.getDefaultToolkit().getImage("images/bg.jpg");
	int x=200, y=200;
	JButton quit;
	Character character;
	CharPanel charPanel;
	BummRoyaleGame game;
	WeaponGUI weaponG;
	Boolean isRunning;

	public GameStartPanel(JButton quit,BummRoyaleGame game){
		this.setLayout(null);
		this.quit = quit;
		this.game = game;
		this.isRunning = true;
	}

	public void init(){
		ControlPane cp = new ControlPane(game);
		cp.setBounds(110,0,1090,50);
		quit.setFont(new Font("Algerian", Font.BOLD,13));
		quit.setForeground(Color.white);
		quit.setBounds(10,10,100,30);
		quit.setBackground(Color.RED);		

		//creates the panel containing the avatar
	    charPanel = new CharPanel(this.character);	


		//random placement of character (player)
		Random r = new Random();
		int xRand = r.nextInt(1100 - 100 + 1) + 100;
		charPanel.setLocation(xRand,500);
		charPanel.setSize(80,70);
		charPanel.setOpaque(false);

		weaponG = new WeaponGUI(new Weapon(20));
		weaponG.setSize(80,70);
		weaponG.setOpaque(false);
		weaponG.setLocation(xRand+3,517);

		//adds action to the panel containing the avatar
		MoveAvatars animation = new MoveAvatars(charPanel,weaponG, 24);
		animation.addAction("LEFT", -1,  0);
		animation.addAction("RIGHT", 1,  0);
		//animation.addAction("UP",    0, -1);
		//animation.addAction("DOWN",  0,  1);


		JPanel controlsPane = new JPanel();
		controlsPane.setLayout(new FlowLayout());
		JTextField powerField = new JTextField();
		JTextField angle = new  JTextField();

		this.add(cp);
		this.add(quit);
		this.add(weaponG);
		this.add(charPanel);
		
		this.setBackground(new Color(10,0,40));


		Thread angleAnimation = new Thread () {
			@Override
			public void run() {
				while (isRunning) {
				weaponG.setAngle(game.getAngle()*-1.0);
				weaponG.repaint();  // Refresh the display
				try {
					Thread.sleep(1000 / 10); // delay and yield to other threads
				} catch (InterruptedException ex) { }
				}
			}
		};
		angleAnimation.start();  // start the thread to run animation
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

	public void start() {
		this.isRunning = true;
	}

	public void stop(){
		this.isRunning = false;
	}

	public WeaponGUI getWeapon() {
		return this.weaponG;
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

}
