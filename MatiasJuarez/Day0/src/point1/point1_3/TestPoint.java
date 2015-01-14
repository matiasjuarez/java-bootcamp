package point1.point1_3;

public class TestPoint {
	public static void main(String[] args) {
		Point [] points = new Point[10];
		
		Point p1 = new Point(7,12);
		Point p2 = new Point(17, 25);
		
		System.out.println("Distance between point1 and point2: " + p1.distance(17, 25));
		System.out.println("Distance between point1 and point2: " + p1.distance(p2));
		System.out.println();
		
		System.out.println("Points inside the array: \n");
		for (int i = 1; i <= 10; i++) {
			points[i - 1] = new Point(i,i);
			
		}
		
		for (Point point : points) {
			System.out.println(point.toString());
		}
	}
}
