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
	
	private static LiftFactory m_instance = null;
	private LiftFactory(){};
	
	public static LiftFactory getInstance(){
		if(m_instance == null)
			m_instance = new LiftFactory();
		return m_instance;
	}
	
	public Integer createLift(CreateLiftRequest createRequest) throws DuplicateValueException{
		return null;
	}
	
	public Lift getLiftById(Integer id)
	{
		return null;
	}
	
	public ArrayList<Lift> getLiftsByIds(ArrayList<Integer> ids)
	{
		return null;
	}
	
	public ArrayList<Lift> getLiftsByUser(Integer id)
	{
		return null;
	}
	
	public ArrayList<Lift> getLiftsByUsers(ArrayList<Integer> ids)
	{
		return null;
	}
	
	public Car createCar(CreateCarRequest request)
	{
		return null;
	}
	
	public Key<Car> saveCar(Car car){
		return null;
	}
	
}
