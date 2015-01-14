package point1.point1_9;

public class TestTime {
	public static void main(String[] args) {
		
		MyTime t1 = null;
		try {
			 t1 = new MyTime(23,58,59);
		} catch (InvalidHour e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println(t1);
		
		
		t1.nextSecond();
		
		System.out.println(t1);
		
	}
}
