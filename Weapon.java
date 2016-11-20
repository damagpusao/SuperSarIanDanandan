import javax.swing.ImageIcon;

public class Weapon{
    private int power;
    private int range;

    public Weapon (int power) {
        this.power = power;
    } 

    public int getPower() {
        return this.power;
    }


    public int getRange() {
        return this.range;
    }
}