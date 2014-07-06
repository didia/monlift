/**
 * 
 */
package me.didia.monlift.services;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


import me.didia.monlift.BaseException;

/**
 * @author didia
 *
 */
@Provider
public class BaseExceptionMapper implements
ExceptionMapper<BaseException> { 
	
	@Override
	public Response toResponse(BaseException ex) {
		return Response.status(404).entity(ex.getMessage()).type("application/json")
	            .build();
	}
}