package me.didia.monlift.managers;

import java.util.List;

import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.DuplicateValueException;
import me.didia.monlift.factories.LiftFactory;
import me.didia.monlift.requests.CreateCarRequest;
import me.didia.monlift.requests.CreateLiftRequest;

/**
 * @author didia
 *
 */
public class LiftManager {
	private static String[] UPDATABLE_CAR_FIELDS = new String[] {"name","description"};
	private static String[] UPDATABLE_LIFT_FIELDS = new String[] {"from", "to","meetingPlace","time","price","car"};
	public static Car createCar(User user, CreateCarRequest request)
	{
		return LiftFactory.createCar(user, request);
	}
	
	public static Lift createLift(User p_driver, CreateLiftRequest p_request) throws DuplicateValueException
	{ 
		p_request.setDriver(p_driver);
		p_request.setCar(getCar(p_driver, p_request.getCarId()));
		return LiftFactory.createLift(p_request);
	}
	
	public static Car getCar(User p_owner, Long p_id){
		return LiftFactory.getCar(p_owner, p_id);
	}
	
	public static List<Car> getCars(User p_driver) {
		return LiftFactory.getCarsByDriver(p_driver);
	}
	public static Lift getLift(User p_user, Long p_id){
		return LiftFactory.getLiftById(p_user, p_id);
	}
	
	public static List<Lift> getLifts(User p_driver){
		return LiftFactory.getLiftsByDriver(p_driver);
	}
	
	public static List<Lift> getLift(String from, String to){
		return LiftFactory.getLiftByQuery(from, to);
	}
	
	public static Car updateCar(Car p_car, CreateCarRequest p_request)
	{
		for(String field : UPDATABLE_CAR_FIELDS) {
			Object value = p_request.getField(field);
			if(value != null) {
				p_car.setField(field, value);
			}
		}
		return p_car;
	}
	
	public static Lift updateLift(Lift p_lift, CreateLiftRequest p_request) {
		for(String field : UPDATABLE_LIFT_FIELDS) {
			Object value = p_request.getField(field);
			if(value != null) {
				p_lift.setField(field, value);
			}
		}
		return p_lift;
	}
	
	public static void deleteCar(Car p_car) {
		LiftFactory.delete(p_car);
	}
	
	public static void deleteLift(Lift p_lift) {
		LiftFactory.delete(p_lift);
	}
	
	
}
