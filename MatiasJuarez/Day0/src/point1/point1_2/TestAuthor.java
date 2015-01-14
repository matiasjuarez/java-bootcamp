package point1.point1_2;

public class TestAuthor {
	public static void main(String [] args)
	{
		Author a1 = new Author("Matias", "Matias@123.com", 'm');
		System.out.println(a1);
		a1.setEmail("paulito@hotmail.com");
		System.out.println(a1);
	}
}
