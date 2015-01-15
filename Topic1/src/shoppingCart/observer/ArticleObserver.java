package shoppingCart.observer;

//This interface should be implemented by all the classes that require to be notified when changes are made on an article
public interface ArticleObserver {
	void getNotify(String message);
}
