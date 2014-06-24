package me.didia.monlift.managers;

import me.didia.monlift.entities.User;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.factories.UserFactory;
import me.didia.monlift.securities.AuthentificationManager;

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
	
	public Long createUser(String firstname,String lastname, String email,String phone, String password) throws DuplicateValueException{
		password = AuthentificationManager.generateHashedPassword(password);
		return userFactory.createUser(firstname, lastname, email,phone, password);
	}
	
	 /* function to promote user to a driver
	 * @param id
	 * @param username
	 * @return void
	 */
	public void promoteToDriver(Long id, String username) throws DuplicateValueException{
		User userToPromote = getUser(id);
		userToPromote.setUsername(username);
		userToPromote.setDriver(true);
		userFactory.setUniqueConstraint(userToPromote, "username", username);
		userFactory.save(userToPromote);
	}
	
	/**
	 * function to return user from an Id
	 * @return User object
	 */
	public User getUser(Long id)
	{
		return userFactory.getUser(id);
	}
	
	/**
	 * function to return user from a email
	 * @return User object
	 */
	public User getUserByEmail(String email)
	{
		return userFactory.getUserByEmail(email);
	}
}
