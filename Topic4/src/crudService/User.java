package crudService;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

public class User {
	private String userName;

	private ArrayList<Content> contents;

	private ArrayList<Photo> photos;

	private ArrayList<User> friends;

	public User(String userName) {
		this.userName = userName;
		contents = new ArrayList<Content>();
		photos = new ArrayList<Photo>();
		friends = new ArrayList<User>();
		
		System.addUser(this);
	}

	public void addContent(Content content) {
		contents.add(content);

	}

	public Content getContent(int contentId) {

		for (Content content : contents) {
			if (content.getContentId() == contentId)
				return content;
		}

		return null;
	}

	public Content[] getContents() {
		Content[] arrayOfContents = new Content[contents.size()];
		int index = 0;
		for (Content content : contents) {
			arrayOfContents[index] = content;
			index++;
		}

		return arrayOfContents;
	}

	public void deleteContent(int contentId) {
		Iterator<Content> iterator = contents.iterator();

		while (iterator.hasNext()) {
			Content content = iterator.next();

			if (content.getContentId() == contentId) {
				iterator.remove();
				break;
			}
		}
	}

	public ArrayList<Photo> getPhotos() {
		return photos;
	}

	public void addPhoto(Image photo) {
		Photo newPhoto = new Photo(photo);

		photos.add(newPhoto);
	}

	public Photo getPhoto(int photoId) {
		for (Photo photo : photos) {
			if (photo.getId() == photoId)
				return photo;
		}
		return null;
	}

	public String getUserName() {
		return userName;
	}

	public ArrayList<User> getFriends() {
		return friends;
	}

	public void addNewFriend(String userName) {
		User friend = System.searchUser(userName);

		if (friend != null)
			friends.add(friend);
	}

}
