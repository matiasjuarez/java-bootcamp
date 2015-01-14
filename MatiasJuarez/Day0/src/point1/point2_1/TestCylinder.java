package point1.point2_1;

public class TestCylinder {
	public static void main(String[] args) {
		
		Cylinder c1 = new Cylinder(3,4);
		System.out.println("Cylinder 1: ");
		System.out.println("Height: " + c1.getHeight());
		System.out.println("Base Area: " + c1.getArea());
		System.out.println("Volume: " + c1.getVolume());
		System.out.println("radius: " + c1.getRadius());
	}
}
