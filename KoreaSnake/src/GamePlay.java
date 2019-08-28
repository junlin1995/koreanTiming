import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

	private static final Color Color = null;
	
	
	

	
	

	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;

	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon leftmouth;

	private int lengthofsnake = 3;
	private int lengthoftai = 4;

	private Timer timer;
	private int delay = 200;
	
	private ImageIcon snakeimage;
	private ImageIcon taibodyimage;

	private int[] enemyxpos = { 50, 100, 150, 200, 150, 200, 250, 300, 350, 400, 450, 500, 550, 600, 650 };
	private int[] enemyypos = { 250, 300, 350, 400, 450, 500, 550, 600, 650, 700, 750 }; 

	private ImageIcon enemyimage;
	private Random random = new Random();

	private int xpos = random.nextInt(15);
	private int ypos = random.nextInt(11);

	private int score = 0;

	

	
	
	
	

	public GamePlay() {

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this); // part2 6:25
		timer.start();
	}

	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];
	private int[] taixlength = new int[750];
	private int[] taiylength = new int[750];
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
		if(moves == 0) {
			taixlength[0] = 650;
			taixlength[1] = 600;

			taiylength[0] = 600;
			taiylength[1] = 600;
		}

		
		
		//private ImageIcon titleImage;
		// draw the title image
		ImageIcon titleImage = new ImageIcon("title.png");
		titleImage.paintIcon(this, g, 24, 0);

		// draw border for gameplay
		
		ImageIcon playImage = new ImageIcon("universe1.png"); 
		playImage.paintIcon(this, g, 24, 215);

		// draw scores
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Scores:  " + score, 550, 150);

		// draw length
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Length:  " + lengthofsnake, 550, 170);

		
	
		
		
		// draw tai
		playImage = new ImageIcon("bomb.gif");
		ImageIcon tai = new ImageIcon("tai.gif");
		for (int b = 0; b < lengthoftai; b++) {
			if (b == 0) {
				tai = new ImageIcon("tai.gif");
				tai.paintIcon(this, g, taixlength[b], taiylength[b]);
				// tai.paintIcon(this,g,point.x, point.y);
				taibodyimage = new ImageIcon("bomb.gif");
				taibodyimage.paintIcon(this, g, taixlength[b] - 230, taiylength[b] - 100);
			}
			if (b != 0) {
				taibodyimage = new ImageIcon("bomb.gif"); 
				// taibodyimage.paintIcon(this, g, taixlength[b], taiylength[b]);

			}
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

		
		
		
		enemyimage = new ImageIcon("coins.gif"); 

		if ((enemyxpos[xpos] == snakexlength[0]) && enemyypos[ypos] == snakeylength[0]) { 
			score++;
			lengthofsnake++;
			xpos = random.nextInt(15);
			ypos = random.nextInt(11);
		}

		enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);

		for (int b = 1; b < lengthofsnake; b++) {
			if (snakexlength[b] == snakexlength[0] && snakeylength[b] == snakeylength[0]) {
				right = false;
				left = false;
				up = false;
				down = false;

				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("Game Over", 200, 500);

				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Space to RESTART", 250, 540);
			}
		}

		g.dispose();
	}

	private ImageIcon ImageIcon(String string) {
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		System.out.println(e.getActionCommand());

		if (right) {

			for (int r = lengthofsnake - 1; r >= 0; r--) {
				snakeylength[r + 1] = snakeylength[r];
			}
			for (int r = lengthofsnake; r >= 0; r--) {
				if (r == 0) {
					snakexlength[r] = snakexlength[r] + 50;
				} else {
					snakexlength[r] = snakexlength[r - 1];
				}
				if (snakexlength[r] > 650) {
					snakexlength[r] = 50;
				}
				// System.out.print(snakexlength[r]+",");
			}
			// System.out.println();
			repaint();
		}

		if (left) {
			for (int r = lengthofsnake - 1; r >= 0; r--) {
				snakeylength[r + 1] = snakeylength[r];
			}
			for (int r = lengthofsnake; r >= 0; r--) {
				if (r == 0) {
					snakexlength[r] = snakexlength[r] - 50;
				} else {
					snakexlength[r] = snakexlength[r - 1];
				}
				if (snakexlength[r] < 50) {
					snakexlength[r] = 650;
				}
			}
			repaint();
		}

		if (up) {
			for (int r = lengthofsnake - 1; r >= 0; r--) {
				snakexlength[r + 1] = snakexlength[r];
			}
			for (int r = lengthofsnake; r >= 0; r--) {
				if (r == 0) {
					snakeylength[r] = snakeylength[r] - 50;
				} else {
					snakeylength[r] = snakeylength[r - 1];
				}
				if (snakeylength[r] < 250) {
					snakeylength[r] = 750;
				}
			}
			repaint();
		}

		if (down) {
			for (int r = lengthofsnake - 1; r >= 0; r--) {
				snakexlength[r + 1] = snakexlength[r];
			}
			for (int r = lengthofsnake; r >= 0; r--) {
				if (r == 0) {
					snakeylength[r] = snakeylength[r] + 50;
				} else {
					snakeylength[r] = snakeylength[r - 1];
				}
				if (snakeylength[r] > 750) {
					snakeylength[r] = 250;
				}
			}
			repaint();
		}
	

	// tai
	Point point = new Point(150, 300);
	Point taimotion = new Point(1, 1);
	boolean change_taimotion_y=false, change_taimotion_x=false;
	if(point.y>=700||point.y<=300){
		change_taimotion_y = true;
	}
	if(point.x<=100||point.x>=650)
	{
		change_taimotion_x = true;
	}if(change_taimotion_y)
	{
		taimotion.y = -taimotion.y;
	}if(change_taimotion_x)
	{
		taimotion.x = -taimotion.x;
	}
	Random rand = new Random();
	int i;i=rand.nextInt(2);
	if(i==1){
		point.x += taimotion.x * 50;
		if (point.x < 100) {
			point.x = 100;
		}
		if (point.x > 650) {
			point.x = 650;
		}
	}
	if(i==0){
		point.y += taimotion.y * 50;
		if (point.y < 300) {
			point.y = 300;
		}
		if (point.y > 700) {
			point.y = 700;
		}
	}

	System.out.println(point.x+","+point.y);

	//
	for(int r = lengthoftai - 1;r>=0;r--)
	{
		taixlength[r + 1] = taixlength[r];
	}
	for(int r = lengthoftai;r>=0;r--)
	{
		if (r == 0) {
			// taiylength[r] = taiylength[r] + 50;
			taiylength[0] = point.y;
		} else {
			taiylength[r] = taiylength[r - 1];
		}
		if (taiylength[r] > 1000) {
			taiylength[r] = 216;
		}
	}

	//
	for(int r = lengthoftai - 1;r>=0;r--)
	{
		taiylength[r + 1] = taiylength[r];
	}
	for(int r = lengthoftai;r>=0;r--)
	{
		if (r == 0) {
			// taixlength[r] = taixlength[r] - 50;
			taixlength[0] = point.x;
		} else {
			taixlength[r] = taixlength[r - 1];
		}
		if (taixlength[r] < 25) {
			taixlength[r] = 650;
		}
	}

}

	
	
	// keyBoard controll
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) { 
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			moves=0;
			score=0;
			lengthofsnake=3;
			repaint();
					
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moves++;
			right = true;
			if (!left) {
				right = true;
			} else {
				right = false;
				left = true;
			}
			up = false;
			down = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moves++;
			left = true;
			if (!right) {
				left = true;
			} else {
				left = false;
				right = true;
			}
			up = false;
			down = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			moves++;
			up = true;
			if (!down) {
				up = true;
			} else {
				up = false;
				down = true;
			}
			left = false;
			right = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			moves++;
			down = true;
			if (!up) {
				down = true;
			} else {
				up = true;
				down = false;
				
			}
			left = false;
			right = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		

	}
}
