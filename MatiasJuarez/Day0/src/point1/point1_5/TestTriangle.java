package point1.point1_5;

import point1.point1_3.Point;

public class TestTriangle {
	public static void main(String[] args) {
		Triangle t1 = new Triangle(new Point(2,4), new Point(6,4), new Point(4, 8));
		
		System.out.println("Type of the triangle: " + t1.getType());
		System.out.println("Perimeter of the triangle: " + t1.getPerimeter());
		System.out.println(t1.toString());
	}
}
