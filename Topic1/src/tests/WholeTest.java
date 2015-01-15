package tests;

import java.util.ArrayList;

import payment.Payment;
import payment.payMethods.CashMethod;
import payment.payMethods.CreditCardMethod;
import payment.payMethods.PayMethod;
import payment.payMethods.PayPalMethod;
import shoppingCart.Article;
import shoppingCart.Offer;
import shoppingCart.Product;
import shoppingCart.ShoppingCart;
import shoppingCart.observer.ArticleObserver;
import shoppingCart.observer.ManagerUser;
import shoppingCart.observer.ObserversLists;
import views.OffersIndentedPrint;

public class WholeTest {
	public static void main(String[] args) {

		ShoppingCart shoppingCart = new ShoppingCart();

		// We create an observer that will receive notifications about new
		// articles and changes in the price of these articles and we add that
		// observer to a list that stores all the article observers
		ArticleObserver ao = new ManagerUser();
		ObserversLists.getArticleObservers().add(ao);

		// We create five products
		Product p1 = new Product(10, "meat");
		Product p2 = new Product(20, "juice");
		Product p3 = new Product(30, "wine");
		Product p4 = new Product(30, "RED wine");
		Product p5 = new Product(40, "beer");

		// We create a list of articles for the offer o1
		ArrayList<Article> offerList1 = new ArrayList<Article>();
		offerList1.add(p1);
		offerList1.add(p2);

		// We add the list of articles to the offer o1
		Offer o1 = new Offer(10, "Super combo 1", offerList1);

		// The same process we did before but this time for offer o2
		ArrayList<Article> offerList2 = new ArrayList<Article>();
		offerList2.add(p3);
		offerList2.add(o1);
		offerList2.add(p4);

		Offer o2 = new Offer(15, "Drunk combo!", offerList2);

		// The same
		ArrayList<Article> offerList3 = new ArrayList<Article>();
		offerList3.add(p5);
		offerList3.add(o2);
		offerList3.add(o1);
		offerList3.add(p2);
		Offer o3 = new Offer(20, "Mega offer", offerList3);

		// we decided to purchase offer1, offer3 and offer2 so we add them to
		// the
		// shoppingCart
		shoppingCart.addArticle(o1);
		shoppingCart.addArticle(o2);
		shoppingCart.addArticle(o3);

		// We display the information about all the articles that are stored in
		// the client's shoppingCart
		System.out.println("Here we show all the article of our shopping cart");
		System.out.println(shoppingCart);
		System.out.println();

		System.out
				.println("Here we show how much all the articles of the shopping cart cost");
		System.out.println(shoppingCart.getTotal());
		System.out.println();

		// offersIndentedPrint.indentOffers(o3);
		// System.out.println(offersIndentedPrint.getIndentedPrint());

		// Here we create a CreditCardMethod
		PayMethod payMethod = new CreditCardMethod(shoppingCart);

		// we create a payment that require a payMethod and a shoppingCart
		Payment payment = new Payment(payMethod, shoppingCart);

		// We show how much the client owes us
		System.out
				.println("This is how much the cliente owes after he/she decided wich payment method will use");
		System.out.println(payment.getAmountToPay());
		System.out.println();

		// Here we test the notify methods

		o1.setDiscountPercentage(40);
		p5.setPrice(41);

		ManagerUser mu = (ManagerUser) ObserversLists.getArticleObservers()
				.get(0);

		// All these messages are stored in the mail list of the observer
		System.out.println("Here we show all the notifications that our manager has received");
		System.out.println();
		System.out.println();
		for (String message : mu.getEmails()) {
			System.out.println(message);
		}
	}
}
