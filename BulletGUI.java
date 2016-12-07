import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.net.URL;


public class BulletGUI extends JPanel implements Runnable {
    private double time;
    private double x;
    private double y;
    private double power;
    private double angle;
    private int finalX = 9999;
    private BummRoyaleGame game;
    public BulletGUI(BummRoyaleGame game,int x, int y,double power,double angle ) {
        // create thread for animation
        this.setOpaque(false);
        this.setSize(50,50);
        this.x = (double) x;
        this.y = (double) y;
        this.power = power;
        this.game = game;
        if(angle < 90) {
             this.angle = Math.toRadians(angle + 90);
        }
        else {
             this.angle = Math.toRadians(angle - 90);
        }
       
        this.time = 0.0;
        new Thread(this).start();
    } 
    @Override
    public void run() {
         
        double vx0 = Math.cos(this.angle) * (0.36 * power);
        double vy0 = Math.sin(this.angle) * (0.36 * power); 
        while (this.y <= 600) {   
                this.x = (int) (this.x - ( vx0 * this.time ));
                this.y = (int) (this.y - ( vy0 * this.time ) + (0.5 * 9.8 * this.time * this.time));
                this.setLocation((int) this.x,(int) this.y);   // update the position of bullet        
                
                try {
                    Thread.sleep(1000 / 10); // delay and yield to other threads
                    this.time = this.time + 0.1;
                } catch (InterruptedException ex) { }
        }

        game.sendFinalX((int) this.x);
        
        try {
            Thread.sleep(1500); // before bullet disappears
            this.invalidate();

        } catch (InterruptedException ex) { }
    }

    public int getFinalX(){
        return this.finalX;
    }
		

        public void paintComponent(Graphics g) { // **
			super.paintComponent(g);
            URL imgUrl = this.getClass().getClassLoader().getResource("images/fireball.gif");

            if (imgUrl == null) {
					System.err.println("Couldn't find file: images/fireball.gif");
				} else {
					try {
					ImageIcon img = new ImageIcon(imgUrl);
                    Image currImg = img.getImage();

                    Graphics2D g2d = (Graphics2D) g;
                    g2d.drawImage(currImg, 0, 0, null); 
					} catch (Exception ex) {
					ex.printStackTrace();
					}
				}
            
		
		}

}
