package shoppingCart;

import java.util.ArrayList;

import shoppingCart.observer.ArticleObserver;
import shoppingCart.observer.ObserversLists;
import views.OffersIndentedPrint;

public class Offer extends Article {

	private float discountPercentage; // this discount is applied on all the
										// products of the offer
	private ArrayList<Article> articles;
	private String name;

	public Offer(float discountPercentage, String name,
			ArrayList<Article> articles) {
		this.name = name;
		this.discountPercentage = discountPercentage;
		this.articles = articles;

		doNotify("A new offer was created: \n" + getDescription());

	}

	@Override
	public double getPrice() {
		double ancillaryPrice = 0;
		// we add the price of the different articles that compound the offer
		for (Article article : articles) {
			ancillaryPrice += article.getPrice();
		}

		// we apply a discount on the amount we've got above
		return (ancillaryPrice - ancillaryPrice * discountPercentage / 100);
	}

	@Override
	public String getDescription() {
		OffersIndentedPrint oip = new OffersIndentedPrint();
		oip.indentOffers(this);
		return oip.getIndentedPrint();
	}

	public void addArticle(Article article) {
		articles.add(article);
	}

	public void removeArticle(Article article) {
		articles.remove(article);
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public Article getArticle(int index) {
		return articles.get(index);
	}

	public float getDiscountPercentage() {
		return discountPercentage;
	}

	public String getName() {
		return name;
	}

	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
		doNotify("An offer's discount percentage was updated: [" + name
				+ ". New percentage: " + discountPercentage + "]");
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
		String str = "°";
		str += getName();
		str += " .... $";
		str += getPrice();
		str += "\n";
		return str;
	}

}
