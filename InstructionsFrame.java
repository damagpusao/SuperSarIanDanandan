import java.awt.*;
import javax.swing.*;

public class InstructionsFrame extends JPanel{	
	
	public InstructionsFrame(JLabel howToLabel, JButton backToMenu){
		this.setLayout(null);
		
		/*customizes the buttons play, instructions and quit*/
		howToLabel.setFont(new Font("Algerian", Font.BOLD,40));
		howToLabel.setForeground(Color.white);
		howToLabel.setBounds(400,100,500,60);

		backToMenu.setFont(new Font("Algerian", Font.BOLD,25));
		backToMenu.setForeground(Color.white);
		backToMenu.setBounds(50,650,250,60);
		backToMenu.setBackground(Color.RED);

		StringBuilder sb = new StringBuilder(64);
    sb.append("<html>1. Choose a team. <br> 2. Pick a weapon. <br>").
    append("3. Hit the 'READY' button whenever you're ready. <br>").
	  append("4. Wait for the '<>' to start the game. </html>");

    JLabel label = new JLabel(sb.toString());
		label.setBounds(50,200,1100,500);
		label.setFont(new Font("Algerian", Font.BOLD, 30));
		label.setForeground(Color.WHITE);

		//adds the buttons to the panel
		this.add(howToLabel);
		this.add(label);
		this.add(backToMenu);
		this.setBackground(new Color(10,0,40));
	}
}
