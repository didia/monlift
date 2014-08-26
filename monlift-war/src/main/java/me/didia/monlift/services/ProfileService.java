package me.didia.monlift.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.didia.monlift.MonliftContext;
import me.didia.monlift.MonliftRoutes;
import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.MonliftException;
import me.didia.monlift.managers.LiftManager;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.marshallers.CarMarshaller;
import me.didia.monlift.marshallers.LiftMarshaller;
import me.didia.monlift.requests.CreateUserRequest;
import me.didia.monlift.requests.PromoteUserRequest;
import me.didia.monlift.responses.CarResponse;
import me.didia.monlift.responses.LiftResponse;
import me.didia.monlift.responses.SuccessResponse;
import me.didia.monlift.responses.UserResponse;

/**
 * @author didia
 *
 */

@Path("/")
public class ProfileService {
	
	private static MonliftContext monliftContext = MonliftContext.getInstance();
	
	@POST
	@Path(MonliftRoutes.PROFILE_SELF_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserResponse getUserProfile() throws MonliftException
	{
		monliftContext.userIsRequired();
		User user = monliftContext.getCurrentUser();
		UserResponse userResponse = new UserResponse();
		userResponse.build(user);
		return userResponse;
	}
	
	@POST
	@Path(MonliftRoutes.USER_EDIT_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserResponse editUserProfile() throws MonliftException {
		monliftContext.userIsRequired();
		User user = monliftContext.getCurrentUser();
		CreateUserRequest request = monliftContext.getRequestObject(CreateUserRequest.class);
		user = UserManager.updateUser(user, request);
		UserResponse userResponse = new UserResponse();
		userResponse.build(user);
		return userResponse;
	}
	@POST
	@Path(MonliftRoutes.USER_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserResponse getUserProfile(@PathParam("id") Long userId) throws MonliftException
	{
		monliftContext.userIsRequired();
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
	@Path(MonliftRoutes.USER_PROMOTE_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SuccessResponse promoteToDriver() throws MonliftException {
		
		monliftContext.userIsRequired();
		PromoteUserRequest request = monliftContext.getRequestObject(PromoteUserRequest.class);
		request.validate();
		UserManager.promoteToDriver(monliftContext.getCurrentUser(), request);
		
		return new SuccessResponse("User successfully promoted to Driver");
		
		
	}
 	
	@POST
	@Path(MonliftRoutes.USER_FIELD_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserResponse getUserProfileField(@PathParam("id") Long userId,
											@PathParam("field") String field) throws MonliftException{
		
		monliftContext.userIsRequired();
		
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
	@Path(MonliftRoutes.LIFTS_BY_USER_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<LiftResponse> getUserLifts(@PathParam("id") Long p_id){
		
		monliftContext.userIsRequired();
		
		List<Lift> userLifts = LiftManager.getLifts(UserManager.getUser(p_id));
		return new LiftMarshaller().marshall(userLifts);
	}
	
	@POST
	@Path(MonliftRoutes.USER_CARS_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<CarResponse> getUserCars(@PathParam("id") Long p_id) {
		
		monliftContext.userIsRequired();
		
		List<Car> userCars = LiftManager.getCars(UserManager.getUser(p_id));
		return new CarMarshaller().marshall(userCars);
	}
	
	

}
