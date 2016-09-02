import java.util.ArrayList;

import javax.swing.event.ChangeListener;

/**
 * Team Cheetos
 * @author Spencer Lehrman
 * Data Model for the Mancala.
 */
public class Model {
	
	Player A;
	Player B;
	Player previousA;
	Player previousB;
	//true = player A turn
	//false = player B turn
	boolean turn = true;
	int undoCount = 3;
	boolean undocheck = false;
	boolean anothermove = false;
	ArrayList<ChangeListener> listeners;
	String status = "";
	
	/**
	 * Constructs a data model for the mancala.
	 */
	public Model()
	{
		A = new Player(true);
		B = new Player(false);
		listeners = new ArrayList<ChangeListener>();
	}
	
	/**
	 * 
	 * @param number initializes the pits to this number
	 */
	public void initialStones(int number)
	{
		for (int i = 0; i < 6; i++)
		{
			A.pits.add(number);
			B.pits.add(number);
		}
	}
	
	/**
	 * 
	 * @param checkturn true if A, false if B
	 * @param pitnumber number of the pit
	 */
	public void mainMove(boolean checkturn, int pitnumber)
	{
		
		if (checkturn == turn && checkturn == true)
		{
			if(A.pits.get(pitnumber) != 0)
			{
				previousA = A;
				previousB = B;
				int stones = A.pits.get(pitnumber);
				A.pits.set(pitnumber, 0);
				int pit = pitnumber;
				boolean extraturn = false;
				boolean player = true;
				while (stones > 0)
				{
					if (pit == 5)
					{
						//check which side
						if (player == true)
						{
							A.stonecount = A.stonecount +1;
							stones--;
							if (stones == 0)
							{
								extraturn = true;
								System.out.println("extraturn!");
							}
							System.out.println("you got a point!");
							System.out.println("total points:" + A.stonecount);
						}
						player = !player;
						pit = -1;
					}
					else
					{
						pit++;
						if (player == true)
						{
							A.pits.set(pit, A.pits.get(pit)+1);
						}
						else
						{
							B.pits.set(pit, B.pits.get(pit)+1);
						}
						stones--;
						//check for stone capture
						if(stones == 0 && player == true && A.pits.get(pit-1) == 1)
						{
							pit--;
							int captured = B.pits.get(5 - pit);
							B.pits.set(5 - pit, 0);
							A.stonecount += captured;
							
						}
					}
				}
				if (extraturn == false)
				{
					turn = !turn;
					anothermove = false;
				}
				else
				{
					anothermove = true;
				}
				undocheck = true;
				endgame(A, B);
				
			}
		}
		if (checkturn == turn && checkturn == false)
		{
			if(B.pits.get(pitnumber) != 0)
			{
				previousA = A;
				previousB = B;
				int stones = B.pits.get(pitnumber);
				B.pits.set(pitnumber, 0);
				int pit = pitnumber;
				boolean extraturn = false;
				boolean player = true;
				while (stones > 0)
				{
					if (pit == 5)
					{
						//check which side
						if (player == true)
						{
							B.stonecount = B.stonecount +1;
							stones--;
							if (stones == 0)
							{
								extraturn = true;
								System.out.println("extraturn!");
							}
							System.out.println("you got a point!");
							System.out.println("total points:" + B.stonecount);
						}
						player = !player;
						pit = -1;
					}
					else
					{
						pit++;
						if (player == true)
						{
							B.pits.set(pit, B.pits.get(pit)+1);
						}
						else
						{
							A.pits.set(pit, A.pits.get(pit)+1);
						}
						stones--;
						//check for stone capture
						
						if (pit != 0)
						{
							if(stones == 0 && player == true && B.pits.get(pit-1) == 1)
							{
								pit--;
								int captured = A.pits.get(5 - pit);
								A.pits.set(5 - pit, 0);
								B.stonecount += captured;
								System.out.println("Captured!");
							}
						}
					}
				}
				if (extraturn == false)
				{
					turn = !turn;
					anothermove = false;
				}
				else
				{
					anothermove = true;
				}
				undocheck = true;
				endgame(A, B);
				
			}
		}
		
		update();
	}
	
	
	/**
	 * tests for end of game status and computes the final count.
	 * @param A player A
	 * @param B player B
	 */
	public void endgame(Player A, Player B)
	{
		boolean endgameA = true;
		boolean endgameB = true;
		for (int i = 0; i < 5; i++)
		{
			if (A.pits.get(i) > 0)
			{
				endgameA = false;
			}
			if (B.pits.get(i) > 0)
			{
				endgameB = false;
			}

		}
		if (endgameA == true || endgameB == true)
		{
			for (int i = 0; i < 5; i++)
			{
				A.stonecount += A.pits.get(i);
				A.pits.set(i, 0);
				B.stonecount += B.pits.get(i);
				B.pits.set(i, 0);
			}
			if (A.stonecount > B.stonecount)
			{
				status = "Player A wins!";
			}
			else
			{
				status = "Player B wins";
			}
			update();
		}
	}
	
	/**
	 * 
	 * @return the player of the current turn in string form.
	 */
	public String getPlayer()
	{
		if (turn == true)
		{
			return "Player A";
		}
		else return "Player B";
	}
	
	/**
	 * Undo makes the board go back to the previous state.
	 */
	public void undo()
	{
		if (undocheck == true && undoCount > 0)
		{
			A = previousA;
			B = previousB;
			if(anothermove == true)
			{
				anothermove = false;
			}
			else
			{
				turn = !turn;
			}
		}
		else
		{
			//make statement saying cannot undo
			status = "Cannot undo";
		}
		update();
	}
	
	/**
	 * attaches a changelistener.
	 * @param e is a changelistener
	 */
	public void attach(ChangeListener e)
	{
		listeners.add(e);
	}
	
	/**
	 * updates the changelisteners.
	 */
	public void update()
	{
		for (ChangeListener e: listeners)
		{
			e.stateChanged(null);
		}
	}
	
	

}
