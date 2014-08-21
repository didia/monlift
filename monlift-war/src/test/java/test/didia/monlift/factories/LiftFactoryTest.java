/**
 * 
 */
package test.didia.monlift.factories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.DuplicateValueException;
import me.didia.monlift.factories.LiftFactory;
import me.didia.monlift.requests.CreateCarRequest;
import me.didia.monlift.requests.CreateLiftRequest;

import org.junit.Test;

import test.didia.monlift.AbstractTest;
import test.didia.monlift.MockFactory;


/**
 * @author didia
 *
 */
public class LiftFactoryTest extends AbstractTest {
	
	private Lift m_liftInstance;
	private Car m_carInstance;
	
	public Car getCar(){
		if(m_carInstance != null)
			return m_carInstance;
		CreateCarRequest request = MockFactory.getCreateCarRequest();
		User user = getUser();
		m_carInstance = LiftFactory.createCar(user,request);
		
		return m_carInstance;
		
	
	}
	public Lift getLift(){
		if (m_liftInstance != null){
			return m_liftInstance;
		}
		CreateLiftRequest request = MockFactory.getCreateLiftRequest();
		request.setCar(getCar());
		request.setDriver(getUser());
		try {
			m_liftInstance = LiftFactory.createLift(request);
		} catch (DuplicateValueException e) {
			e.printStackTrace();
		}
		
		return m_liftInstance;
	}
	@Test 
	public void testCreateCar(){
		CreateCarRequest testRequest = MockFactory.getCreateCarRequest();
		User user = getUser();
		Car car =  LiftFactory.createCar(user, testRequest);
		assertNotNull(car.getId());
		assertEquals(car.getName(), testRequest.getName());
		
	}
	
	@Test
	public void testCreateLift()
	{
		
		CreateLiftRequest testRequest = MockFactory.getCreateLiftRequest();
		User user = getUser();
		testRequest.setDriver(user);
		testRequest.setCar(getCar());
		
		assert user != null;
		assert testRequest != null;
		
		try {
			Lift lift = LiftFactory.createLift(testRequest);
			assertNotNull(lift.getId());
			assertEquals(lift.getFrom(), testRequest.getFrom());
			assertEquals(lift.getDriver(), user);
			assertEquals(lift.getAvailablePlace(), lift.getTotalPlace());
		} catch (DuplicateValueException e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testGetLiftById()
	{
		Lift lift = getLift();
		assert lift != null;
		Lift sameLift = LiftFactory.getLiftById(getUser(), lift.getId());
		assertEquals(lift.getFrom(), sameLift.getFrom());
		assertEquals(lift.getAvailablePlace(),sameLift.getAvailablePlace());
		assertEquals(lift.getTo(), sameLift.getTo());
		assertEquals(lift.getPrice(), sameLift.getPrice());
		assertEquals(lift.getTime(), sameLift.getTime());
		assertEquals(lift.getCar(), sameLift.getCar());
		assertEquals(lift.getDriver(), sameLift.getDriver());
		
	}
	
	
	@Test
	public void testGetLiftsByUser()
	{
		//test with one lift
		Lift lift = getLift();
		assert lift != null;
		List<Lift> lifts = LiftFactory.getLiftsByDriver(lift.getDriver());
		
		assertEquals(1, lifts.size());
		assertEquals(lifts.get(0), lift);
		
	}
	
	@Test
	public void testGetCarsByUser() {
		
		Car car = getCar();
		assert car != null;
		List<Car> cars = LiftFactory.getCarsByDriver(car.getOwner());
		assertEquals(1, cars.size());
		assertEquals(cars.get(0), car);
		
	}
	
	@Test
	public void testGetLiftsByQuery(){
		Lift lift = getLift();
		assert lift != null;
		List<Lift> lifts = LiftFactory.getLiftByQuery("Québec", "Montréal");
		assertNotNull(lifts);
		assertEquals(1,lifts.size());
	}
	
	
	
}
