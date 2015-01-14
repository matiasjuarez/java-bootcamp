package point1.point1_7;

import java.io.File;

public class TestPolinomial {
	public static void main(String[] args) {
		double []coefs = {2.3,5.4,0.2, 4.1};
		
		File file = new File("src/parte1_7/coef.txt"); //los doubles tienen que ir con , = 2,8 no con punto
		
		Polynomial pol1 = new Polynomial(file);
		Polynomial pol2 = new Polynomial(coefs);
		System.out.println(pol1.getDegree());
		System.out.println(pol2.getDegree());
		
		System.out.println(pol1.toString());
		System.out.println(pol2.toString());
		
		Polynomial sum = pol1.add(pol2);
		System.out.println(sum);
		System.out.println(pol1.multiply(pol2));
	}
}
