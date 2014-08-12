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
	
	public static Lift getLift(User p_user, Long p_id){
		return LiftFactory.getLiftById(p_user, p_id);
	}
	
	public static List<Lift> getLift(User p_driver){
		return LiftFactory.getLiftsByDriver(p_driver);
	}
	
	public static List<Lift> getLift(String from, String to){
		return LiftFactory.getLiftByQuery(from, to);
	}
	
	
	
}
