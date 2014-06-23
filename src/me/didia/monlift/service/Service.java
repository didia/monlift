package me.didia.monlift.service;
import org.owasp.validator.html.*;

import me.didia.monlift.entities.User;
import me.didia.monlift.factories.UserFactory;
import me.didia.monlift.helper.HelperFunctions;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class Service {
	/**
	 * Register service 
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param phone
	 * @return id user if user are created else exception
	 */
	
	public void doRegister(String firstname, String lastname, String email,String phone ) throws ScanException, PolicyException
	{
		AntiSamy as = new AntiSamy();
		Policy policy = Policy.getInstance("/monlift/war/antisamy-ebay-1.4.4.xml");
		
		try{
<<<<<<< HEAD
			CleanResults crFirstname = as.scan(firstname, policy);
			CleanResults crLasttname = as.scan(lastname,policy);
			CleanResults crEmail = as.scan(email, policy);
			CleanResults crPhone = as.scan(phone, policy);
			
			/**  list of String error messages*/
			crFirstname.getErrorMessages();
			crLasttname.getErrorMessages();
			crEmail.getErrorMessages();
			crPhone.getErrorMessages();
		
	}
	
	/**
	 * login service 
	 * 
	 * @param email
	 * @param password
	 * @return token if user found else null
	 */
	public String doLogin(String email, String password){
		String token = null;
		User loggingInUser =null;// UserFactory.getUserByEmailandPassword(email, password);
		if(loggingInUser !=null){
			token = HelperFunctions.generateToken(loggingInUser);
		}
		return token;
	}
	
	public void doLogout(){
		
	}
}
