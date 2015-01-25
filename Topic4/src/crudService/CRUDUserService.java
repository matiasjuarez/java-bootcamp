package crudService;

import java.awt.Image;

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
	 */
	public void createContent();

	/**
	 * Update the data of a previously created content
	 * 
	 * @param content
	 *            A content previously created that user wants to update
	 */
	public void updateContent(Content content);

	/**
	 * Update the data of a previously created content
	 * 
	 * @param id
	 *            Is the id that identifies a content unequivocally
	 */
	public void updateContent(String id);

	/**
	 * Retrieves all the contents that share the same name
	 * 
	 * @param contentName
	 *            The name the user gave to the content
	 */
	public void readAllContentsWithName(String contentName);

	/**
	 * Retrieves the content which unique name is the same as the String passed
	 * as a parameter
	 * 
	 * @param id
	 *            Is the id that identifies a content unequivocally
	 */
	public void readContent(String id);

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
	public void deleteContent(String id);

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
	 * @param friendId
	 *            Is the Id that identifies a user unequivocally
	 */
	public void addFriend(String friendId);

	/**
	 * Adds a new like to a photo whose id is the same as the one passed via
	 * parameter
	 * 
	 * @param photoId
	 *            The id that identifies a photo unequivocally
	 */
	public void likePhoto(String photoId);
}
