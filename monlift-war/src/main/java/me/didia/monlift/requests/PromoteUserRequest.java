package me.didia.monlift.requests;

/**
 * @author didia
 *
 */
public class PromoteUserRequest extends BaseRequest {
	
	public PromoteUserRequest(){}
	
	public PromoteUserRequest(String p_username) {
		username = p_username;
	}
	
	private String username;
	
	public String getUsername(){
		return username;
	}
	
}
