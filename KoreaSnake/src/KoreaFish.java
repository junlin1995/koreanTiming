
public class KoreaFish  {
	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];
    private int lengthofsnake;
    private int direction;//0,1.2.3
	public KoreaFish() {
		snakexlength[2] = 50;
		snakexlength[1] = 100;
		snakexlength[0] = 150;

		snakeylength[2] = 250;
		snakeylength[1] = 250;
		snakeylength[0] = 250;
		lengthofsnake = 3;
	}
	public int length() {
		return lengthofsnake;
	}
	public void addLength() {
		lengthofsnake ++;
	}
	public int[] getXlength() {
		return snakexlength;
	}
	
	public int[] getYlength() {
		return snakeylength;
	}
	public String getDirectionString() {
		switch(direction) {
		case 0:
			return("upmouth.png"); 
		case 1:
			return("downmouth.png"); 
		case 2:
			return("leftmouth.png"); 
		case 3:
			return("rightmouth.png"); 
		default:
			return "";
		}	
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction=direction;
	}
}
	