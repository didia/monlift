package me.didia.monlift.inputValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.didia.monlift.inputValidator.InputValidator;



public class InputValidator{
	private static InputValidator instance = null;
		private InputValidator(){};

	/**
	 * Singleton method to return an instance of the InputValidator  class
	 * @return InputValidator object
	 */
	public static InputValidator getInstance(){
		if(instance == null){
			instance = new InputValidator();
		}
		return instance;
	}
	public boolean firstnameValidator(String firstname)
	{
		String FIRSTNAME_VALIDATOR = "^[\\p{L} .'-]+$";
		Pattern pattern = Pattern.compile(FIRSTNAME_VALIDATOR,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(firstname);  
		return matcher.find();
	}
	public boolean lastnameValidator(String lastname)
	{
		String LASTNAME_VALIDATOR = "^[\\p{L} .'-]+$";
		Pattern pattern = Pattern.compile(LASTNAME_VALIDATOR,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(lastname);  
		return matcher.find();	
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
	
//	public boolean passeWordMatch(String pwd)
//	{
//	
//		Pattern p1  = Pattern.compile("^\\w{8,}$");
//		Pattern p2  = Pattern.compile("\\d+(.*)?\\d+");
//		
//	return p1.matcher(pwd).find() && p2.matcher(pwd).find();
//	}
//	
}
