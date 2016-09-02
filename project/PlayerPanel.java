import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Team Cheetos
 * @author Spencer Lehrman
 * Creates a Panel with a Textfield displaying the Player name(A or B)
 */
public class PlayerPanel extends JPanel {
	
	Model model;
	JTextField player;
	String name;
	
	/**
	 * Constructor for the player panel
	 * @param m data model
	 * @param n name of player
	 */
	public PlayerPanel(Model m, String n)
	{
		model = m;
		name = n;
		player = new JTextField();
		player.setEditable(false);
		player.setText(name);
		add(player);
	}
	
	/**
	 * PaintComponenet
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}

}
