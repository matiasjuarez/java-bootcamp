package payment.payMethods;

public interface PayMethod {
	double calculateAmountToPay();

	void requestPaymentInformation();
}
