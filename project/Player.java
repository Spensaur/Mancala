import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Team Cheetos
 * @author Spencer Lehrman
 * This class is used in the Model class to help organize data.
 */
public class Player {
	ArrayList<Integer> pits;
	int stonecount;
	boolean turn;
	
	/**
	 * Constructs a player.
	 * @param giveturn true for player A, false for player B
	 */
	public Player(boolean giveturn)
	{
		stonecount = 0;
		pits = new ArrayList<Integer>();
		turn = giveturn;
	}
	
	

}
