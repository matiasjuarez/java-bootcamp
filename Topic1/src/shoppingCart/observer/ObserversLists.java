package shoppingCart.observer;

import java.util.ArrayList;

//This class will hold all the observers list that the system needs
public class ObserversLists {

	// Here we store all the observers of the different articles

	private static ArrayList<ArticleObserver> articleObservers = new ArrayList<ArticleObserver>();

	public static ArrayList<ArticleObserver> getArticleObservers() {
		return articleObservers;
	}
}
