package shoppingCart;

import java.util.ArrayList;

//This class represents the shoppingCart that will store all the articles selected by the client
public class ShoppingCart {
	private ArrayList<Article> articles;

	public ShoppingCart() {
		articles = new ArrayList<Article>();
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

	public String toString() {
		String str = "";

		for (Article article : getArticles()) {
			str += article.getDescription();
		}

		return str;
	}

	// Returns the sum of all the articles in the shoppingCart
	public double getTotal() {
		double total = 0;
		for (Article article : articles) {
			total += article.getPrice();
		}
		return total;
	}
}
