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
import me.didia.monlift.entities.Lift;
import me.didia.monlift.exceptions.DuplicateValueException;
import me.didia.monlift.managers.LiftManager;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.requests.CreateLiftRequest;
import me.didia.monlift.responses.LiftResponse;

/**
 * @author didia
 *
 */
@Path("/lifts")
public class LiftService {
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<LiftResponse> getAllLifts(){
		
		return null;
		
	}
	
	@GET
	@Path("{userid}/{id}")
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
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LiftResponse createLift(CreateLiftRequest p_request) throws DuplicateValueException{
		p_request.validate();
		Lift lift = LiftManager.createLift(MonliftContext.getInstance().getCurrentUser(), p_request);
		LiftResponse response = new LiftResponse();
		response.build(lift);
		return response;
	}

	

}
