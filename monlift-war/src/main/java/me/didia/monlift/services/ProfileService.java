package me.didia.monlift.services;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import me.didia.monlift.BaseException;
import me.didia.monlift.MonliftContext;
import me.didia.monlift.entities.User;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.marshallers.SessionMarshaller;
import me.didia.monlift.requests.RegisterRequest;
import me.didia.monlift.requests.UpdateUserRequest;
import me.didia.monlift.responses.SessionResponse;
import me.didia.monlift.responses.UserResponse;
import me.didia.monlift.securities.AuthentificationManager;
import me.didia.monlift.securities.Session;

/**
 * @author didia
 *
 */

@Path("/profile")
public class ProfileService {
	
	private static MonliftContext monliftContext = MonliftContext.getInstance();
	
	@POST
	@Path("/me")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserResponse getUserProfile() throws BaseException
	{
		
		/*
		User user = userManager.getUser();
		if(user == null)
		{
			throw new BaseException("Bad Request: Unknown user id");
		}
		UserResponse userResponse = new UserResponse();
		userResponse.build(user);
		*/
		User user = monliftContext.getCurrentUser();
		UserResponse userResponse = new UserResponse();
		userResponse.build(user);
		return userResponse;
	}
	
	@POST
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserResponse getUserProfile(@PathParam("userId") Long userId) throws BaseException
	{
		User user = UserManager.getUser(userId);
		if(user == null)
		{
			throw new BaseException("Bad Request: Unknown user id");
		}
		UserResponse userResponse = new UserResponse();
		userResponse.build(user);
		userResponse.blurPrivate();
		return userResponse;
	}
	
	@POST
	@Path("/{userId}/{field}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserResponse getUserProfileField(@PathParam("userId") Long userId,
											@PathParam("field") String field) throws BaseException{
		String[] fields = field.split(",");
		User user = UserManager.getUser(userId);
		
		if(user == null)
		{
			throw new BaseException("Bad Request: Unknow user id");
		}
		
		UserResponse userResponse = new UserResponse();
		userResponse.build(user, fields);
		userResponse.blurPrivate();
		
		return userResponse;
	}
	
	@POST
	@Path("/edit")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SessionResponse register(UpdateUserRequest registerData) throws BaseException{

			return null;
	}
	
}
