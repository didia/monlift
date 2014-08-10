package me.didia.monlift.services;



import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.didia.monlift.MonliftContext;
import me.didia.monlift.exceptions.MonliftException;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.marshallers.SessionMarshaller;
import me.didia.monlift.requests.LoginRequest;
import me.didia.monlift.requests.RegisterRequest;
import me.didia.monlift.responses.SessionResponse;
import me.didia.monlift.securities.AuthentificationManager;


@Path("/oauth")
public class OauthService {
	
	private static MonliftContext monliftContext = MonliftContext.getInstance();
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SessionResponse login() throws Exception{
		LoginRequest loginRequest = monliftContext.getRequestObject(LoginRequest.class);
		String email = loginRequest.getEmail();
		String password = loginRequest.getPassword();
		
		return SessionMarshaller.getInstance().marshall(AuthentificationManager.createSession(email, password));
	
		
	}
	
	
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SessionResponse register() throws Exception{

		
		RegisterRequest registerData = monliftContext.getRequestObject(RegisterRequest.class);
		registerData.validate();
		UserManager.createUser(registerData);
		return SessionMarshaller.getInstance().marshall(AuthentificationManager.createSession(registerData.getEmail(), registerData.getPassword()));
	}
	
	@POST
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logout() throws MonliftException{
		String token = monliftContext.getCurrentToken();
		
		AuthentificationManager.deleteSession(token);
		
		return Response.ok("Logged out").status(200).build();
			

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
