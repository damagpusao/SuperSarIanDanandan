import java.util.*;
import java.awt.event.*;

public class BummRoyaleGame{
  // private Map players_map = new HashMap();
  private int playerTeamA;
  private int playerTeamB;
  private boolean curTeam; //true = teamA , false = teamB
  private int totalPlayers;
  private String player;
  private double curPower = 0;
  private double curAngle = 0;
  private ArrayList<String> teamA;
  private ArrayList<String> teamB; 


  public boolean addCharacter(String name, int team){
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



  /* TO DO : Dana Magpusao */

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
    this.player = name;
  }

  public void setPower(double power) {
    this.curPower = power;
  }

  public void setAngle(double angle) {
    this.curAngle = angle;
  }

  public void attack() {
    //curPlayer.attack(curPower,curAngle);
    //resets curPower & curAngle 
    //find match sa list of players <-- TO DO
    this.curPower = 0;
    this.curAngle = 0;

    if(this.curTeam) {
      this.playerTeamA = teamA.size() % (this.playerTeamA + 1); 
      this.curTeam = false;
      this.setTurn(teamB.get(playerTeamB));
    }
    else {
      this.playerTeamB = teamB.size() % (this.playerTeamB + 1); 
      this.curTeam = true;
      this.setTurn(teamB.get(playerTeamA));
    } 
  }


}