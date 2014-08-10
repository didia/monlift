/**
 * 
 */
package me.didia.monlift.services;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import me.didia.monlift.exceptions.MonliftException;

/**
 * @author didia
 *
 */
@Provider
public class BaseExceptionMapper implements
ExceptionMapper<MonliftException> { 
	
	@Override
	public Response toResponse(MonliftException ex) {
		return Response.status(404).entity(ex.getMessage()).type("application/json")
	            .build();
	}
}