package shoppingCart;

import java.util.ArrayList;

/**
 * This interface represents the basic service a shopping cart should provide to
 * the clients
 * 
 * @author Matías
 * 
 */
public interface ShoppingCartService {

	/**
	 * Adds a new article to the shopping cart
	 * 
	 * @param article
	 *            The article that will be added to the shopping chart
	 */
	public void addArticle(Article article);

	/**
	 * Removes an article from the shopping cart
	 * 
	 * @param article
	 *            The article to be removed
	 */
	public void removeArticle(Article article);

	/**
	 * It should return an ArrayList containing all the articles that have been
	 * added to the shopping cart so far
	 * 
	 * @return An ArrayList<Article> that stores all the articles added to the
	 *         shopping cart
	 */
	public ArrayList<Article> getArticles();

	/**
	 * Looks for an article inside the ArrayList that stores all the articles
	 * selected and pick the one located at the specified index
	 * 
	 * @param index
	 *            The index of the article we want to retrieve
	 * @return The article located at the specified index
	 */
	public Article getArticle(int index);

	/**
	 * Calculates the amount of money a client should pay for all the articles
	 * of the shopping cart
	 * 
	 * @return A double value that represents an amount of money
	 */
	public double getTotal();

	/**
	 * Returns the size of the ArrayList that stores all the articles selected
	 * so far. In other words it returns the amount of articles that have been
	 * selected
	 * 
	 * @return A number that informs the amount of articles selected
	 */
	public int getAmountOfArticles();
}
