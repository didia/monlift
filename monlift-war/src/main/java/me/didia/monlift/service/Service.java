package me.didia.monlift.service;

import me.didia.monlift.managers.UserManager;
import me.didia.monlift.securities.AuthentificationErrorException;
import me.didia.monlift.securities.AuthentificationManager;
import me.didia.monlift.securities.Session;

public class Service {
	
	private static Service instance = null;

	
	private Service(){};
	
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

	public boolean firstnameValidator(String firstname)
	{
		String FIRSTNAME_VALIDATOR = "[a-zA-Z0-9\\._\\-]{3,}";
		return firstname.matches(FIRSTNAME_VALIDATOR);
	}
	public boolean lastnameValidator(String lastname)
	{
		String LASTNAME_VALIDATOR = "[a-zA-Z0-9\\._\\-]{3,}";
		return lastname.matches(LASTNAME_VALIDATOR);
	}
	

	public boolean emailValidator(String email)
	{
		String EMAIL_PATTERN = 
                "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return email.matches(EMAIL_PATTERN);
		
	}
	
	public boolean phoneValidator(String phone)
	{
		String PHONE_VALIDATION_US_CA = "^[+]?[01]?[- .]?(\\([2-9]\\d{2}\\)|[2-9]\\d{2})[- .]?\\d{3}[- .]?\\d{4}$";
		 
		return phone.matches(PHONE_VALIDATION_US_CA);
	}

	public void doRegister(String firstname, String lastname, String email,String phone,String password ) 

	{
		
		try{			
			UserManager.getInstance().createUser(firstname, lastname, email, phone, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		
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
