package me.didia.monlift.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.rest_entities.LoginDataReceived;
import me.didia.monlift.rest_entities.RegisterDataReceived;
import me.didia.monlift.securities.Session;


@Path("/oauth")
public class OauthService {
	
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public Session login(LoginDataReceived user){
		Service serviceInstance = Service.getInstance();
		String email = user.getEmail();
		String password = user.getPassword();
		Session session = serviceInstance.doLogin(email, password);
		return session;
	}
	
	
	
	@POST
	@Path("/register")
	@Produces("application/json")
	@Consumes("application/json")
	public Session register(RegisterDataReceived registerData){
		Service serviceInstance = Service.getInstance();
		Session session= null;
		try {
			serviceInstance.doRegister(registerData.getFirstname(),registerData.getLastname(),registerData.getEmail(),registerData.getPhone(),registerData.getPassword());
			session = serviceInstance.doLogin(registerData.getEmail(), registerData.getPassword());
			return session;
		} catch (DuplicateValueException e) {
			
		}
		return session;
		
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
