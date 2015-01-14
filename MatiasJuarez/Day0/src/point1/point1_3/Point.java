package point1.point1_3;

public class Point {
	private int x;
	private int y;
	
	public Point(){
		this.setX(0);
		this.setY(0);
	}
	
	public Point(int x, int y){
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		String str = "X: " + x + ", Y: " + y;
		return str;
	}
	
	public double distance(int x, int y){
		int longX = this.x - x;
		int longY = this.y - y;
		
		return Math.sqrt(Math.pow(longX, 2) + Math.pow(longY, 2));
	}
	
	public double distance(Point another){
		int longX = this.x - another.x;
		int longY = this.y - another.y;
		return Math.sqrt(Math.pow(longX, 2) + Math.pow(longY, 2));

	}
}
