package me.didia.monlift.managers;

import me.didia.monlift.entities.Car;
import me.didia.monlift.factories.LiftFactory;
import me.didia.monlift.requests.CreateCarRequest;

/**
 * @author didia
 *
 */
public class LiftManager {
	
	public static Car createCar(CreateCarRequest request)
	{
		return LiftFactory.createCar(request);
	}
	
	
}
