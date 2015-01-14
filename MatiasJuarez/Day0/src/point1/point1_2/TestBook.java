package point1.point1_2;

public class TestBook {

	public static void main(String args[]) {
		Author a1 = new Author("Matias", "matiaz98@hotmail.com", 'm');

		Book b1 = new Book("Un libro", a1, 20.2);

		System.out.println(b1);
		
		System.out.println(b1.getAuthorName());
	}
}
