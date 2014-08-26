package me.didia.monlift.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.didia.monlift.MonliftContext;
import me.didia.monlift.MonliftRoutes;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.DuplicateValueException;
import me.didia.monlift.exceptions.MonliftException;
import me.didia.monlift.managers.LiftManager;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.marshallers.LiftMarshaller;
import me.didia.monlift.requests.CreateLiftRequest;
import me.didia.monlift.responses.LiftResponse;
import me.didia.monlift.responses.SuccessResponse;

/**
 * @author didia
 *
 */
@Path(MonliftRoutes.BASE_PATH)
public class LiftService {
	
	private static MonliftContext monliftContext = MonliftContext.getInstance();
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<LiftResponse> getAllLifts(){
		monliftContext.userIsRequired();
		User user = monliftContext.getCurrentUser();
		List<Lift> lifts = LiftManager.getLifts(user);
		
		return new LiftMarshaller().marshall(lifts);		
	}
	
	@GET
	@Path(MonliftRoutes.LIFTS_SHOW_PUBLIC_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LiftResponse getLift(@PathParam("id") Long p_liftId,
								@PathParam("userid") Long p_userId){
		
		Lift lift = LiftManager.getLift(UserManager.getUser(p_userId), p_liftId);
		LiftResponse liftResponse = new LiftResponse();
		liftResponse.build(lift);
		
		return liftResponse;
		
	}
	
	@POST
	@Path(MonliftRoutes.LIFTS_CREATE_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LiftResponse createLift() throws DuplicateValueException {
		
		monliftContext.userIsRequired();
		
		CreateLiftRequest p_request = monliftContext.getRequestObject(CreateLiftRequest.class);
		p_request.validate();
		Lift lift = LiftManager.createLift(monliftContext.getCurrentUser(), p_request);
		LiftResponse response = new LiftResponse();
		response.build(lift);
		return response;
	}
	
	@POST
	@Path(MonliftRoutes.LIFTS_EDIT_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LiftResponse editLift(@PathParam("id") Long p_id) throws MonliftException {
		monliftContext.userIsRequired();
		User user = monliftContext.getCurrentUser();
		CreateLiftRequest request = monliftContext.getRequestObject(CreateLiftRequest.class);
		Lift lift = LiftManager.getLift(user, p_id);
		lift = LiftManager.updateLift(lift, request);
		
		return new LiftMarshaller().marshall(lift);
		
		
	}
	
	@POST
	@Path(MonliftRoutes.LIFTS_DELETE_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SuccessResponse deleteLift(@PathParam("id") Long p_id) throws MonliftException {
		monliftContext.userIsRequired();
		
		User user = monliftContext.getCurrentUser();
		Lift lift = LiftManager.getLift(user, p_id);
		LiftManager.deleteLift(lift);
		SuccessResponse response = new SuccessResponse();
		response.build("Lift has been successfully deleted");
		return response;
	}
	

}
