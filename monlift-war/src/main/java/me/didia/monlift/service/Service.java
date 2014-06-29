package me.didia.monlift.service;

import me.didia.monlift.entities.User;
import me.didia.monlift.inputValidator.InputValidator;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.securities.AuthentificationErrorException;
import me.didia.monlift.securities.AuthentificationManager;
import me.didia.monlift.securities.Session;


public class Service {
	

	private static UserManager userManager = UserManager.getInstance();
	private static InputValidator inputValidator = InputValidator.getInstance();
	
	private Service(){};
	private static Service instance = null;

	

	/**
	 * Singleton method to return an instance of the Service class
	 * @return Service object
	 */
	public static Service getInstance(){
		if (instance == null){
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
	 * @return session if user found else null
	 */
	public Session doLogin(String email, String password){
		AuthentificationManager am = AuthentificationManager.getInstance();
		Session session = new Session();
		try {
			session = am.createSession(email, password);
		} catch (AuthentificationErrorException e) {
			session = null;
		}
		return session;
	}
	
	public void doLogout(){
		
	}
}
