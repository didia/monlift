package me.didia.monlift.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.didia.monlift.MonliftRoutes;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.responses.SuccessResponse;

/**
 * @author didia
 *
 */

@Path(MonliftRoutes.ADMIN_BASE_PATH)
public class AdminService {
	
	@Path(MonliftRoutes.ADMIN_USER_DELETE)
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SuccessResponse deleteUser(@PathParam("id") Long p_userId) {
		UserManager.deleteUser(p_userId);
		SuccessResponse response = new SuccessResponse();
		response.build("User with id " + p_userId + "has been successfully deleted");
		return response;
	}
	
}
