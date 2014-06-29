package me.didia.monlift.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.didia.monlift.helper.ToJSON;
import me.didia.monlift.securities.Session;

import org.codehaus.jettison.json.JSONObject;

@Path("/oauth")
public class OauthService {
	
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public Response login(DataSent user){
		JSONObject jsonResponse = new JSONObject();
		Service serviceInstance = Service.getInstance();
		
		String returnString;
		String email = user.getEmail();
		String password = user.getPassword();
		
		try {
			Session session = serviceInstance.doLogin(email, password);
			if(session!=null){
				jsonResponse = ToJSON.sessionToJSON(session);
				jsonResponse.put("status", "found");	
			}else{
				jsonResponse.put("status", "not found");
			}	
			
		} catch (Exception e) {
			//error in json processing
			e.printStackTrace();
		}
		returnString=jsonResponse.toString();
		return Response.ok(returnString).build();
	}
	
	
	
	@POST
	@Path("/signup")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON }) 
	public Response signup(){
		return null;
		
	}
}


class DataSent{
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
