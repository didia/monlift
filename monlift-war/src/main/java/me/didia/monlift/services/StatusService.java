package me.didia.monlift.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.didia.monlift.MonliftRoutes;
import me.didia.monlift.exceptions.MonliftException;
import me.didia.monlift.responses.InitResponse;
import me.didia.monlift.securities.AuthentificationManager;

@Path("/start")
public class StatusService {
	
	private static final String api_version = "00.01.00";
	
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public InitResponse start() throws MonliftException{
		InitResponse response = new InitResponse();
		response.build("Service is up and running");
		return response;
			

	}
	
	
}
