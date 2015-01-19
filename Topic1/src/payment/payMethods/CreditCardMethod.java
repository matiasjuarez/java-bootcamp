package payment.payMethods;

import javax.swing.JOptionPane;

import shoppingCart.Article;
import shoppingCart.ShoppingCart;

public class CreditCardMethod implements PayMethod {

	private ShoppingCart shoppingCart;
	private String name;
	private long creditCardNumber;
	private int discountPercentage = 10;

	public CreditCardMethod(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	// This methods return the amount to pay for all the shoppingCart's articles
	@Override
	public double calculateAmountToPay() {
		double amountToPay = 0;

		for (Article article : shoppingCart.getArticles()) {
			amountToPay += article.getPrice();
		}

		return amountToPay - amountToPay * discountPercentage / 100;
	}

	// Here we ask the client for some information to proceed with the purchase
	@Override
	public void requestPaymentInformation() {
		name = JOptionPane.showInputDialog(null, "Please, insert your name",
				"NAME", JOptionPane.INFORMATION_MESSAGE);
		String numberInput = "";
		// This variable is used to validate that the user is entering a correct
		// value. In this case, just numbers
		boolean wrongInput = true;

		while (wrongInput) {
			// We ask the user to enter his/her card number
			numberInput = JOptionPane.showInputDialog(null,
					"Please, insert your credit card number", "CREDIT CARD",
					JOptionPane.INFORMATION_MESSAGE);
			// We verify if the entered value is a number
			try {
				creditCardNumber = Long.parseLong(numberInput);
				wrongInput = false;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"The value must be a number", "INPUT ERROR",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

}
