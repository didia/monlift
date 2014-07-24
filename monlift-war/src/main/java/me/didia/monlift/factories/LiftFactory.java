/**
 * 
 */
package me.didia.monlift.factories;

import java.util.ArrayList;

import com.googlecode.objectify.Key;

import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.requests.CreateCarRequest;
import me.didia.monlift.requests.CreateLiftRequest;

/**
 * @author didia
 *
 */
public class LiftFactory {
	

	public static Integer createLift(CreateLiftRequest createRequest) throws DuplicateValueException{
		return null;
	}
	
	public static Lift getLiftById(Integer id)
	{
		return null;
	}
	
	public static ArrayList<Lift> getLiftsByIds(ArrayList<Integer> ids)
	{
		return null;
	}
	
	public static ArrayList<Lift> getLiftsByUser(Integer id)
	{
		return null;
	}
	
	public static ArrayList<Lift> getLiftsByUsers(ArrayList<Integer> ids)
	{
		return null;
	}
	
	public static Car createCar(CreateCarRequest request)
	{
		return null;
	}
	
	public static Key<Car> saveCar(Car car){
		return null;
	}
	
}
