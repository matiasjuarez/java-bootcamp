package shoppingCart.observer;

import java.util.ArrayList;

//This class represents a manager who has an email list and wants to receive notifications about articles
public class ManagerUser implements ArticleObserver {
	private ArrayList<String> emails = new ArrayList<String>();

	@Override
	public void getNotify(String message) {
		emails.add(message);
	}

	public ArrayList<String> getEmails() {
		return emails;
	}

}
