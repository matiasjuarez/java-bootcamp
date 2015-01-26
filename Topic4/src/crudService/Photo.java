package crudService;

import java.awt.Image;

public class Photo {
	private int likes;
	private Image image;
	private int id;

	public Photo(Image image) {
		this.image = image;
		likes = 0;
		id = 1;
	}

	public int getLikes() {
		return likes;
	}

	public void like() {
		likes++;
	}

	public int getId() {
		return id;
	}
}
