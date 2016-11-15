import javax.swing.ImageIcon;

public class Weapon {
    private int power;
    private ImageIcon img;
    private Character owner;

    public Weapon (int power, ImageIcon img) {
        this.power = power;
        this.img = img;
        this.owner = owner; 
    } 

    public void setOwner(Character owner) {
        this.owner = owner;
    }
}