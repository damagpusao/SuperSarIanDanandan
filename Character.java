import java.awt.Point;


public class Character {
    private int hp;
    public int xPos;
    public int yPos;
    private double prevAngle; //saves previous attack state
    private double prevPower;
    private String[] image_frames;
    private Weapon weapon;
    private int team;
    private boolean is_died;
    private String name;

    public Character(String name,String[] img_frames, Weapon weapon) {
        this.weapon = weapon;
        this.name = name;
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

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    public String[] getImages() {
        return this.image_frames;
    }

    public String getName() {
        return this.name;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public int getTeam() {
        return this.team;
    }

    public void setTeam(int team) {
       this.team = team;
    }

    public String toString(){
		String retval="";
		retval+="PLAYER ";
		retval+=name+" ";
		retval+=xPos+" ";
		retval+=yPos+" ";
        retval+=hp+" ";
        retval+=weapon.getPower()+" ";
        retval+=weapon.getRange()+" ";
		return retval;
	}	

    public void saveAttackState(double angle, double power) {
        this.prevAngle = angle;
        this.prevPower = power;
    }
}


    

