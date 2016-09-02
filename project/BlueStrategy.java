import java.awt.Color;

/**
 * Team Cheetos
 * @author Spencer Lehrman
 * Class for implementing the ColorStrategy to make a classic color scheme
 */
public class BlueStrategy implements ColorStrategy {

	/**
	 * Generates Gray background color
	 */
	@Override
	public Color backGroundColor() {
		// TODO Auto-generated method stub
		return Color.GRAY;
	}
	
	/**
	 * Generates Black pit border color
	 */
	@Override
	public Color pitBorderColor() {
		// TODO Auto-generated method stub
		return Color.BLACK;
	}

	/**
	 * Generates Black number color
	 */
	@Override
	public Color numberColor() {
		// TODO Auto-generated method stub
		return Color.BLACK;
	}

	/**
	 * Generates orange pit color
	 */
	@Override
	public Color pitColor() {
		// TODO Auto-generated method stub
		return Color.orange;
	}

}
