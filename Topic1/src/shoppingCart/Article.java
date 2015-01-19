package shoppingCart;

import shoppingCart.observer.ArticleSubject;

// An article could be an offer or a product
public abstract class Article implements ArticleSubject {
	public abstract double getPrice();

	public abstract String getDescription();

	public abstract String getName();
}
