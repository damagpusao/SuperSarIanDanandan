import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ControlPane extends JPanel implements ActionListener {

    private JButton upPower = new JButton("\u25B4");
    private JButton downPower = new JButton("\u25BE");
    private JPanel upDownPower = new JPanel(new GridLayout(2,0));
    private JTextField powerTF = new JTextField("0");
    private JPanel powerField = new JPanel(new GridLayout(0,3));
    private JButton upAngle = new JButton("\u25B4");
    private JButton downAngle = new JButton("\u25BE");
    private JPanel upDownAngle = new JPanel(new GridLayout(2,0));
    private JTextField angleTF = new JTextField("0");
    private JPanel angleField = new JPanel(new GridLayout(0,3));
    private JButton setAngle = new JButton("Set Angle");
    private JButton setPower = new JButton("Set Power");

    private JButton fireBtn = new JButton("Fire");

    private double curAngle = 0.0;
    private double curPower = 0.0;

    private BummRoyaleGame game;
    public ControlPane(BummRoyaleGame game) {
        this.game = game;

        // row   column
        this.setLayout(new GridLayout(0,3));
        //Buttons design
        upAngle.setFont(new Font("Algerian", Font.BOLD,13));
		upAngle.setForeground(Color.white);
		upAngle.setBackground(Color.RED);	

        downAngle.setFont(new Font("Algerian", Font.BOLD,13));
		downAngle.setForeground(Color.white);
		downAngle.setBackground(Color.RED);	

        upPower.setFont(new Font("Algerian", Font.BOLD,13));
		upPower.setForeground(Color.white);
		upPower.setBackground(Color.RED);

        downPower.setFont(new Font("Algerian", Font.BOLD,13));
		downPower.setForeground(Color.white);
		downPower.setBackground(Color.RED);

        setAngle.setFont(new Font("Algerian", Font.BOLD,13));
		setAngle.setForeground(Color.white);
		setAngle.setBackground(Color.RED);
        
        setPower.setFont(new Font("Algerian", Font.BOLD,13));
		setPower.setForeground(Color.white);
		setPower.setBackground(Color.RED);

        fireBtn.setFont(new Font("Algerian", Font.BOLD,13));
		fireBtn.setForeground(Color.white);
		fireBtn.setBackground(Color.RED);
    
        upAngle.addActionListener(this);
        downAngle.addActionListener(this);
        upPower.addActionListener(this);
        downPower.addActionListener(this);
        setAngle.addActionListener(this);
        setPower.addActionListener(this);
        
        upDownPower.add(upPower);
        upDownPower.add(downPower);

        powerField.add(upDownPower);
        powerField.add(powerTF);
        powerField.add(setPower);
       
        upDownAngle.add(upAngle);
        upDownAngle.add(downAngle);

        angleField.add(upDownAngle);
        angleField.add(angleTF);
        angleField.add(setAngle);
        
        
        fireBtn.addActionListener(this);

        this.add(angleField);
        this.add(powerField);
        this.add(fireBtn);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == upPower && game.getPower() <= 100) { // increments Power by 1
            game.setPower(game.getPower() + 1) ;
        }
        else if(e.getSource() == downPower && game.getPower()>=0) { // decrements Power by 1
            game.setPower(game.getPower() - 1);
        }
        else if(e.getSource() == upAngle && game.getAngle() <= 180) { // increments Angle by 1
            game.setAngle(game.getAngle() + 1);
        }
        else if(e.getSource() == downAngle && game.getAngle()>=0) { //decrements Angle by 1
             game.setAngle(game.getAngle() - 1);
        }  
        else if(e.getSource() == setPower) { //sets Power by value in power text field
            if(Double.parseDouble(powerTF.getText()) <= 100 && Double.parseDouble(powerTF.getText()) >=0)
                game.setPower(Double.parseDouble(powerTF.getText()));
        }
        else if(e.getSource() == setAngle) { //sets Angle by value in angle text field
            if(Double.parseDouble(angleTF.getText()) <= 180 && Double.parseDouble(angleTF.getText()) >= 0)
                 game.setAngle(Double.parseDouble(angleTF.getText()));
        
        }
        else if(e.getSource() == fireBtn) { //sets Angle by value in angle text field
            game.attack();
        
        }

        powerTF.setText(game.getPower()+"");
        angleTF.setText(game.getAngle()+"");
    }

}