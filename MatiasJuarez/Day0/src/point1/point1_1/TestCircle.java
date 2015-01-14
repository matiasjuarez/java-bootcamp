package point1.point1_1;

public class TestCircle {
	
	public static void main(String[] args){
		
		Circle c1 = new Circle();
		
		System.out.println("The circle has a radius of: " + c1.getRadius() + " and area of: " + c1.getArea());
		
		Circle c2 = new Circle(3.5);
		
		System.out.println("The circle has a radius of: " + c2.getRadius() + " and area of: " + c2.getArea());
		
		Circle c3 = new Circle(4, "blue");
		
		System.out.println("The circle has a radius of: " + c3.getRadius() + " and is " + c3.getColor());
		
		System.out.println(c2.toString());
		System.out.println(c2);
	}
}
