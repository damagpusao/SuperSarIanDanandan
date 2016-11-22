import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.net.URL;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;





//A class for drawing the avatar
public class CharPanel extends JPanel {
		private Character character;
		private ImageIcon[] imgs;	
		private int currentFrame=0;
		private int numFrames=0;
		private boolean isFlip;
		private boolean isMoving;

		public CharPanel(Character character ){
			this.character = character;
			this.animateCharacter();
			this.isFlip = false;
			this.isMoving = false;
		}
		
		//loads the Frames (Reference : Sir Mark Alfonso CMSC22 GUIThread sample)
		 private void loadImages(String[] imgFileNames) {
			numFrames = imgFileNames.length;
			imgs = new ImageIcon[numFrames];  // allocate the array
			URL imgUrl = null;
			for (int i = 0; i < numFrames; i++) {
				imgUrl = this.getClass().getClassLoader().getResource(imgFileNames[i]);
				if (imgUrl == null) {
					System.err.println("Couldn't find file: " + imgFileNames[i]);
				} else {
					try {
					imgs[i] = new ImageIcon(imgUrl);
					} catch (Exception ex) {
					ex.printStackTrace();
					}
				}
			}
		
		}

		public void animateCharacter() {
			this.loadImages (character.getImages());
			Thread walkingAnimation = new Thread () {
				@Override
				public void run() {
					while (true) {
					if(isMoving) update();   // update the position and image
					repaint();  // Refresh the display
					try {
						Thread.sleep(1000 / 10); // delay and yield to other threads
					} catch (InterruptedException ex) { }
					}
				}
			};
			walkingAnimation.start();  // start the thread to run animation
		}

		public void flipImage(boolean condition) {
			 this.isFlip = condition;
	
		}

		public void startAnimation() {
			this.isMoving = true;
		}

		public void stopAnimation() {
			this.isMoving = false;
		}

		public void update() {
			if(currentFrame < numFrames){
				currentFrame ++;
			} 
			else currentFrame = 0;
		}

		

		//draws the avatar to the panel
		public void paintComponent(Graphics g) { // **
			super.paintComponent(g);
			  if(currentFrame >= numFrames) currentFrame = 0; 
			  Image currImg = imgs[currentFrame].getImage();
    		  Graphics2D g2d = (Graphics2D) g;
			  
			  // does not flip the image
		      if(!isFlip) g2d.drawImage(currImg, 0, 0, null); 
			  //flips the image
			  else g2d.drawImage (currImg,  currImg.getWidth(this), 0, 0, currImg.getHeight(this), 
			  0, 0, currImg.getWidth(this), currImg.getHeight(this),this);

			
		}

		public Character getCharacter() {
			return this.character;
		}

	}

