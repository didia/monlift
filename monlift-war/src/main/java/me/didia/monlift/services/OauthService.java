package me.didia.monlift.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.marshallers.SessionMarshaller;
import me.didia.monlift.requests.LoginRequest;
import me.didia.monlift.requests.RegisterRequest;
import me.didia.monlift.responses.SessionResponse;
import me.didia.monlift.securities.Session;


@Path("/oauth")
public class OauthService {
	
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public SessionResponse login(LoginRequest user){
		Service serviceInstance = Service.getInstance();
		String email = user.getEmail();
		String password = user.getPassword();
		
		Session session = serviceInstance.doLogin(email, password);
		return SessionMarshaller.getInstance().marshall(session);
	}
	
	
	
	@POST
	@Path("/register")
	@Produces("application/json")
	@Consumes("application/json")
	public SessionResponse register(RegisterRequest registerData){
		Service serviceInstance = Service.getInstance();
		Session session= null;
		try {
			serviceInstance.doRegister(registerData.getFirstname(),registerData.getLastname(),registerData.getEmail(),registerData.getPhone(),registerData.getPassword());
			session = serviceInstance.doLogin(registerData.getEmail(), registerData.getPassword());
			return SessionMarshaller.getInstance().marshall(session);
		} catch (DuplicateValueException e) {
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
