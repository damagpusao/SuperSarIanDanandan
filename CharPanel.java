import java.awt.*;
import javax.swing.*;

public class CharPanel extends JPanel {
		ImageIcon img;	

		public CharPanel(){
			this.img = new ImageIcon(this.getClass().getResource("fish.png"));

		}
		public void paintComponent(Graphics g) {

			super.paintComponent(g);
		  img.paintIcon(this, g, 0,0);
		}

	}

