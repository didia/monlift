package me.didia.monlift.services;



import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.didia.monlift.MonliftContext;
import me.didia.monlift.MonliftRoutes;
import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.MonliftException;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.marshallers.SessionMarshaller;
import me.didia.monlift.requests.LoginRequest;
import me.didia.monlift.requests.CreateUserRequest;
import me.didia.monlift.responses.SessionResponse;
import me.didia.monlift.securities.AuthentificationManager;
import me.didia.monlift.securities.Session;


@Path(MonliftRoutes.OAUTH_BASE_PATH)
public class OauthService {
	
	private static MonliftContext monliftContext = MonliftContext.getInstance();
	
	@POST
	@Path(MonliftRoutes.OAUTH_LOGIN_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SessionResponse login() throws Exception{
		LoginRequest loginRequest = monliftContext.getRequestObject(LoginRequest.class);
		String email = loginRequest.getEmail();
		String password = loginRequest.getPassword();
		
		return SessionMarshaller.getInstance().marshall(AuthentificationManager.createSession(email, password));
	
		
	}
	
	
	
	@POST
	@Path(MonliftRoutes.OAUTH_REGISTER_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SessionResponse register() throws MonliftException{

		
		CreateUserRequest registerData = monliftContext.getRequestObject(CreateUserRequest.class);
		registerData.validate();
		
		User user = UserManager.createUser(registerData);
		Session session = AuthentificationManager.createSession(user);
		return SessionMarshaller.getInstance().marshall(session);
	}
	
	@POST
	@Path(MonliftRoutes.OAUTH_LOGOUT_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logout() throws MonliftException{
		String token = monliftContext.getCurrentToken();
		
		AuthentificationManager.deleteSession(token);
		
		return Response.ok("Logged out").status(200).build();
			

	}
}
