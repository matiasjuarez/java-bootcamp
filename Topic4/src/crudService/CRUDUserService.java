package crudService;

/**
 * This interface represents the basic operation a class should implement to
 * provide a CRUD service
 * 
 * @author Matías
 *
 */
public interface CRUDUserService {

	/**
	 * Creates a new content and stores it somewhere
	 * 
	 * @param content
	 *            The content the user wants to save
	 */
	public void createContent(Content content);

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

}
