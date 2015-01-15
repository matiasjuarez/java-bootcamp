package shoppingCart;

import shoppingCart.observer.ArticleObserver;
import shoppingCart.observer.ObserversLists;

public class Product extends Article {

	private double price;
	private String name;

	public Product(double price, String name) {
		this.price = price;
		this.name = name;

		doNotify("A new product was created: " + getDescription());
	}

	@Override
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;

		doNotify("A product's price was updated: [" + name + ". New price: "
				+ price + "]");
	}

	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		String str = (char) 0x3e + name + ".... $" + price + "\n";

		return str;
	}

	@Override
	public void addArticleObserver(ArticleObserver articleObserver) {
		ObserversLists.getArticleObservers().add(articleObserver);

	}

	@Override
	public void removeArticleObserver(ArticleObserver articleObserver) {
		ObserversLists.getArticleObservers().remove(articleObserver);
	}

	@Override
	public void doNotify(String message) {

		for (ArticleObserver articleObserver : ObserversLists
				.getArticleObservers()) {
			if (articleObserver != null)
				articleObserver.getNotify(message);
		}

	}

	public String toString() {
		String str = "•";
		str += getName();
		str += " .... $";
		str += getPrice();
		str += "\n";
		return str;
	}

}
