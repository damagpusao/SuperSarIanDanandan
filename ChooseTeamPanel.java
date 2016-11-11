import java.awt.*;
import javax.swing.*;

public class ChooseTeamPanel extends JPanel{	
	
	public ChooseTeamPanel(JLabel chooseTeamLabel, JLabel A_B, JPanel teamA0, JPanel teamA1, JPanel teamA2, JPanel teamA3, JPanel teamB0, JPanel teamB1, JPanel teamB2, JPanel teamB3, JButton backToChar, JButton backToMenu, JButton ready, JButton start){
	
		this.setLayout(null);
		
		//Label "Choose a Team!"
		chooseTeamLabel.setFont(new Font("Liberation Serif", Font.BOLD,40));
		chooseTeamLabel.setForeground(Color.white);
		chooseTeamLabel.setBounds(450,30,600,60);

		//Label "A             B" for teams
		A_B.setFont(new Font("Algerian", Font.BOLD,40));
		A_B.setForeground(Color.white);
		A_B.setBounds(325,100,600,60);

		//team A
		teamA0.setBounds(120,170, 200, 200);
		teamA0.setBackground(Color.BLACK);
		teamA1.setBounds(350,170, 200, 200);
		teamA1.setBackground(Color.BLACK);
		teamA2.setBounds(120,390, 200, 200);
		teamA2.setBackground(Color.BLACK);
		teamA3.setBounds(350,390, 200, 200);
		teamA3.setBackground(Color.BLACK);

		//team B
		teamB0.setBounds(650,170, 200, 200);
		teamB0.setBackground(Color.BLACK);
		teamB1.setBounds(880,170, 200, 200);
		teamB1.setBackground(Color.BLACK);
		teamB2.setBounds(650,390, 200, 200);
		teamB2.setBackground(Color.BLACK);
		teamB3.setBounds(880,390, 200, 200);
		teamB3.setBackground(Color.BLACK);

		ready.setFont(new Font("Liberation Serif", Font.BOLD,25));
		ready.setForeground(Color.white);
		ready.setBounds(50,650,250,50);
		ready.setBackground(Color.RED);
		
		start.setFont(new Font("Liberation Serif", Font.BOLD,25));
		start.setForeground(Color.white);
		start.setBounds(900,650,250,50);
		start.setBackground(Color.RED);

		//"BACK TO MENU" button
		backToMenu.setFont(new Font("Algerian", Font.BOLD,13));
		backToMenu.setForeground(Color.white);
		backToMenu.setBounds(10,10,150,30);
		backToMenu.setBackground(Color.RED);

		backToChar.setFont(new Font("Algerian", Font.BOLD,13));
		backToChar.setForeground(Color.white);
		backToChar.setBounds(170,10,100,30);
		backToChar.setBackground(Color.RED);


		this.add(chooseTeamLabel);
		this.add(A_B);
		this.add(teamA0);
		this.add(teamA1);
		this.add(teamA2);
		this.add(teamA3);
		this.add(teamB0);
		this.add(teamB1);
		this.add(teamB2);
		this.add(teamB3);
		this.add(ready);
		this.add(start);
		this.add(backToChar);
		this.add(backToMenu);
		this.setBackground(new Color(10,0,40));
	}
}
