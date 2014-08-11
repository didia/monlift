package me.didia.monlift.services;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import me.didia.monlift.MonliftContext;
import me.didia.monlift.MonliftPath;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.MonliftException;
import me.didia.monlift.managers.LiftManager;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.marshallers.LiftMarshaller;
import me.didia.monlift.marshallers.SessionMarshaller;
import me.didia.monlift.requests.PromoteUserRequest;
import me.didia.monlift.requests.RegisterRequest;
import me.didia.monlift.requests.UpdateUserRequest;
import me.didia.monlift.responses.LiftResponse;
import me.didia.monlift.responses.SessionResponse;
import me.didia.monlift.responses.SuccessResponse;
import me.didia.monlift.responses.UserResponse;
import me.didia.monlift.securities.AuthentificationManager;
import me.didia.monlift.securities.Session;

/**
 * @author didia
 *
 */

@Path("/")
public class ProfileService {
	
	private static MonliftContext monliftContext = MonliftContext.getInstance();
	
	@POST
	@Path(MonliftPath.PROFILE_SELF_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserResponse getUserProfile() throws MonliftException
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
	@Path(MonliftPath.USER_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserResponse getUserProfile(@PathParam("id") Long userId) throws MonliftException
	{
		User user = UserManager.getUser(userId);
		if(user == null)
		{
			throw new MonliftException("Bad Request: Unknown user id");
		}
		UserResponse userResponse = new UserResponse();
		userResponse.build(user);
		userResponse.blurPrivate();
		return userResponse;
	}
	
	@POST
	@Path(MonliftPath.USER_FIELD_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserResponse getUserProfileField(@PathParam("id") Long userId,
											@PathParam("field") String field) throws MonliftException{
		String[] fields = field.split(",");
		User user = UserManager.getUser(userId);
		
		if(user == null)
		{
			throw new MonliftException("Bad Request: Unknow user id");
		}
		
		UserResponse userResponse = new UserResponse();
		userResponse.build(user, fields);
		userResponse.blurPrivate();
		
		return userResponse;
	}
	
	@POST
	@Path(MonliftPath.USER_LIFTS_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<LiftResponse> getUserLifts(@PathParam("id") Long p_id){
		
		List<Lift> userLifts = LiftManager.getLift(UserManager.getUser(p_id));
		return new LiftMarshaller().marshall(userLifts);
	}
	
	@POST
	@Path(MonliftPath.USER_EDIT_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SessionResponse register(UpdateUserRequest registerData) throws MonliftException{

			return null;
	}
	
	@POST
	@Path(MonliftPath.USER_PROMOTE_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SuccessResponse promoteToDriver(PromoteUserRequest p_request) throws MonliftException {
		p_request.validate();
		UserManager.promoteToDriver(monliftContext.getCurrentUser(), p_request);
		
		return new SuccessResponse("User successfully promoted to Driver");
		
		
	}
}
