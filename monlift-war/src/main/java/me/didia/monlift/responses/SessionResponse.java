package me.didia.monlift.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

import me.didia.monlift.BaseException;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.requests.ValidationErrorException;
import me.didia.monlift.securities.AuthentificationErrorException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionResponse  implements IResponse<me.didia.monlift.securities.Session>{
	private UserResponse user;
	private String token;
	private String status;
	public void build(me.didia.monlift.securities.Session session) {
		user = new UserResponse();
		user.build(session.getUser());
		token = session.getToken();
		status = "ok";
	}
	
	/**
	 * @return the user
	 */
	public UserResponse getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserResponse user) {
		this.user = user;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public void blurPrivate() {
		
	}
	

}
