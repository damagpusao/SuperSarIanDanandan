import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * The class that contains the state of the game.
 * The game state refers the current position of the players etc.
 * @author Joseph Anthony C. Hermocilla
 *
 */


public class GameState{
	/**
	 * This is a map(key-value pair) of <player name,NetPlayer>
	 */
	private Map<String,Character> players=new HashMap<String,Character>();
	
	/**
	 * Simple constructor
	 *
	 */
	public GameState(){}
	
	/**
	 * Update the game state. Called when player moves
	 * @param name
	 * @param player
	 */
	public void update(String name, Character player){
		players.put(name,player);
	}
	
	/**
	 * String representation of this object. Used for data transfer
	 * over the network
	 */
	public String toString(){
		String retval="";
		for(Iterator ite=players.keySet().iterator();ite.hasNext();){
			String name=(String)ite.next();
			Character player=(Character)players.get(name);
			System.out.println("GameState:" + player);
			retval+=player.toString()+":";
		}
		return retval;
	}
	
	/**
	 * Returns the map
	 * @return
	 */
	public Map getPlayers(){
		return players;
	}
}
