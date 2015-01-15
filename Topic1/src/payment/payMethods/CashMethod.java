package payment.payMethods;

import shoppingCart.Article;
import shoppingCart.ShoppingCart;

public class CashMethod implements PayMethod {

	private ShoppingCart shoppingCart;
	private double discountPercentage = 90;

	public CashMethod(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	// This methods return the amount to pay for all the shoppingCart's articles
	@Override
	public double calculateAmountToPay() {
		double amountToPay = 0;
		Article mostExpensive = getMostExpensiveArticle();

		// Here we get the price of each article and we add the price of that
		// article to
		// the amountToPay variable and if the article is the most expensive
		// article in the
		// shopping chart, we calculate a %90 discount on that article
		for (Article article : shoppingCart.getArticles()) {
			if (article != mostExpensive)
				amountToPay += article.getPrice();
			else
				amountToPay += article.getPrice() - article.getPrice()
						* discountPercentage / 100;
		}

		return amountToPay;
	}

	// Returns the most expensive article
	public Article getMostExpensiveArticle() {
		Article higherPrice = null;

		for (Article article : shoppingCart.getArticles()) {
			if (higherPrice == null)
				higherPrice = article;
			else
				higherPrice = getTheMoreExpensive(article, higherPrice);
		}

		return higherPrice;
	}

	// Compares two articles and return the more expensive
	public Article getTheMoreExpensive(Article article1, Article article2) {
		if (article1.getPrice() > article2.getPrice())
			return article1;
		return article2;
	}

	@Override
	public void requestPaymentInformation() {
		// Information is not required
	}

}
