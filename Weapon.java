import javax.swing.ImageIcon;

public class Weapon{
    private int power;
    private int range;

    public Weapon (int power,int range) {
        this.power = power;
        this.range = range;
    } 

    public int getPower() {
        return this.power;
    }


    public int getRange() {
        return this.range;
    }


}