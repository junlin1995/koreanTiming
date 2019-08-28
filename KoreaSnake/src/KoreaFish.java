import java.awt.Graphics;

import javax.swing.ImageIcon;

public class KoreaFish  {
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;

	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon leftmouth;
	private ImageIcon snakeimage;
	private int lengthofsnake = 3;
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
		
		for (int a = 0; a < lengthofsnake; a++) {
			if (a == 0) { 
				if (right) {
					rightmouth = new ImageIcon("rightmouth.png"); 
					rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				} 
				else if (left) {
					leftmouth = new ImageIcon("leftmouth.png"); 
					leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				}
				else if (up) {
					upmouth = new ImageIcon("upmouth.png"); 
					upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				} 
				else if (down) {
					downmouth = new ImageIcon("downmouth.png"); 
					downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				} 
				else {
					rightmouth = new ImageIcon("rightmouth.png"); 
					rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				}
			}

			if (a != 0) {
				snakeimage = new ImageIcon("fishbody.png"); 
				snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
		}

	}

}
