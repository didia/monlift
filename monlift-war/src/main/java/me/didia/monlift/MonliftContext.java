package me.didia.monlift;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;

import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.AuthentificationErrorException;
import me.didia.monlift.requests.BaseRequest;
import me.didia.monlift.securities.AuthentificationManager;
import me.didia.monlift.securities.Session;

import org.apache.commons.io.IOUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author didia
 *
 */
public class MonliftContext {
	
	private Session session;
	private String inputString = null;
	private static MonliftContext instance;
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static MonliftContext getInstance()
	{
		if(instance == null)
			instance = new MonliftContext();
	
		return instance;
	}
	
	public Session getSession()
	{
		return session;
	}
	
	public User getCurrentUser()
	{
		return session.getUser();
	}
	
	public String getCurrentToken()
	{
		return session.getToken();
	}
	
	public Boolean isSecure()
	{
		return session != null;
	}
	
	public void initialize(ContainerRequestContext requestContext) throws IOException
	{
		initializeSession(requestContext);
	}
	
	private void initializeSession(ContainerRequestContext requestContext) throws IOException
	{
		InputStream inputStream = requestContext.getEntityStream();
    	StringWriter writer = new StringWriter();
    	IOUtils.copy(inputStream, writer, "UTF8");
    	String theString = writer.toString();
    	if(!theString.startsWith("{"))
    	{
    		theString = "{" + theString + "}";
    	}
    	inputString = theString;
    	String token = null;
    	try {
			JSONObject json = new JSONObject(theString);
			token = json.getString("token");
			if(token != null)
			{
				session = AuthentificationManager.getSession(token);	
			}
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		} catch (AuthentificationErrorException e) {
	
			requestContext.abortWith(Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid token used for logging. " + token)
                    .build());
		}		
	}
	
	public  <T extends BaseRequest> T getRequestObject(Class<T> type) throws JsonParseException, JsonMappingException, IOException
	{
		if(inputString == null)
			return null;
		return  objectMapper.readValue(inputString, type);
	}
	
}
