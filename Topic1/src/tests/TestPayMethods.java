package tests;

import payment.payMethods.PayMethod;
import payment.payMethods.PayPalMethod;
import shoppingCart.ShoppingCart;

public class TestPayMethods {
	public static void main(String[] args) {
		ShoppingCart sc = new ShoppingCart();
		PayMethod p1 = new PayPalMethod(sc);
		
		p1.requestPaymentInformation();
	}
}
