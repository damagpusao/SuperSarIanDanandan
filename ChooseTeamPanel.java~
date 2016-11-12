import java.awt.*;
import javax.swing.*;

public class ChooseTeamPanel extends JPanel{
		JLabel chooseTeamLabel, A_B;
	  JPanel teamA0, teamA1, teamA2, teamA3, teamB0, teamB1, teamB2, teamB3, chat;
	  JButton backToChar, backToMenu, ready, start;
	
	public ChooseTeamPanel(JLabel chooseTeamLabel, JLabel A_B, JPanel teamA0, JPanel teamA1, JPanel teamA2, JPanel teamA3, JPanel teamB0, JPanel teamB1, JPanel teamB2, JPanel teamB3, JButton backToChar, JButton backToMenu, JButton ready, JButton start, JPanel chat){
	
		this.setLayout(null);

		this.chooseTeamLabel = chooseTeamLabel;
		this.A_B = A_B;
	  this.teamA0 = teamA0;
		this.teamA1 = teamA1;
		this.teamA2 = teamA2;
		this.teamA3 = teamA3;
	  this.teamB0 = teamB0;
		this.teamB1 = teamB1;
	  this.teamB2 = teamB2;
		this.teamB3 = teamB3;
		this.backToChar = backToChar;
	  this.backToMenu = backToMenu;
		this.ready = ready;
		this.start = start;
		this.chat = chat;
	
		init();
	}		
	
	public void init(){
		//Label "Choose a Team!"
		chooseTeamLabel.setFont(new Font("Liberation Serif", Font.BOLD,40));
		chooseTeamLabel.setForeground(Color.white);
		chooseTeamLabel.setBounds(450,30,600,60);

		//Label "A             B" for teams
		A_B.setFont(new Font("Algerian", Font.BOLD,40));
		A_B.setForeground(Color.white);
		A_B.setBounds(325,100,600,60);

		//team A
		teamA0.setBounds(120,170, 150, 150);
		teamA0.setBackground(Color.BLACK);
		teamA1.setBounds(350,170, 150, 150);
		teamA1.setBackground(Color.BLACK);
		teamA2.setBounds(120,330, 150, 150);
		teamA2.setBackground(Color.BLACK);
		teamA3.setBounds(350,330, 150, 150);
		teamA3.setBackground(Color.BLACK);

		//team B
		teamB0.setBounds(650,170, 150, 150);
		teamB0.setBackground(Color.BLACK);
		teamB1.setBounds(880,170, 150, 150);
		teamB1.setBackground(Color.BLACK);
		teamB2.setBounds(650,330, 150, 150);
		teamB2.setBackground(Color.BLACK);
		teamB3.setBounds(880,330, 150, 150);
		teamB3.setBackground(Color.BLACK);

		ready.setFont(new Font("Liberation Serif", Font.BOLD,25));
		ready.setForeground(Color.white);
		ready.setBounds(50,500,250,50);
		ready.setBackground(Color.RED);
		
		start.setFont(new Font("Liberation Serif", Font.BOLD,25));
		start.setForeground(Color.white);
		start.setBounds(900,500,250,50);
		start.setBackground(Color.RED);

		//Chat panel
		chat.setBounds(0,620,1200,100);
		
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
		this.add(chat);	
		this.add(backToChar);
		this.add(backToMenu);
		this.setBackground(new Color(10,0,40));
	}
}
