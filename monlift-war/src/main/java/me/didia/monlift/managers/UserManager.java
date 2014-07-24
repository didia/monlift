package me.didia.monlift.managers;

import me.didia.monlift.entities.User;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.factories.UserFactory;
import me.didia.monlift.requests.RegisterRequest;
import me.didia.monlift.securities.AuthentificationManager;

public class UserManager {
	
	
	public static User createUser(RegisterRequest request) throws DuplicateValueException
	{
		String password = AuthentificationManager.generateHashedPassword(request.getPassword());
		request.setPassword(password);
		return UserFactory.createUser(request);
	}
	
	 /* function to promote user to a driver
	 * @param id
	 * @param username
	 * @return void
	 */
	public static void promoteToDriver(Long id, String username) throws DuplicateValueException{
		User userToPromote = getUser(id);
		userToPromote.setUsername(username);
		userToPromote.setDriver(true);
		UserFactory.setUniqueConstraint(userToPromote, "username", username);
		UserFactory.save(userToPromote);
	}
	
	/**
	 * function to return user from an Id
	 * @return UserResponse object
	 */
	public static User getUser(Long id)
	{
		return UserFactory.getUser(id);
	}
	
	/**
	 * function to return user from a email
	 * @return UserResponse object
	 */
	public static User getUserByEmail(String email)
	{
		return UserFactory.getUserByEmail(email);
	}
	
}
