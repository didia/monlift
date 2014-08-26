package me.didia.monlift.managers;

import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.DuplicateValueException;
import me.didia.monlift.factories.UserFactory;
import me.didia.monlift.requests.PromoteUserRequest;
import me.didia.monlift.requests.CreateUserRequest;
import me.didia.monlift.securities.AuthentificationManager;

public class UserManager {
	
	private static String[] UPDATABLE_FIELDS = new String[] {"phone","firstname","lastname"};
	
	
	public static User createUser(CreateUserRequest request) throws DuplicateValueException
	{
		String password = AuthentificationManager.generateHashedPassword(request.getPassword());
		request.setPassword(password);
		return UserFactory.createUser(request);
	}
	
	public static User updateUser(User p_user, CreateUserRequest p_request) {
		for(String field : UPDATABLE_FIELDS) {
			Object value = p_request.getField(field);
			if(value != null) {
				p_user.setField(field, value);
			}
		}
		return p_user;
	}
	/** function to promote user to a driver
	 * @param id
	 * @param username
	 * @return void
	 */
	public static void promoteToDriver(User p_user, PromoteUserRequest p_request) throws DuplicateValueException {
		String username = p_request.getUsername();
		p_user.setUsername(username);
		p_user.setDriver(true);
		UserFactory.setUniqueConstraint(p_user, "username", username);
		UserFactory.save(p_user);
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
	public static User getUserByEmail(String email) {
		return UserFactory.getUserByEmail(email);
	}
	
	public static boolean isUserNameTaken(String p_username) {
		User user = UserFactory.getUserByUsername(p_username);
		return user != null?true:false;
	}

	public static void deleteUser(Long p_userId) {
		User user = getUser(p_userId);
		if(user != null)
			UserFactory.delete(user);
		
	}
	
}
