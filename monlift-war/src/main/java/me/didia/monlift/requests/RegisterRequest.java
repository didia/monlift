package me.didia.monlift.requests;

import me.didia.monlift.visitor.RequestValidatorVisitor;

public class RegisterRequest extends BaseRequest{
	
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String password;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void validate() {
		RequestValidatorVisitor inputValidator = RequestValidatorVisitor.getInstance();
		if(inputValidator.firstnameValidator(firstname) && inputValidator.lastnameValidator(lastname) && inputValidator.emailValidator(email) && inputValidator.phoneValidator(phone)){
			m_valid = true;
		}else{
			m_valid = false;
		}
		
	}

}
