import java.awt.Color;

/**
 * Team Cheetos
 * @author Spencer Lehrman
 * Class for implementing the ColorStrategy to make a Green UI
 */
public class GreenStrategy implements ColorStrategy {

	/**
	 * Generates Yellow Background Color
	 */
	@Override
	public Color backGroundColor() {
		// TODO Auto-generated method stub
		return Color.YELLOW;
	}

	/**
	 * Generates Green pit border color
	 */
	@Override
	public Color pitBorderColor() {
		// TODO Auto-generated method stub
		return Color.GREEN;
	}

	/**
	 * Generates Green number color
	 */
	@Override
	public Color numberColor() {
		// TODO Auto-generated method stub
		return Color.GREEN;
	}

	/**
	 * Generates Yellow pit color
	 */
	@Override
	public Color pitColor() {
		// TODO Auto-generated method stub
		return Color.YELLOW;
	}

}
