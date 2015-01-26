package crudService;

import java.awt.Image;

/**
 * This class represents a content a user can add.
 * @author Matias
 *
 */
public class Content {
	
	private int contentId;
	private String text;
	private Image photo;

	public Content() {
		this.contentId = 1;
		
	}
	

	public void setText(String textContent) {
		this.text = textContent;
	}
	
	public int getContentId() {
		return contentId;
	}

	public String getText() {
		return text;
	}

	public void setImage(Image photo) {
		this.photo = photo;
		
	}
	
	public Image getPhoto(){
		return photo;
	}

}
