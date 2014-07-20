/**
 * 
 */
package test.didia.monlift.factories;

import static org.junit.Assert.*;

import org.junit.Test;

import test.didia.monlift.AbstractTest;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.factories.LiftFactory;


/**
 * @author didia
 *
 */
public class LiftFactoryTest extends AbstractTest {
	
	LiftFactory liftFactory = LiftFactory.getInstance();
	
	@Test
	public void testCreateLift()
	{
		Integer id;
		try {
			id = liftFactory.createLift();
			if(id == null)
				fail("createLift returned a null value instead of the Lift id");
			Lift newLift = liftFactory.getLiftById(id);
			if(newLift == null)
				fail("Calling getLiftById with the id returned by createLift returned a null value");
		} catch (DuplicateValueException e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
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
