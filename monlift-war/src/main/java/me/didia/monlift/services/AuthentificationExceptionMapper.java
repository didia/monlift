/**
 * 
 */
package me.didia.monlift.services;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


import org.apache.http.HttpStatus;

import me.didia.monlift.securities.AuthentificationErrorException;


/**
 * @author didia
 *
 */
@Provider
public class AuthentificationExceptionMapper implements ExceptionMapper<AuthentificationErrorException>  {

	@Override
	public Response toResponse(AuthentificationErrorException ex) {
		return Response.status(HttpStatus.SC_UNAUTHORIZED).entity(ex.getMessage()).type("text/plain")
	            .build();
		
	}

}
