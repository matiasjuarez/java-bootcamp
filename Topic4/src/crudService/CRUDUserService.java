package crudService;

import java.awt.Image;
import java.util.ArrayList;

/**
 * This interface represents the basic operation a class should implement to
 * provide a CRUD service
 * 
 * @author Matias
 *
 */
public interface CRUDUserService {

	/**
	 * Creates a new content and stores it somewhere
	 * 
	 * @param string
	 *            The text the user wants to add to the new content
	 * @param photo
	 *            The image the user wants to add to the new content
	 */
	public void createContent(String string, Image photo);

	/**
	 * Updates the data of a previously created content
	 * 
	 * @param id
	 *            The id that identifies unequivocally the content you want to
	 *            update
	 * @param newContentText
	 *            The new text for the content
	 * @param newContentImage
	 *            The new Image for the content
	 */
	public void updateContent(int id, String newContentText,
			Image newContentImage);

	/**
	 * Retrieves all the contents that share the same name
	 * 
	 * @param contentName
	 *            The name the user gave to the content
	 * @return
	 */
	public Content[] readAllContents();

	/**
	 * Retrieves the content which unique name is the same as the String passed
	 * as a parameter
	 * 
	 * @param id
	 *            Is the id that identifies a content unequivocally
	 * @return
	 */
	public Content readContent(int id);

	/**
	 * Removes a content from wherever it's stored
	 * 
	 * @param content
	 *            The content that needs to be deleted
	 */
	public void deleteContent(Content content);

	/**
	 * Removes a content from wherever it's stored
	 * 
	 * @param id
	 *            Is the id that identifies a content unequivocally
	 */
	public void deleteContent(int id);

	/**
	 * Gives the user the possibility to upload a new photo.
	 * 
	 * @param photo
	 *            The image a user wants to upload
	 * @return The image the user has uploaded
	 */
	public Image uploadPhoto(Image photo);

	/**
	 * Adds a new friend to the user's friends list
	 * 
	 * @param friendName
	 *            Is the name that identifies a user unequivocally
	 */
	public void addFriend(String userName);

	/**
	 * Adds a new like to a photo whose id is the same as the one passed via
	 * parameter
	 * 
	 * @param photoId
	 *            The id that identifies a photo unequivocally
	 */
	public void likePhoto(int photoId);

	/**
	 * Retrieves a photo with the specified id
	 * 
	 * @param photoId
	 *            The id of the photo
	 * @return The image with the specified id
	 */
	public Photo getPhoto(int photoId);

	/**
	 * Retrieves an array list with all the friends of a specific user
	 * 
	 *             
	 * @return The friend list of the user we are working with
	 */
	public ArrayList<User> getFriends();

	/**
	 * Returns a user with the specified userName
	 * 
	 * @param userName
	 *            The name of the user we want to get
	 * @return The user we are looking for
	 */
	public User getUser(String userName);
}
