package crudService;

import java.awt.Image;
import java.util.ArrayList;

public class CRUDUserServiceImplementation implements CRUDUserService {
	
	private User currentUser;
	
	public CRUDUserServiceImplementation(User user) {
		this.currentUser = user;
	}

	@Override
	public void createContent(String contentText, Image photo) {
		Content content = new Content();
		content.setText(contentText);
		content.setImage(photo);
		currentUser.addContent(content);
	}

	@Override
	public void updateContent(int id, String contentText, Image photo) {
		Content content = currentUser.getContent(id);
		
		content.setText(contentText);
		
		content.setImage(photo);

	}

	@Override
	public Content[] readAllContents() {
		return currentUser.getContents();

	}

	@Override
	public Content readContent(int id) {
		Content content = currentUser.getContent(id);
		return content;
	}

	@Override
	public void deleteContent(Content content) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteContent(int id) {
		currentUser.deleteContent(id);

	}

	@Override
	public Image uploadPhoto(Image photo) {
		currentUser.addPhoto(photo);
		return photo;
	}

	@Override
	public void addFriend(String userName) {
		currentUser.addNewFriend(userName);

	}

	@Override
	public void likePhoto(int photoId) {
		currentUser.getPhoto(photoId).like();

	}

	@Override
	public Photo getPhoto(int photoId) {
		return currentUser.getPhoto(photoId);

	}
	
	public User getUser(){
		return currentUser;
	}

	@Override
	public ArrayList<User> getFriends() {
		return currentUser.getFriends();
	}

	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
