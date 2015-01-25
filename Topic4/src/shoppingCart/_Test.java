package shoppingCart;

import static org.junit.Assert.*;

import org.junit.Test;

public class _Test {
	ShoppingCartService shoppingCart;

	@Test
	public void addNewArticle() {
		shoppingCart = new ShoppingCartServiceImplementation();

		Article article1 = new Article(20, "Coke");
		Article article2 = new Article(10, "Meat");

		shoppingCart.addArticle(article1);
		shoppingCart.addArticle(article2);

		assertEquals(2, shoppingCart.getAmountOfArticles());
	}

	@Test
	public void getDescriptionOfArticles() {
		addNewArticle();

		String cartDescription = shoppingCart.toString();

		assertEquals("COKE: $20.0. MEAT: $10.0.", cartDescription);
	}

	@Test
	public void removeArticle() {
		addNewArticle();

		Article article3 = new Article(5, "BREAD");

		shoppingCart.addArticle(article3);

		String cartDescription = shoppingCart.toString();

		assertEquals("COKE: $20.0. MEAT: $10.0. BREAD: $5.0.", cartDescription);

		shoppingCart.removeArticle(article3);

		cartDescription = shoppingCart.toString();

		assertEquals("COKE: $20.0. MEAT: $10.0.", cartDescription);

	}

	@Test
	public void getTotal() {
		addNewArticle();
		
		assertEquals(30, shoppingCart.getTotal(), 0.001);
	}

}
