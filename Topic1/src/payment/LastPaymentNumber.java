package payment;

//This class hold the last number of the last payment done. 
//So you should call the updateLastNumber method first and then the 
//getLastMethod number when you are going to create a new Payment
public class LastPaymentNumber {

	private static LastPaymentNumber lastPaymentNumber = null;

	private int lastNumber;

	private LastPaymentNumber() {

		lastNumber = 0;
	}

	public int getLastNumber() {
		return lastNumber;
	}

	public void updateLastNumber() {
		lastNumber++;
	}

	public static LastPaymentNumber getInstance() {
		if (lastPaymentNumber == null)
			lastPaymentNumber = new LastPaymentNumber();
		return lastPaymentNumber;
	}
}
