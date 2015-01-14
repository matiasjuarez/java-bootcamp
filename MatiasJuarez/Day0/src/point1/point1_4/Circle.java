package point1.point1_4;

import point1.point1_3.Point;

public class Circle {
	private Point center;
	private int radius;

	public Circle(int x, int y, int radius) {
		setCenter(new Point(x, y));
		this.setRadius(radius);
	}

	public Circle(Point center, int radius) {
		this.setCenter(center);
		this.setRadius(radius);
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int getCenterX(){
		return center.getX();
	}
	
	public int getCenterY(){
		return center.getY();
	}
	
	public void setCenterXY(int x, int y){
		center.setX(x);
		center.setY(y);
	}
	
	public String toString(){
		String str = "Circle @ (" + center.getX() + "," +center.getY() +")" + radius;
		return str;
	}
	
	
	public double getArea(){
		return radius*radius*Math.PI;
	}
}
