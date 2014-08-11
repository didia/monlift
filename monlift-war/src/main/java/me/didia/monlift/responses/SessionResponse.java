package me.didia.monlift.responses;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionResponse  implements IResponse<me.didia.monlift.securities.Session>{
	public UserResponse user;
	public String token;
	public String status;
	public HashMap<String, String> linkTo = new HashMap<String, String>();
	
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

	@Override
	public void setLinkTo(HashMap<String, String> p_linkTo) {
		linkTo = p_linkTo;
	}
	

}
