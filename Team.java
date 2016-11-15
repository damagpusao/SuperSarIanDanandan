import java.util.ArrayList;

public class Team {
    public static int teamNum = 0;
    private ArrayList<Character> teamMembers;
    private int teamNo;
    
    public Team() {
        teamMembers = new ArrayList<Character>();
        this.teamNo = this.teamNum;
        teamNum ++;
    }

    public void addMember(Character member) {
        teamMembers.add(member);
    }
    public ArrayList<Character> getMembers () {
        return this.teamMembers;
    } 

}