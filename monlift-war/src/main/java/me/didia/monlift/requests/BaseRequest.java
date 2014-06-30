package me.didia.monlift.requests;

public class BaseRequest implements IRequest{
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void validate() throws ValidationErrorException {
		if(token.isEmpty() || token == ""){
			throw new ValidationErrorException("empty token provided");
		}
	}
		
}
