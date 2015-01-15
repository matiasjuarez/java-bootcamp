package payment;

import java.util.Date;

import payment.payMethods.PayMethod;
import shoppingCart.ShoppingCart;
//This class holds information about the purchase the client has done

public class Payment {
	private int identificationNumber;
	private PayMethod payMethod;
	private double amountToPay;
	private ShoppingCart shoppingCart;
	private Date date;

	public Payment(PayMethod payMethod, ShoppingCart shoppingCart) {

		LastPaymentNumber.getInstance().updateLastNumber();
		identificationNumber = LastPaymentNumber.getInstance().getLastNumber();

		this.payMethod = payMethod;

		this.shoppingCart = shoppingCart;

		date = new Date();
		
		//We get the amount to pay taking into account the payMethod the client has chosen
		amountToPay = this.payMethod.calculateAmountToPay();
	}

	public int getIdentificationNumber() {
		return identificationNumber;
	}

	public double getAmountToPay() {
		return amountToPay;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public Date getDate() {
		return date;
	}
}
