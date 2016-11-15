import java.awt.Point;


public class Character {
    private int hp;
    private int xPos;
    private int yPos;
    private String[] image_frames;
    private Weapon weapon;
    private int team;
    private boolean is_died;

    public Character(String[] img_frames) {

        this.is_died = false;
        this.hp = 1000;
        this.image_frames = img_frames;
    } 

    public int[] getPos() {
        return new int[]{xPos,yPos};
    }

    public void setPos(int posX, int posY) {
        this.xPos = posX;
        this.yPos = posY;
    }

    public int attack(double velocity, double angle, int targetX ) {

        double range = (((velocity) * (velocity) ) * Math.sin(angle) )/9.8;
        int rangeInt = (int)Math.round(range) + this.xPos;
        if(rangeInt >= targetX - 38 && rangeInt <= targetX + 38) {
            return this.weapon.getPower();
        }
        else return 0;
    } 

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    public String[] getImages() {
        return this.image_frames;
    }


    

} 