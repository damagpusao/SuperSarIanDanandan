import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BummRoyale extends JFrame implements ActionListener, MouseListener{
	
	//First panel to show
	JLabel title = new JLabel("BUMM! Royale");
	JButton howToPlay	= new JButton("HOW TO PLAY");
	JButton play = new JButton("PLAY");
	GameFrame mainMenu = new GameFrame(title, howToPlay, play);

	JLabel howToLabel = new JLabel("HOW TO PLAY:");
	JButton backToMenu = new JButton("BACK TO MENU");
	InstructionsFrame howToFrame = new InstructionsFrame(howToLabel, backToMenu);

	public BummRoyale(){
	
		//sets main frame to menu
		setContentPane(mainMenu);

		howToPlay.addActionListener(this);
		play.addActionListener(this);
		backToMenu.addActionListener(this);

		//specifications for window
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); //gets the screensize
		int screenHeight = screenSize.height; //gets the screen height
		int screenWidth = screenSize.width; //gets the screen width
		
		setBounds(0,0,1200,800);
		//setBounds(screenWidth/6,screenHeight/16,1200,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	//for ActionListener
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == howToPlay){
			setContentPane(howToFrame);
		}else if (e.getSource() == play){

		}else if (e.getSource() == backToMenu){
			setContentPane(mainMenu);
		}
		setVisible(true);
	}
	
	//for MouseListener
	public void mouseClicked(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	
	//main function
	public static void main(String args[]){
		new BummRoyale();
	}	
}

