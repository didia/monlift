/**
 * 
 */
package me.didia.monlift.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.didia.monlift.MonliftContext;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.managers.LiftManager;
import me.didia.monlift.requests.LiftSearchRequest;

/**
 * @author didia
 *
 */
@Path("/search")
public class SearchService {
	
	private static MonliftContext monliftContext = MonliftContext.getInstance();
	
	@POST
	@Path("/lift")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Lift> searchLift() throws Exception{
		
		LiftSearchRequest req = monliftContext.getRequestObject(LiftSearchRequest.class);
		String from =req.getFrom();
		String to = req.getTo();
		
		List<Lift> lifts = LiftManager.getLift(from, to);
		
		return lifts;
	}

}
