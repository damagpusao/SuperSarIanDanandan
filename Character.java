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
    private String look;

    public Character(String look) {
        this.is_died = false;
        this.hp = 1000;
        this.look = look;

        if(look == "char1") {
			System.out.println("char1");
			image_frames = new String[] {"images/b_orange-1.png","images/b_orange-2.png"};
		}
		else if(look == "char2") {
			System.out.println("char2");
			 image_frames = new String[] {"images/b_red-1.png","images/b_red-2.png"};
		}
		else if(look == "char3") {
			System.out.println("char3");
			 image_frames = new String[] {"images/g_pink-1.png","images/g_pink-2.png"};
		}
		else if(look== "char4") {
			System.out.println("char4");
			image_frames = new String[] {"images/g_green-1.png","images/g_green-2.png"};
		}

      
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

    public void setName(String name) {
       this.name = name;
    }

    public String toString(){
		String retval="";
		retval+="PLAYER ";
		retval+=name+" ";
		retval+=xPos+" ";
		retval+=yPos+" ";
        retval+=hp+" ";
        retval+=look+" ";
		return retval;
	}	

    public void saveAttackState(double angle, double power) {
        this.prevAngle = angle;
        this.prevPower = power;
    }
}


    

