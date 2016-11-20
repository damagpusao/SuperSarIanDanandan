/*
This is a class for handing key events to move the avatar of the game.

Reference:
https://tips4java.wordpress.com/2013/06/09/motion-using-the-keyboard/
*/


import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.Map;
import java.util.HashMap;
import javax.swing.*;
import java.awt.Point;

public class MoveAvatars implements ActionListener
{
	private final static String PRESSED = "pressed ";
	private final static String RELEASED = "released ";

	private JComponent component;
	private JComponent component2;
	private Timer timer;
	private Map<String, Point> pressedKeys = new HashMap<String, Point>();
	private String previousKey = "";

	public MoveAvatars(JComponent component, JComponent component2, int delay)
	{
		this.component = component;
		this.component2 = component2;

		timer = new Timer(delay, this);
		timer.setInitialDelay( 0 );
	}

	/*
	*  &param keyStroke - see KeyStroke.getKeyStroke(String) for the format of
	*                     of the String. Except the "pressed|released" keywords
	*                     are not to be included in the string.
	*/
	public void addAction(String keyStroke, int deltaX, int deltaY)
	{
		//  Separate the key identifier from the modifiers of the KeyStroke
		int offset = keyStroke.lastIndexOf(" ");
		String key = offset == -1 ? keyStroke :  keyStroke.substring( offset + 1 );
		String modifiers = keyStroke.replace(key, "");

		//  Get the InputMap and ActionMap of the component
		InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = component.getActionMap();

		//  Create Action and add binding for the pressed key
		Action pressedAction = new AnimationAction(key, new Point(deltaX, deltaY));
		String pressedKey = modifiers + PRESSED + key;
		KeyStroke pressedKeyStroke = KeyStroke.getKeyStroke(pressedKey);
		inputMap.put(pressedKeyStroke, pressedKey);
		actionMap.put(pressedKey, pressedAction);

		//  Create Action and add binding for the released key
		Action releasedAction = new AnimationAction(key, null);
		String releasedKey = modifiers + RELEASED + key;
		KeyStroke releasedKeyStroke = KeyStroke.getKeyStroke(releasedKey);
		inputMap.put(releasedKeyStroke, releasedKey);
		actionMap.put(releasedKey, releasedAction);
	}

	//  Invoked whenever a key is pressed or released
	private void handleKeyEvent(String key, Point moveDelta)
	{
		
		//  Keep track of which keys are pressed
		if (moveDelta == null){
			pressedKeys.remove( key );
		}else{
			pressedKeys.put(key, moveDelta);
		}

		//  Start the Timer when the first key is pressed
   	if (pressedKeys.size() == 1){
   		timer.start();
		CharPanel cpanel = (CharPanel) component;
		if(key.equals("LEFT")) { // change direction of UI  **
			cpanel.flipImage(true);
		}
		else if(key.equals("RIGHT")){
			cpanel.flipImage(false);
		}

		previousKey = key; // stores current key as previous key **
	
		cpanel.startAnimation(); // **
		}

		//  Stop the Timer when all keys have been released
   	if (pressedKeys.size() == 0){
  		 timer.stop();
		 CharPanel cpanel = (CharPanel) component; // stops animation of the character **
		 cpanel.stopAnimation(); // **
		}
	}

	//  Invoked when the Timer fires
	public void actionPerformed(ActionEvent e){
		moveComponent();
	}

	//  Move the component to its new location
	private void moveComponent()
	{
		int componentWidth = component.getSize().width;
		int componentHeight = component.getSize().height;

		Dimension parentSize = component.getParent().getSize();
		int parentWidth  = parentSize.width;
		int parentHeight = 620;

		//  Calculate new move
		int deltaX = 0;
		int deltaY = 0;

		for (Point delta : pressedKeys.values()){
			deltaX += delta.x;
			deltaY += delta.y;
		}

		//  Determine next X position
		int nextX = Math.max(component.getLocation().x + deltaX, 0);

		if ( nextX + componentWidth > parentWidth){
			nextX = parentWidth - componentWidth;
		}

		//  Determine next Y position
		int nextY = Math.max(component.getLocation().y + deltaY, 0);

		if ( nextY + componentHeight > parentHeight){
			nextY = parentHeight - componentHeight;
		}

		//  Move the component
		CharPanel cpanel = (CharPanel) component;
		component.setLocation(nextX, nextY);
		component2.setLocation(nextX+3, nextY+17);
		cpanel.getCharacter().setPos(nextX, nextY);
	}

	//  Action to keep track of the key and a Point to represent the movement
	//  of the component. A null Point is specified when the key is released.
	private class AnimationAction extends AbstractAction implements ActionListener
	{
		private Point moveDelta;

		public AnimationAction(String key, Point moveDelta){
			super(key);

			this.moveDelta = moveDelta;
		}

		public void actionPerformed(ActionEvent e){
			handleKeyEvent((String)getValue(NAME), moveDelta);
		}
	}
}
