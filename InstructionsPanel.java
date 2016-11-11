import java.awt.*;
import javax.swing.*;

public class InstructionsPanel extends JPanel{	
	
	public InstructionsPanel(JLabel howToLabel, JButton backToMenu, JButton start){
		this.setLayout(null);
		
		howToLabel.setFont(new Font("Liberation Serif", Font.BOLD,40));
		howToLabel.setForeground(Color.white);
		howToLabel.setBounds(445,30,600,60);

		backToMenu.setFont(new Font("Algerian", Font.BOLD,13));
		backToMenu.setForeground(Color.white);
		backToMenu.setBounds(10,10,150,30);
		backToMenu.setBackground(Color.RED);
 
		StringBuilder sb = new StringBuilder(64);
    sb.append("<html>1. Hit the START button. <br> 2. Enter the name of your avatar and pick a gender. <br>");
    sb.append("3. After clicking 'GO', if you're the first to enter the arena,<br>");
		sb.append("&nbsp&nbsp&nbsp you will have the power to start the game.<br>");
	  sb.append("4. All players must hit the READY! button before the game <br>&nbsp&nbsp&nbsp can start. <br>");
		sb.append("5. The number of avatars for each team must be equal. </html>");

    JLabel label = new JLabel(sb.toString());
		label.setBounds(50,200,1100,400);
		label.setFont(new Font("Liberation Serif", Font.BOLD, 37));
		label.setForeground(Color.WHITE);

		start.setFont(new Font("Liberation Serif", Font.BOLD,25));
		start.setForeground(Color.white);
		start.setBounds(900,650,250,50);
		start.setBackground(Color.RED);


		//adds the buttons to the panel
		this.add(howToLabel);
		this.add(label);
		this.add(backToMenu);
		this.add(start);
		this.setBackground(new Color(10,0,40));
	}
}
