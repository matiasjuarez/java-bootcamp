package shoppingCart;

import shoppingCart.observer.ArticleSubject;

public abstract class Article implements ArticleSubject {
	public abstract double getPrice();

	public abstract String getDescription();

	public abstract String getName();
}
