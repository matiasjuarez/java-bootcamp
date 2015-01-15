package payment.payMethods;

import javax.swing.JOptionPane;

import shoppingCart.Article;
import shoppingCart.ShoppingCart;

public class PayPalMethod implements PayMethod {

	private ShoppingCart shoppingCart;
	private String email;
	private String password;

	public PayPalMethod(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	// This methods return the amount to pay for all the shoppingCart's articles
	@Override
	public double calculateAmountToPay() {
		double amountToPay = 0;
		Article cheapest = getCheapestArticle();

		// We go through all the articles of the shopping cart and when we find
		// the cheapest article we don't add the price of that one to the
		// amountToPay variable
		for (Article article : shoppingCart.getArticles()) {
			if (article != cheapest)
				amountToPay += article.getPrice();
		}

		return amountToPay;
	}

	// Here we get cheapest article of the shopping cart
	public Article getCheapestArticle() {
		Article cheaper = null;

		for (Article article : shoppingCart.getArticles()) {
			if (cheaper == null)
				cheaper = article;
			else
				cheaper = getCheaperArticle(article, cheaper);
		}

		return cheaper;
	}

	// Here we compare both article and we get the cheaper
	public Article getCheaperArticle(Article article1, Article article2) {
		if (article1.getPrice() < article2.getPrice())
			return article1;
		return article2;
	}

	// We ask the user for some information to proceed with the purchase
	@Override
	public void requestPaymentInformation() {
		email = JOptionPane.showInputDialog(null, "Please, insert your email",
				"EMAIL", JOptionPane.INFORMATION_MESSAGE);
		password = JOptionPane.showInputDialog(null,
				"Please, insert your password", "PASS",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
