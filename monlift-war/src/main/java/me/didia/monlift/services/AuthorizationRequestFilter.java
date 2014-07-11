/**
 * 
 */
package me.didia.monlift.services;

/**
 * @author didia
 *
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import me.didia.monlift.securities.AuthentificationErrorException;
import me.didia.monlift.securities.AuthentificationManager;
import me.didia.monlift.securities.Session;

import org.apache.commons.io.IOUtils;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;




@Priority(Priorities.AUTHENTICATION)
public class AuthorizationRequestFilter implements ContainerRequestFilter {
 
    @Override
    public void filter(ContainerRequestContext requestContext)
                    throws IOException {
    	
    	InputStream inputStream = requestContext.getEntityStream();
    	StringWriter writer = new StringWriter();
    	IOUtils.copy(inputStream, writer, "UTF8");
    	String theString = writer.toString();
    	if(!theString.startsWith("{"))
    	{
    		theString = "{" + theString + "}";
    	}
    	String token = null;
    	
    	
    	try {
			JSONObject json = new JSONObject(theString);
			token = json.getString("token");
			if(token != null)
			{
				Session session = AuthentificationManager.getInstance().getSession(token);
				requestContext.setSecurityContext(session);
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
}
