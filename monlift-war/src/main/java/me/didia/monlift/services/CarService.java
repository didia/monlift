
package me.didia.monlift.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.didia.monlift.MonliftContext;
import me.didia.monlift.MonliftRoutes;
import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.MonliftException;
import me.didia.monlift.exceptions.NotADriverException;
import me.didia.monlift.managers.LiftManager;
import me.didia.monlift.marshallers.CarMarshaller;
import me.didia.monlift.requests.CreateCarRequest;
import me.didia.monlift.responses.CarResponse;
import me.didia.monlift.responses.SuccessResponse;
/**
 * @author didia
 *
 */
@Path(MonliftRoutes.CARS_BASE_PATH)
public class CarService {
	
	private static MonliftContext monliftContext = MonliftContext.getInstance();
	
	@POST
	@Path(MonliftRoutes.CARS_CREATE_PATH)
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
	
	@POST
	@Path(MonliftRoutes.CARS_SHOW_PATH)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CarResponse showCar(@PathParam("id") Long p_id) throws MonliftException {
		monliftContext.userIsRequired();
		
		User user = monliftContext.getCurrentUser();
		Car car = LiftManager.getCar(user, p_id);
		
		return new CarMarshaller().marshall(car);
		
		
	}
	
	@POST
	@Path(MonliftRoutes.CARS_EDIT_PATH)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CarResponse editCar(@PathParam("id") Long p_id) throws MonliftException {
		monliftContext.userIsRequired();
		CreateCarRequest request = monliftContext.getRequestObject(CreateCarRequest.class);
		User user = monliftContext.getCurrentUser();
		Car car = LiftManager.getCar(user, p_id);
		car = LiftManager.updateCar(car, request);
		
		return new CarMarshaller().marshall(car);
		
	}
	
	@POST
	@Path(MonliftRoutes.CARS_DELETE_PATH)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessResponse deleteCar(@PathParam("id") Long p_id) throws MonliftException {
		monliftContext.userIsRequired();
		
		User user = monliftContext.getCurrentUser();
		Car car = LiftManager.getCar(user, p_id);
		
		LiftManager.deleteCar(car);
		
		SuccessResponse response= new SuccessResponse();
		response.build("Car has been successfully deleted");
		
		return response;

	}
}
