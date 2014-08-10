package me.didia.monlift.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import me.didia.monlift.managers.UserManager;
import me.didia.monlift.requests.BaseRequest;
import me.didia.monlift.requests.CreateCarRequest;
import me.didia.monlift.requests.CreateLiftRequest;
import me.didia.monlift.requests.IRequest;
import me.didia.monlift.requests.LoginRequest;
import me.didia.monlift.requests.PromoteUserRequest;
import me.didia.monlift.requests.RegisterRequest;
import me.didia.monlift.requests.UpdateUserRequest;
import me.didia.monlift.visitors.RequestValidatorVisitor;



public class RequestValidatorVisitor implements RequestVisitor {
	private List<String> m_errors = new ArrayList<String>();
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
		if(p_email != null)
		{
			String emailPattern = 
		
                "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			if(p_email.matches(emailPattern))
			{
				return true;
			};
			
			m_errors.add("The email: " + p_email + " is not a valid email.");
			
			return false;
		}
		return true;
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
	public void visit(RegisterRequest p_request) {
		String[] required_fields = {"firstname", "lastname", "email", "phone", "phone"};
		if(!validateFieldsNonEmpty(p_request, required_fields)){
			p_request.setValid(false);
		}
		if(!validateEmail(p_request.getEmail())){
			p_request.setValid(false);
		}
		if(!validateString(p_request.getFirstname())) {
			p_request.setValid(false);
		}
		
		
	}

	@Override
	public void visit(UpdateUserRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CreateLiftRequest p_request) {
		String[] requiredFields =  {"from","to","time","price","carId","totalPlace"};
		if(!validateFieldsNonEmpty(p_request, requiredFields)){
			p_request.setValid(false);
		}	
		
	}
	
	private boolean validateFieldsNonEmpty(BaseRequest request, String... p_fieldNames){
		List<String> missing_fields = new ArrayList<String>();
		for(String field:p_fieldNames){
			if(request.getField(field) == null){
				missing_fields.add(field);
			}
		}
		if(missing_fields.isEmpty()){
			return true;
		}
		String message = "Fields: " + StringUtils.join(",", missing_fields) + " are missing";
		m_errors.add(message);
		
		return false;
	}

	@Override
	public void visit(PromoteUserRequest p_request) {
		String[] requiredFields = {"username"};
		if(!validateFieldsNonEmpty(p_request, requiredFields)){
			p_request.setValid(false);
		}
		
		if(UserManager.isUserNameTaken(p_request.getUsername())){
			m_errors.add("The username "+p_request.getUsername() + " is already taken");
			p_request.setValid(false);
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
