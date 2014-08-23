
package me.didia.monlift.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.didia.monlift.MonliftContext;
import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.MonliftException;
import me.didia.monlift.exceptions.NotADriverException;
import me.didia.monlift.managers.LiftManager;
import me.didia.monlift.requests.CreateCarRequest;
import me.didia.monlift.responses.CarResponse;

/**
 * @author didia
 *
 */
@Path("/cars")
public class CarService {
	
	private static MonliftContext monliftContext = MonliftContext.getInstance();
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CarResponse createCar() throws MonliftException {
		
		monliftContext.userIsRequired();
		
		CreateCarRequest request = monliftContext.getRequestObject(CreateCarRequest.class);
		User user = monliftContext.getCurrentUser();
		if (!user.isDriver()){
			throw new NotADriverException("User must be a driver to add a car");
		}
		Car car = LiftManager.createCar(user, request);
		CarResponse response = new CarResponse();
		response.build(car);
		
		return response;
	}
}
