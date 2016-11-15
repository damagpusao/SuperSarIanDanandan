import java.awt.Point;

public class Character {
    private int hp;
    private Point pos;
    private String[] image_frames;
    private Weapon weapon;
    private int team;
    private boolean is_died;

    public Character(String[] img_frames) {

        this.is_died = false;
        this.hp = 1000;
        this.image_frames = img_frames;
    } 

    public Point getPos() {
        return this.pos;
    }

    public void setPos(Point position) {
        this.pos.setLocation(position);
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public String[] getImages() {
        return this.image_frames;
    }


    

} 