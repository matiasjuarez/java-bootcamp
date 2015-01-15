package shoppingCart.observer;

//This interface should be implemented by all the articles that need to be observed
public interface ArticleSubject {
	void addArticleObserver(ArticleObserver articleObserver);

	void removeArticleObserver(ArticleObserver articleObserver);

	void doNotify(String message);
}
