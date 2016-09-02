import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Team Cheetos
 * @author Spencer Lehrman
 *
 */
public class PitComponent extends JComponent {
	Model model;
	int x;
	int y;
	int pit;
	boolean player;
	ColorStrategy strategy;
	boolean mancala;
	
	// b is true for mancala, false for pit
	// p is true for player a, false for player b
	/**
	 * 
	 * @param b is true for mancala, false for pit
	 * @param p is true for player a, false for player b
	 * @param pitnumber is the pitnumber
	 * @param m is the model
	 * @param s is the choosen color strategy
	 */
	public PitComponent(boolean b, boolean p, int pitnumber, Model m, ColorStrategy s)
	{
		super();
		model = m;
		if (p == true)
		{
			pit = 5 - pitnumber;
		}
		else
		{
			pit = pitnumber;
		}
		//pit = 5 - pitnumber;
		player = p;
		strategy = s;
		mancala = b;
		if (b == true)
		{
			x = 75;
			y = 300;
		}
		else
		{
			x = 75;
			y = 100;
			addMouseListener(new MouseAdapter()
			{ 
				public void mousePressed(MouseEvent e)
				{
					model.mainMove(player, pit);
					System.out.println("pit:"+ pit + "  player:"+ player + "  mancala:"+ mancala);
					repaint();
				}
			});
			model.attach(new ChangeListener()
			{

				@Override
				public void stateChanged(ChangeEvent e) {
					repaint();
				}
			
			});
		}
	}
	
	/**
	 * Paint Component
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//
		Dimension dimension = new Dimension(x,y);
		//
		Graphics2D g2 = (Graphics2D)g;
		setSize(x, y);
		setPreferredSize(dimension);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		setBackground(strategy.backGroundColor());
		Rectangle2D boarder = new Rectangle2D.Double(0,0,x,y);
		Ellipse2D inner = new Ellipse2D.Double(0,0,x,y);
		g2.draw(boarder);
		g2.setColor(strategy.pitBorderColor());
		g2.fill(boarder);
		//g2.draw(inner);
		g2.setColor(strategy.pitColor());
		g2.fill(inner);
		g2.setColor(strategy.numberColor());
		if (player == true)
		{
			if (mancala == true) g2.drawString("" + model.A.stonecount, x/2, y/2);
			else g2.drawString("" + model.A.pits.get(pit), x/2, y/2);
		}
		else
		{
			if (mancala == true) g2.drawString("" + model.B.stonecount, x/2, y/2);
			else g2.drawString("" + model.B.pits.get(pit), x/2, y/2);
		}
	}
	

}
