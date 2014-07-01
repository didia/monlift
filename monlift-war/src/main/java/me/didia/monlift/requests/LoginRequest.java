package me.didia.monlift.requests;

public class LoginRequest implements IRequest{
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void validate() throws ValidationErrorException {
		// TODO Auto-generated method stub
		
	}
}
