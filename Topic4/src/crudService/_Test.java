package crudService;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import org.junit.Test;

public class _Test {

	@Test
	public void addNewContent() {
		User user = new User("guest202");

		String textContent = "A new content";

		CRUDUserService crdu = new CRUDUserServiceImplementation(user);

		crdu.createContent(textContent, null);

		Content readContent = crdu.readContent(1);

		assertEquals(textContent, readContent.getText());
	}

	@Test
	public void updateContent() {
		// We create a user
		User user = new User("guest202");

		// A text for the new content
		String textContent = "A new content";

		// A CRDU service with the user that started the service as parameter
		CRUDUserService crdu = new CRUDUserServiceImplementation(user);

		// We create a new content made up only of text
		crdu.createContent(textContent, null);

		// We retrieve the content we have just created
		Content readContent = crdu.readContent(1);

		// We create a new text for the content we created before
		String newContentText = "This content has changed";

		// We assign the new text to the content previously created
		crdu.updateContent(readContent.getContentId(), newContentText, null);

		// We retrieve the content we have just updated
		readContent = crdu.readContent(1);

		assertEquals(newContentText, readContent.getText());
	}

	@Test
	public void deleteContent() {
		User user = new User("guest202");

		String textContent = "A new content";

		CRUDUserService crdu = new CRUDUserServiceImplementation(user);

		crdu.createContent(textContent, null);

		int amountOfContents = crdu.readAllContents().length;

		crdu.deleteContent(1);

		amountOfContents = crdu.readAllContents().length;

		assertEquals(0, amountOfContents);
	}

	@Test
	public void likePhoto() {
		User user = new User("guest202");

		CRUDUserService crdu = new CRUDUserServiceImplementation(user);

		// We an image just to like it
		BufferedImage photo = new BufferedImage(50, 50,
				BufferedImage.TYPE_BYTE_GRAY);

		// We upload the image we have created
		crdu.uploadPhoto(photo);

		// We want to know how many photos the user have
		int amountOfPhotos = user.getPhotos().size();

		assertEquals(1, amountOfPhotos);

		// We like a photo with ID = 1 twice
		crdu.likePhoto(1);
		crdu.likePhoto(1);

		// The actual parameter is the amount of likes the photo with ID = 1 has
		assertEquals(2, crdu.getPhoto(1).getLikes());
	}

	@Test
	public void addFriend() {
		User user = new User("guest202");

		User newFriend = new User("friendlyGirl");

		CRUDUserService crdu = new CRUDUserServiceImplementation(user);

		// We add a new friend to the current user (guest202). We have to give
		// this method the user name of the user we want to add as a new friend
		crdu.addFriend(newFriend.getUserName());

		
		ArrayList<User> friendsOfGUEST202 = crdu.getFriends();

		assertEquals("friendlyGirl", friendsOfGUEST202.get(0).getUserName());
	}

}
