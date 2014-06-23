package me.didia.monlift.service;

import me.didia.monlift.entities.User;
import me.didia.monlift.factories.UserFactory;
import me.didia.monlift.helper.HelperFunctions;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class Service {

	public void doRegister(String firstname, String lastname, String email, String phone )
	{
		try{
			UserFactory.getInstance().createUser(firstname, lastname, email, phone);
		}catch(Exception e){
			e.printStackTrace();
		}
		
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
