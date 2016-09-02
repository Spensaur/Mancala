import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Team Cheetos
 * @author Spencer Lehrman
 *Main test class
 */
public class MancalaTest extends JFrame {
	
	/**
	 * Main Test Class, also holds the menu for strategy choice and stonenumber choice.
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame mainframe = new JFrame();
		mainframe.setSize(650, 400);
		Model model = new Model();
		ColorStrategy colorstrategy;
		GamePanel gamepanel;
		
		int strategy;
		int stonenumbertmp;
		int stonenumber;
		
		Object[] prompts = {"Classic", "Green"};
		strategy = JOptionPane.showOptionDialog(null, "Select a Game Style!", "Start Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, prompts, prompts[1]);//check prompts
		
		if (strategy == 0) colorstrategy = new BlueStrategy();
		else colorstrategy = new GreenStrategy();
		
		Object[] numberprompt = {"Three", "Four"};
		stonenumbertmp = JOptionPane.showOptionDialog(null, "How many stone would you like to start with in each pit?", 
				"Start Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, numberprompt, numberprompt[1]);
		
		if(stonenumbertmp == 0) stonenumber = 3;
		else stonenumber = 4;
		
		model.initialStones(stonenumber);
		gamepanel = new GamePanel(colorstrategy, model);
		Container container = mainframe.getContentPane();
		mainframe.setTitle("Mancala");
		container.add(gamepanel);
		mainframe.setVisible(true);
 		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//strategy = JOptionPane.showOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue)
				
				
	}

}
