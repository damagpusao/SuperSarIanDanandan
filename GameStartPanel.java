import java.awt.*;
import javax.swing.*;

public class GameStartPanel extends JPanel{	
	Image image;	

	public GameStartPanel(JButton quit){
		this.setLayout(null);

		image = Toolkit.getDefaultToolkit().getImage("image.png");

	
		quit.setFont(new Font("Algerian", Font.BOLD,13));
		quit.setForeground(Color.white);
		quit.setBounds(10,10,100,30);
		quit.setBackground(Color.RED);

		this.add(quit);
		this.setBackground(new Color(10,0,40));
	}

	public void paintComponent(Graphics g){
	
		super.paintComponent(g);
		
		g.drawImage(image,0,0,this); //draws the image "welcome.jpg"
	}

}
