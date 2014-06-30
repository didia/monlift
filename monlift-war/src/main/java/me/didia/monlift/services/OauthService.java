package me.didia.monlift.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.marshallers.SessionMarshaller;
import me.didia.monlift.requests.LoginRequest;
import me.didia.monlift.requests.RegisterRequest;
import me.didia.monlift.requests.ValidationErrorException;
import me.didia.monlift.responses.SessionResponse;
import me.didia.monlift.securities.AuthentificationErrorException;
import me.didia.monlift.securities.AuthentificationManager;


@Path("/oauth")
public class OauthService {
	
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public SessionResponse login(LoginRequest user){
		String email = user.getEmail();
		String password = user.getPassword();
		AuthentificationManager managerInstance = AuthentificationManager.getInstance();
		try {
			return SessionMarshaller.getInstance().marshall(managerInstance.createSession(email, password));
		} catch (AuthentificationErrorException e) {
			return SessionMarshaller.getInstance().marshall(e);
		}
		
	}
	
	
	
	@POST
	@Path("/register")
	@Produces("application/json")
	@Consumes("application/json")
	public SessionResponse register(RegisterRequest registerData){
		try {
			registerData.validate();
			UserManager.getInstance().createUser(registerData.getFirstname(),registerData.getLastname(),registerData.getEmail(),registerData.getPhone(),registerData.getPassword());
			return SessionMarshaller.getInstance().marshall(AuthentificationManager.getInstance().createSession(registerData.getEmail(), registerData.getPassword()));
			
		} catch (ValidationErrorException e) {
			return SessionMarshaller.getInstance().marshall(e);
		} catch(DuplicateValueException e){
			return SessionMarshaller.getInstance().marshall(e);
		} catch(AuthentificationErrorException e){
			return SessionMarshaller.getInstance().marshall(e);
		}
		
		
	}

}

/**
 * Authentication API , 
 * full link is /api/oauth/
 * ajax request example :
 * function(){
		var person ={
			    "email": "jake",
			    "password": "massa"
			};
		  $.ajax({
	            url: '/api/oauth/login',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(person),
	            dataType: 'json',
	            success:function(data){
	            	var status = data.status
	            	var user = JSON.parse (data.user);
	            	var token = data.token;
	            	var firstname = user.firstname;
	            	console.log("userfirstname is "+ firstname);
	            },
	            error: function(jqXHR,textStatus,errorThrown){
	            	alert("Error is" +jqXHR+textStatus,errorThrown);
	            }
	        });
	        return false;
	    };
 * @author theotherside
 *
 */
