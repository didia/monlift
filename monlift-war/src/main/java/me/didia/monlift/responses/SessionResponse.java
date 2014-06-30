package me.didia.monlift.responses;

import me.didia.monlift.BaseException;

public class SessionResponse  implements IResponse<me.didia.monlift.securities.Session>{
	private UserResponse user;
	private String token;
	public void build(me.didia.monlift.securities.Session session) {
		user = new UserResponse();
		user.build(session.getUser());
		token = session.getToken();
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
	public void build(BaseException e) {
		// TODO Auto-generated method stub
		
	}

}
