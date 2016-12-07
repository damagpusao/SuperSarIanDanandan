import java.util.*;
import java.awt.event.*;

public class BummRoyaleGame{
  private int playerTeamA;
  private int playerTeamB;
  private boolean curTeam; //true = teamA , false = teamB
  private int totalPlayers;
  private String curPlayer;
  private Character player;
  private double curPower = 0;
  private double curAngle = 0;
  private HashMap<String, Integer> players_map;
  private ArrayList<String> teamA;
  private ArrayList<String> teamB; 
  private BummRoyale GUI;

  public BummRoyaleGame(BummRoyale gui) {
    this.GUI = gui;
  }
  public boolean addCharacter(String name, int team, int x, int y){
    int distance = (int) Math.sqrt( (player.getPos()[0] - x ) * (player.getPos()[0] - x ) + (player.getPos()[1] - y ) * (player.getPos()[1] - y )  ); 
    players_map.put(name, distance);
    if(team == 1 && teamA.size()<(totalPlayers/2)) {
     teamA.add(name);
      return true;
    }
    else if(team == 2 && teamB.size()<(totalPlayers/2)){
      teamB.add(name);
      return true;
    }
    else return false;
  }


  public void setAngle(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_UP && curAngle<=180) {
      curAngle++;
    }
    else if(e.getKeyCode() == KeyEvent.VK_DOWN && curAngle >= 0){
      curAngle--;
    } 
  }

  public double getPower() { 
    return this.curPower;
  }

  public double getAngle() { 
    return this.curAngle;
  }

  public void setTurn(String name) {
    this.curPlayer = name;
  }

  public void setPower(double power) {
    this.curPower = power;
  }

  public void setAngle(double angle) {
    this.curAngle = angle;
  }

  public void setCharacter(Character character) {
    this.player = character;
  }

  
  public void attack() {
    System.out.println(player.getName());
    BulletGUI b = new BulletGUI(this,player.getPos()[0], player.getPos()[1], (double)this.curPower, (double)this.curAngle);
    this.GUI.gameStart.add(b);
  
  }

  public void getDamagePlayers(double x) {
   /* String damagedPlayers = "dmp: ";
    for (int key: players_map.keySet()) {
       if(key > (x - this.player.getWeapon().getRange()) && key < (x + this.player.getWeapon().getRange()) ) {
         damagedPlayers = damagedPlayers + players_map.get(key) + ", ";
       } 
    }*/
  }

  public void sendFinalX(int finalX) {
    this.GUI.gameStart.send("ATTACK "+player.getName()+" "+finalX+" ");
  }


}