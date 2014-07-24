/**
 * 
 */
package test.didia.monlift.factories;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import test.didia.monlift.AbstractTest;
import test.didia.monlift.MockFactory;
import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.factories.LiftFactory;
import me.didia.monlift.requests.CreateLiftRequest;


/**
 * @author didia
 *
 */
public class LiftFactoryTest extends AbstractTest {
	
	private final String from = "Québec";
	private final String to = "Montréal";
	private final Double price = 15.0;
	private final String meetingPlace = "Pavillon DesjarDins, Université Laval";
	private final int totalPlace = 20;
	
	private Car car_instance = MockFactory.getCar();
	

	
	
	public void testCreateLift()
	{
		
		CreateLiftRequest testRequest = new CreateLiftRequest();
		
		Integer id;
		try {
			id = LiftFactory.createLift(testRequest);
			if(id == null)
				fail("createLift returned a null value instead of the Lift id");
			Lift newLift = LiftFactory.getLiftById(id);
			if(newLift == null)
				fail("Calling getLiftById with the id returned by createLift returned a null value");
		} catch (DuplicateValueException e) {
			fail(e.getMessage());
		}
		
	}
	
	
	public void testGetLiftById()
	{
		
	}
	
	@Test
	public void testGetLiftsByIds()
	{
		
	}
	
	@Test
	public void testGetLiftsByUser()
	{
		
	}
	
	@Test
	public void testGetLiftsByUsers()
	{
		
	}
	
	
}
