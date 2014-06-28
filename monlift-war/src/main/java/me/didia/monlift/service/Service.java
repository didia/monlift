package me.didia.monlift.service;

import me.didia.monlift.entities.User;
import me.didia.monlift.helper.HelperFunctions;
import me.didia.monlift.inputValidator.InputValidator;
import me.didia.monlift.managers.UserManager;


public class Service {
	
	private static UserManager userManager = UserManager.getInstance();
	private static InputValidator inputValidator = InputValidator.getInstance();
	private static Service instance  = null;
	private Service(){};
	
	public static Service getInstance(){
		if(instance == null ){
			instance = new Service();
		}
		return instance;
			
	}
	
	/**
	 * Register service 
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param phone
	 * @return id user if user are created else exception
	 */
	public User doRegister(String firstname, String lastname, String email,String phone,String password ) 

	{ 
		User p =null;
		
		try{
			if(inputValidator.firstnameValidator(firstname) && inputValidator.lastnameValidator(lastname) && inputValidator.emailValidator(email) && inputValidator.phoneValidator(phone)){
				 
				System.out.println("on a de bonnes entrée");
				Long id=UserManager.getInstance().createUser(firstname, lastname, email, phone, password);
				p= UserManager.getInstance().getUser(id);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return p;
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
