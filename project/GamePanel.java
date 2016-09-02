import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Team Cheetos
 * @author Spencer Lehrman
 * GamePanel creates the main panel on which al the other panel and components are displayed and organized.
 */
public class GamePanel extends JPanel {
	
	PitComponent mancalaA;
	PitComponent mancalaB;

	JPanel playerApanel;
	JPanel playerBpanel;
	JPanel center;
	JPanel AMancala;
	JPanel BMancala;
	HelpPanel help;
	PlayerPanel playerA;
	PlayerPanel playerB;
	/**
	 * 
	 * @param s Choose a color strategy
	 * @param m input data model
	 */
	public GamePanel (ColorStrategy s, Model m)
	{
		playerApanel = new JPanel();
		playerBpanel = new JPanel();
		center = new JPanel();
		AMancala = new JPanel();
		BMancala = new JPanel();
		help = new HelpPanel(m);
		playerA = new PlayerPanel(m, "Player A");
		playerB = new PlayerPanel(m, "Player B");
		
		center.setLayout(new BorderLayout());
		
		playerApanel.add(new PitComponent(false, true, 0, m, s));
		playerApanel.add(new PitComponent(false, true, 1, m, s));
		playerApanel.add(new PitComponent(false, true, 2, m, s));
		playerApanel.add(new PitComponent(false, true, 3, m, s));
		playerApanel.add(new PitComponent(false, true, 4, m, s));
		playerApanel.add(new PitComponent(false, true, 5, m, s));
		
		playerBpanel.add(new PitComponent(false, false, 0, m, s));
		playerBpanel.add(new PitComponent(false, false, 1, m, s));
		playerBpanel.add(new PitComponent(false, false, 2, m, s));
		playerBpanel.add(new PitComponent(false, false, 3, m, s));
		playerBpanel.add(new PitComponent(false, false, 4, m, s));
		playerBpanel.add(new PitComponent(false, false, 5, m, s));
		
		AMancala.add(new PitComponent(true, true, -1, m, s));
		BMancala.add(new PitComponent(true, false, -1, m, s));

		
		center.add(playerApanel, BorderLayout.NORTH);
		center.add(playerBpanel, BorderLayout.SOUTH);
		center.add(help, BorderLayout.CENTER);
		
		AMancala.setLayout(new BoxLayout(AMancala, BoxLayout.Y_AXIS));
		AMancala.add(Box.createVerticalGlue());
		
		BMancala.setLayout(new BoxLayout(BMancala, BoxLayout.Y_AXIS));
		BMancala.add(Box.createVerticalGlue());
		
		setLayout(new BorderLayout());
		add(center, BorderLayout.CENTER);
		add(AMancala, BorderLayout.WEST);
		add(BMancala, BorderLayout.EAST);
		add(playerA, BorderLayout.NORTH);
		add(playerB, BorderLayout.SOUTH);
	}
	
	/**
	 * PaintComponent
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}

}
