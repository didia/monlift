/**
 * 
 */
package me.didia.monlift.services;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.http.HttpStatus;

import me.didia.monlift.exceptions.DuplicateValueException;

/**
 * @author didia
 *
 */

@Provider
public class DuplicateValueExceptionMapper implements ExceptionMapper<DuplicateValueException> {

	@Override
	public Response toResponse(DuplicateValueException ex) {
		
		return Response.status(HttpStatus.SC_BAD_REQUEST).entity(ex.getMessage()).type("application/json")
	            .build();
	}

}
