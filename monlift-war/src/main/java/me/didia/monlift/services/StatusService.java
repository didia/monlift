package me.didia.monlift.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/status")
public class StatusService {
	
	private static final String api_version = "00.01.00";
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public StatusResponse returnTitle( ){
		StatusResponse response = new StatusResponse("Java web application");
		return response;
		
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public StatusResponse returnVersion(){
		StatusResponse response = new StatusResponse("<p>Version: </p>"+ api_version);
		return response;
	}
	
	class StatusResponse{
		
		private String message;
		
		public StatusResponse(String message){
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		
	}
	
}
