package me.didia.monlift.managers;

import java.util.List;

import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.entities.User;
import me.didia.monlift.factories.DuplicateValueException;
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
	
	public static Lift createLift(User user, CreateLiftRequest request) throws DuplicateValueException
	{ 
		return LiftFactory.createLift(user, request);
	}
	
	public static Car getCar(User p_owner, Long p_id){
		return LiftFactory.getCar(p_owner, p_id);
	}
	
	public static Lift getLift(Long p_id){
		return LiftFactory.getLiftById(p_id);
	}
	
	public static List<Lift> getLift(User p_driver){
		return LiftFactory.getLiftsByUser(p_driver);
	}
	
	
	
}
