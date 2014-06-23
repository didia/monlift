package me.didia.monlift.managers;

import me.didia.monlift.entities.User;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.factories.UserFactory;

public class UserManager {
	private static UserManager instance = null;
	private static UserFactory userFactory = UserFactory.getInstance();
	
	private UserManager(){};
	
	/**
	 * Singleton method to return an instance of the UserFactory class
	 * @return UserFactory object
	 */
	public static UserManager getInstance(){
		if (instance == null){
			instance = new UserManager();
		}
		return instance;
	}
	
	public Long createUser(String firstname,String lastname, String email,String phone) throws DuplicateValueException{
		return userFactory.createUser(firstname, lastname, email,phone);
	}
	
	 /* function to promote user to a driver
	 * @param id
	 * @param username
	 * @return void
	 */
	public void promoteToDriver(Long id, String username){
		User userToPromote = getUser(id);
		userToPromote.setUsername(username);
		userToPromote.setDriver(true);
		userFactory.save(userToPromote);
	}
	
	/**
	 * function to return user from an Id
	 * @return User object (passenger or Driver)
	 */
	public User getUser(Long id)
	{
		return userFactory.getUser(id);
	}
}
