import java.awt.*;
import javax.swing.*;

//class for the 1st page
public class GameFrame extends JPanel{
	
	public GameFrame(JLabel title, JButton howToPlay,JButton play){
		this.setLayout(null);
		
		//welcome = Toolkit.getDefaultToolkit().getImage("welcome.jpg");

		title.setFont(new Font("Algerian", Font.BOLD,50));
		title.setForeground(Color.white);
		title.setBounds(380,200,450,60);
		
		/*customizes the buttons play, instructions and quit*/
		howToPlay.setFont(new Font("Algerian", Font.BOLD,25));
		howToPlay.setForeground(Color.white);
		howToPlay.setBounds(475,400,250,60);
		howToPlay.setBackground(Color.RED);
		
		play.setFont(new Font("Algerian", Font.BOLD,25));
		play.setForeground(Color.white);
		play.setBounds(475,480,250,60);
		play.setBackground(Color.RED);	
		
		//adds the buttons to the panel
		this.add(title);
		this.add(howToPlay);
		this.add(play);
		this.setBackground(new Color(10,0,40));
	}
	
	/*
	public void paintComponent(Graphics g){
	
		super.paintComponent(g);
		
		g.drawImage(welcome,0,0,this); //draws the image "welcome.jpg"
	}
	*/
}
