import java.awt.Color;

/**
 * Team Cheetos
 * @author Spencer Lehrman
 * interface for the strategy pattern to change interface colors.
 */
public interface ColorStrategy {
	
	/**
	 * @return background color
	 */
	public Color backGroundColor();
	
	
	/**
	 * @return pitborder Color
	 */
	public Color pitBorderColor();
	
	
	/**
	 * @return Number Color
	 */
	public Color numberColor();
	
	
	/**
	 * @return Pit Color
	 */
	public Color pitColor();

}
