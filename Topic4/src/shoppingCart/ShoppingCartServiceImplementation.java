package shoppingCart;

import java.util.ArrayList;

//This class represents the shoppingCart that will store all the articles selected by the client
public class ShoppingCartServiceImplementation implements ShoppingCartService {
	private ArrayList<Article> articles;

	public ShoppingCartServiceImplementation() {
		articles = new ArrayList<Article>();
	}

	@Override
	public void removeArticle(Article article) {
		articles.remove(article);
	}

	@Override
	public ArrayList<Article> getArticles() {
		return articles;
	}

	@Override
	public Article getArticle(int index) {
		return articles.get(index);
	}

	// Returns the sum of all the articles in the shoppingCart
	@Override
	public double getTotal() {
		double total = 0;
		for (Article article : articles) {
			total += article.getPrice();
		}
		return total;
	}

	@Override
	public void addArticle(Article article) {
		articles.add(article);
	}

	@Override
	public int getAmountOfArticles() {
		return articles.size();
	}
	
	public String toString() {
		String description = "";
		
		for(Article article: articles){
			description += article.getName().toUpperCase() + ": $" + article.getPrice() + ". ";
		}
		
		return description.trim();
	}
}
