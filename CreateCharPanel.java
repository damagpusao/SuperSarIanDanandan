import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.*;
public class CreateCharPanel extends JPanel{
	JLabel nameLabel = new JLabel("Avatar Name:");	
	JTextArea enterName = new JTextArea("Aura");
	JPanel enterNamePanel = new JPanel();
	JLabel createCharLabel;
	JButton go, backToMenu;
	Character character;
	
	
	public CreateCharPanel(JLabel createCharLabel, JButton go, JButton backToMenu){
		this.setLayout(null);
		
		this.createCharLabel = createCharLabel;
		this.go = go;
		this.backToMenu = backToMenu;

		init();
	}

	public void init(){

		//Label "Create your Character:"
		createCharLabel.setFont(new Font("Liberation Serif", Font.BOLD,40));
		createCharLabel.setForeground(Color.white);
		createCharLabel.setBounds(440,30,600,60);

		nameLabel.setFont(new Font("Liberation Serif", Font.BOLD,24));
		nameLabel.setBounds(520,420,200,50);
		nameLabel.setForeground(Color.WHITE);
		enterName.setFont(new Font("Liberation Serif", Font.BOLD,20));
		enterName.setBounds(0,0,250,60);
		enterNamePanel.setBounds(470,480,250,60);
		enterNamePanel.add(enterName);

		go.setFont(new Font("Liberation Serif", Font.BOLD,25));
		go.setForeground(Color.white);
		go.setBounds(900,600,250,50);
		go.setBackground(Color.RED);

    ActionListener al = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				charSelect(e);
			}
		};

		JButton char1 = new JButton("char1");
		char1.addActionListener(al);
		char1.setForeground(Color.white);
		char1.setBounds(170,200,200,200);
		try {
			Image img = ImageIO.read(getClass().getResource("images/b_orange-large.png"));
			char1.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}

		JButton char2 = new JButton("char2");
		
		char2.addActionListener(al);
		char2.setForeground(Color.white);
		char2.setBounds(380,200,200,200);
		try {
			Image img = ImageIO.read(getClass().getResource("images/b_red-large.png"));
			char2.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}

		JButton char3 = new JButton("char3");
		char3.addActionListener(al);
		char3.setForeground(Color.white);
		char3.setBounds(590,200,200,200);
		try {
			Image img = ImageIO.read(getClass().getResource("images/g_pink-large.png"));
			char3.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}


		JButton char4 = new JButton("char4");
		char4.addActionListener(al);
		char4.setForeground(Color.white);
		char4.setBounds(800,200,200,200);
		try {
			Image img = ImageIO.read(getClass().getResource("images/g_green-large.png"));
			char4.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}


		//"BACK TO MENU" button
		backToMenu.setFont(new Font("Algerian", Font.BOLD,13));
		backToMenu.setForeground(Color.white);
		backToMenu.setBounds(10,10,150,30);
		backToMenu.setBackground(Color.RED);

		this.add(char1);
		this.add(char2);
		this.add(char3);
		this.add(char4);
		this.add(createCharLabel);
		this.add(nameLabel);		
		this.add(enterNamePanel);
		this.add(go);
		this.add(backToMenu);
		this.setBackground(new Color(10,0,40));
	}

	private void charSelect(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String[] imgs = null;
		if(btn.getText() == "char1") {
			System.out.println("char1");
			imgs = new String[] {"images/b_orange-1.png","images/b_orange-2.png"};
		}
		else if(btn.getText() == "char2") {
			System.out.println("char2");
			 imgs = new String[] {"images/b_red-1.png","images/b_red-2.png"};
		}
		else if(btn.getText() == "char3") {
			System.out.println("char3");
			 imgs = new String[] {"images/g_pink-1.png","images/g_pink-2.png"};
		}
		else if(btn.getText() == "char4") {
			System.out.println("char4");
			imgs = new String[] {"images/g_green-1.png","images/g_green-2.png"};
		}
		if(enterName.getText() != "")
			this.character = new Character(enterName.getText(), imgs);
	}

	public Character getCharacter() {
		return this.character;
	}


}
