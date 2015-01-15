package views;

import shoppingCart.Article;
import shoppingCart.Offer;

//The purpose of this class is to return a String with the information and the correct format to be displayed in the console
public class OffersIndentedPrint {

	private int indentationLevel = 1; // This variable represents how many \t
										// should be added before we display the
										// information of a particular article
	private String str = "";

	// This methods takes an offer as a parameter and stores in the str variable
	// the information about the offer and all its articles

	public void indentOffers(Offer offer) {
		// This only is true the first time, and we use it to store the
		// information of the offer we passed as a parameter
		if (str.equals(""))
			str += offer.toString();

		Offer innerOffer = null;

		for (Article article : offer.getArticles()) {

			str += addIndentation();
			str += article.toString();

			// We want to know if an article is an offer
			if (article.getClass().getSimpleName().equalsIgnoreCase("offer")) {

				innerOffer = (Offer) article;
				indentationLevel++; // when we find an offer we should increment
									// the amount of \t

				indentOffers(innerOffer); //recursion
			}

		}

		indentationLevel--; // after the information of an offer has been
							// stored, we have to eliminate one \t
	}

	
	// This method adds indentation characters according to the number stored in
	// the indentationLevel variable
	public String addIndentation() {
		String str = "";
		for (int i = 0; i < indentationLevel; i++)
			str += "\t";
		return str;
	}

	public String getIndentedPrint() {
		return str;
	}

	public void cleanStr() {
		str = "";
		indentationLevel = 1;
	}

}
