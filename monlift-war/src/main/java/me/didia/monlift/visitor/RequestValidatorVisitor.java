package me.didia.monlift.visitor;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.didia.monlift.requests.CreateCarRequest;
import me.didia.monlift.requests.CreateLiftRequest;
import me.didia.monlift.requests.LoginRequest;
import me.didia.monlift.requests.RegisterRequest;
import me.didia.monlift.requests.UpdateUserRequest;
import me.didia.monlift.visitor.RequestValidatorVisitor;



public class RequestValidatorVisitor implements RequestVisitor {
	private static RequestValidatorVisitor instance = null;
		private RequestValidatorVisitor(){};

	/**
	 * Singleton method to return an instance of the InputValidator  class
	 * @return InputValidator object
	 */
	public static RequestValidatorVisitor getInstance(){
		if(instance == null){
			instance = new RequestValidatorVisitor();
		}
		return instance;
	}
	
	private boolean validateString(String p_string)
	{
		if(p_string != null)
		{
			String patternToAvoid = "^[\\p{L} .'-]+$";
			Pattern pattern = Pattern.compile(patternToAvoid,Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(p_string);  
			return matcher.find();
		}
		return true;
	}
	
	private boolean validateStringNonEmpty(String p_string){
		if(p_string == null || p_string.equals(""))
		{
			return false;
		}
		
		return validateString(p_string);
		
	}
	
	private boolean validateEmail(String p_email){
		String emailPattern = 
                "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return p_email.matches(emailPattern);
	}
	
	private boolean validatePhoneNumber(String p_phone){
		String caPhonePattern = "^[+]?[01]?[- .]?(\\([2-9]\\d{2}\\)|[2-9]\\d{2})[- .]?\\d{3}[- .]?\\d{4}$";
		 
		return p_phone.matches(caPhonePattern);		
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

	@Override
	public void visit(CreateCarRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LoginRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(RegisterRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UpdateUserRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CreateLiftRequest request) {
		ArrayList<String> missing_fields = new ArrayList<String>();
		if(request.getFrom() == null || request.getFrom().equals(""))
		{
			missing_fields.add(CreateLiftRequest.FROM_FIELD);
		}
		if( ! validateStringNonEmpty(request.getFrom()))
		{
			missing_fields.add(CreateLiftRequest.FROM_FIELD);
		}
		if(!validateStringNonEmpty(request.getTo()))
		{
			missing_fields.add(CreateLiftRequest.TO_FIELD);
		}		
		
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
