package point1.point1_8;

import java.math.BigInteger;

public class TestBigInteger {
	
	public static void main(String[] args) {
		BigInteger bi1 = new BigInteger("11111111111111111111111111111111111111111111111111111111111111");
		BigInteger bi2 = new BigInteger("22222222222222222222222222222222222222222222222222");
		
		System.out.println(bi1.add(bi2));
		System.out.println(bi1.multiply(bi2));
	}
}
