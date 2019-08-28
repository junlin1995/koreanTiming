import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class KeyPressed extends JPanel implements KeyListener {
	
	
	
	// keyBoard controll
		@Override
		public void keyTyped(KeyEvent e) {

		}

		int moves = 0;
		int score = 0;
		private int lengthofsnake = 3;
		private boolean left = false;
		private boolean right = false;
		private boolean up = false;
		private boolean down = false;

		
		
		
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
