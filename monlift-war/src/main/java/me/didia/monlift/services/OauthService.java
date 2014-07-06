package me.didia.monlift.services;



import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.didia.monlift.BaseException;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.marshallers.SessionMarshaller;
import me.didia.monlift.requests.BaseRequest;
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
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SessionResponse login(LoginRequest user) throws BaseException{
		String email = user.getEmail();
		String password = user.getPassword();
		AuthentificationManager managerInstance = AuthentificationManager.getInstance();
		
		return SessionMarshaller.getInstance().marshall(managerInstance.createSession(email, password));
	
		
	}
	
	
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SessionResponse register(RegisterRequest registerData) throws BaseException{

			registerData.validate();
			UserManager.getInstance().createUser(registerData.getFirstname(),registerData.getLastname(),registerData.getEmail(),registerData.getPhone(),registerData.getPassword());
			return SessionMarshaller.getInstance().marshall(AuthentificationManager.getInstance().createSession(registerData.getEmail(), registerData.getPassword()));
	}
	
	@POST
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SessionResponse logout(BaseRequest logoutRequest) throws BaseException{
		SessionResponse response = new SessionResponse();
		logoutRequest.validate();
		AuthentificationManager.getInstance().getSession(logoutRequest.getToken());
		AuthentificationManager.getInstance().deleteSession(logoutRequest.getToken());
		response.setStatus("logged_out");
		return response;
			

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
