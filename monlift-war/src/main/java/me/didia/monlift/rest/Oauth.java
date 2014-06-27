package me.didia.monlift.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

@Path("/oauth")
public class Oauth {

	@Path("/login")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON }) 
	public Response login(String incomingString){
		Response rb = null;
		JSONArray array = new JSONArray();
		
		System.out.print("The imcoming string is " + incomingString);
		
		String returnString=incomingString;
		rb=Response.ok(returnString).build();
		return rb;
	}
	
	@Path("/signup")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON }) 
	public Response signup(){
		return null;
		
	}
}
