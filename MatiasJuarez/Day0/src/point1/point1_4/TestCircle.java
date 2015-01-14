package point1.point1_4;

import point1.point1_3.Point;

public class TestCircle {
	public static void main(String[] args) {
		Circle c1 = new Circle(4,2,1);
		
		System.out.println("Area of the circle: " + c1.getArea());
		System.out.println(c1.toString());
		
		c1.setCenter(new Point(5,11));
		
		System.out.println(c1.toString());
		
		Circle c2 = new Circle(new Point(4, 3), 3);
		
		System.out.println(c2);
	}
	
	
}
