import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BummRoyale extends JFrame implements ActionListener, MouseListener{
	

	//First panel to show (Title Page)
	JLabel title = new JLabel("BUMM! Royale");
	JButton howToPlay	= new JButton("HOW TO PLAY");
	JButton play = new JButton("PLAY");
	MainPanel mainMenu = new MainPanel(title, howToPlay, play);

	//Instructions Panel
	JLabel howToLabel = new JLabel("How to Play:");
	JButton backToMenu1 = new JButton("BACK TO MENU");
	JButton proceed = new JButton("START");
	InstructionsPanel howToFrame = new InstructionsPanel(howToLabel, backToMenu1, proceed);

	//Create Character Page
	JLabel createCharLabel = new JLabel("Create Character:");
	JButton go = new JButton("ENTER ARENA!");
	JButton backToMenu2 = new JButton("BACK TO MENU");
	CreateCharPanel createChar = new CreateCharPanel(createCharLabel, go, backToMenu2);
	
	//Choose Team Panel
	JLabel chooseTeamLabel = new JLabel("Choose a Team!");
	JButton backToChar = new JButton("BACK");	
	JButton backToMenu3 = new JButton("BACK TO MENU");
	JLabel A_B = new JLabel("A                                   B");
	JPanel teamA0 = new JPanel();
	JPanel teamA1 = new JPanel();
	JPanel teamA2 = new JPanel();
	JPanel teamA3 = new JPanel();
	JPanel teamB0 = new JPanel();
	JPanel teamB1 = new JPanel();
	JPanel teamB2 = new JPanel();
	JPanel teamB3 = new JPanel();
	JButton ready = new JButton("READY!");
	JButton start = new JButton("START");
	JPanel chat1 = new JPanel();
	ChooseTeamPanel pickTeam = new ChooseTeamPanel(chooseTeamLabel, A_B, teamA0, teamA1, teamA2, teamA3, teamB0, teamB1, teamB2, teamB3, backToChar, backToMenu3, ready, start, chat1);

	//Game Start Page
	JButton quit = new JButton("QUIT");
	JPanel chat2 = new JPanel();
	GameStartPanel gameStart = new GameStartPanel(quit, chat2);


	Character character;
	public BummRoyale(){
		//sets main frame to menu
		setContentPane(mainMenu);

		howToPlay.addActionListener(this);
		proceed.addActionListener(this);
		play.addActionListener(this);
		backToMenu1.addActionListener(this);
		go.addActionListener(this);
		backToMenu2.addActionListener(this);
		backToChar.addActionListener(this);
		backToMenu3.addActionListener(this);
		start.addActionListener(this);
		quit.addActionListener(this);

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
		}else if (e.getSource() == play || e.getSource() == proceed){
			setContentPane(createChar);
		}else if (e.getSource() == backToMenu1 || e.getSource() == backToMenu2 || e.getSource() == backToMenu3 || e.getSource() == quit){
			setContentPane(mainMenu);
		}else if (e.getSource() == go){
			setContentPane(pickTeam);
		}else if (e.getSource() == start){
			gameStart.setCharacter(createChar.getCharacter());
			setContentPane(gameStart);
		}else if (e.getSource() == backToChar){
			setContentPane(createChar);
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

