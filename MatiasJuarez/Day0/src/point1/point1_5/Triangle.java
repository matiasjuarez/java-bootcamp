package point1.point1_5;

import point1.point1_3.Point;

public class Triangle {
	private Point p1;
	private Point p2;
	private Point p3;
	
	public Triangle(int x1, int y1, int x2, int y2
			, int x3, int y3){
		p1 = new Point(x1,y1);
		p2 = new Point(x2,y2);
		p3 = new Point(x3,y3);
	}
	
	public Triangle(Point p1, Point p2, Point p3){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	public String toString(){
		return "Triangle @ (" + p1.getX() + "," + p1.getY()+"), (" + p2.getX() + "," + p2.getY() +
				"), (" + p3.getX()+","+p3.getY()+")";
	}
	
	public String getType(){
		double dist1 = p1.distance(p2);
		double dist2 = p2.distance(p3);
		double dist3 = p3.distance(p1);
		
		if(dist1 == dist2 && dist2 == dist3)
			return "equilateral";
		if((dist1 == dist2 || dist2 == dist3 || dist3 == dist1))
			return "isosceles";
		return "scalene";
	}
	
	public double getPerimeter(){
		double dist1 = p1.distance(p2);
		double dist2 = p2.distance(p3);
		double dist3 = p3.distance(p1);
		
		return Math.abs(dist1) + Math.abs(dist2) + Math.abs(dist3);
	}
}
