package shoppingCart;

import java.util.ArrayList;

public interface ShoppingCartService {
	public void addArticle(Article article);
	public void removeArticle(Article article);
	public ArrayList<Article> getArticles();
	public Article getArticle(int index);
	public double getTotal();
	public int getAmountOfArticles();
}
