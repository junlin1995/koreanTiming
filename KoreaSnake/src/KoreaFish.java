
public class KoreaFish  {
	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];
	public KoreaFish() {
		snakexlength[2] = 50;
		snakexlength[1] = 100;
		snakexlength[0] = 150;

		snakeylength[2] = 250;
		snakeylength[1] = 250;
		snakeylength[0] = 250;
	}
	
	public int[] getXlength() {
		return snakexlength;
	}
	
	public int[] getYlength() {
		return snakeylength;
	}
	
}
	