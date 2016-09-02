import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Team Cheetos
 * @author Spencer Lehrman
 * Creates a panel for the center to hold the undo button and other helpful data for the users.
 */
public class HelpPanel extends JPanel {
	Model model;
	JButton undo;
	JTextField turn;
	JTextField mistake;
	
	/**
	 * 
	 * @param m input model
	 */
	public HelpPanel(Model m)
	{
		super();
		model = m;
		undo = new JButton();
		turn = new JTextField();
		mistake = new JTextField();
		turn.setText(model.getPlayer() + "'s turn.");
		mistake.setText(model.status);
		turn.setEditable(false);
		mistake.setEditable(false);
		undo.setText("Undo");
		undo.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				model.undo();
				//model.update();
			}
		});
		
		model.attach(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent arg0) 
			{
				repaint();
			}
			
		});
		add(turn);
		add(mistake);
		add(undo);
	}
	
	/**
	 * Paint Component
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		 Graphics2D g2 = (Graphics2D)g;
		 turn.setText(model.getPlayer() + "'s turn.");
		 mistake.setText(model.status);
	}
}
