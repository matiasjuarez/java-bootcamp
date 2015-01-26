package crudService;

import java.util.ArrayList;

/**
 * This class holds all the user that have been created till the moment
 * @author Matías
 *
 */
public class System {
	private static ArrayList<User> users = new ArrayList<User>();
	
	public static User searchUser(String userName)
	{
		for(User user: users){
			if(user.getUserName().equalsIgnoreCase(userName))
				return user;
		}
		
		return null;
	}
	
	public static void addUser(User user)
	{
		users.add(user);
	}
}
