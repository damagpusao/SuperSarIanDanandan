import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.net.URL;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class WeaponGUI extends JPanel{
    private final String src="images/weapon.png";
    private Weapon weapon;
    private ImageIcon image;
    private double angle = -90;
    private boolean isMoving;
    private AffineTransform transform = new AffineTransform();

    public WeaponGUI(Weapon weapon) {
        this.weapon = weapon;
        this.loadImage();
    }

    @Override

    public void paintComponent(Graphics g) { // **
			super.paintComponent(g);
			Image currImg = image.getImage();

    		Graphics2D g2d = (Graphics2D) g;

            transform.setToIdentity();
            transform.rotate(Math.toRadians(angle),
            currImg.getWidth(null) / 2, currImg.getHeight(null) / 2);
            g2d.drawImage(currImg, transform, null);
			
			
		}

    public void setAngle(double angle) {
        this.angle = angle;
    }


    public void loadImage(){
        URL imgUrl = this.getClass().getClassLoader().getResource(this.src);
        if (imgUrl == null) {
            System.err.println("Couldn't find file: " + this.src);
        } 
        else {
            try {
                this.image = new ImageIcon(imgUrl);
            } 
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

/*
	public void animateWeapon() {
			this.loadImage ();
			Thread angleAnimation = new Thread () {
				@Override
				public void run() {
					while (true) {
					repaint();  // Refresh the display
					try {
						Thread.sleep(1000 / 10); // delay and yield to other threads
					} catch (InterruptedException ex) { }
					}
				}
			};
			angleAnimation.start();  // start the thread to run animation
		}
*/
}