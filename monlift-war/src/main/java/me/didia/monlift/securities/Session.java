/**
 * 
 */
package me.didia.monlift.securities;

import me.didia.monlift.entities.User;

/**
 * @author didia
 *
 */
public class Session {
	private User user;
	private String token;
	public Session()
	{
		
	}
	public Session(User user, String token)
	{
		this.user = user;
		this.token = token;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	
}
