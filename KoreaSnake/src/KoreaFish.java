import java.awt.Graphics;

public class KoreaFish  {
	
	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];
	private int moves = 0;
	public void paint(Graphics g) {

		if (moves == 0) {
			snakexlength[2] = 50;
			snakexlength[1] = 100;
			snakexlength[0] = 150;

			snakeylength[2] = 250;
			snakeylength[1] = 250;
			snakeylength[0] = 250;
		}
	}

}
