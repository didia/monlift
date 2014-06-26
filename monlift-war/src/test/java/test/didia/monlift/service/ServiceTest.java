package test.didia.monlift.service;
import static org.junit.Assert.*;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.service.Service;

public class ServiceTest  extends AbstractTest{

	Service myService = new Service();
	/**
	 * test of firstnameValidator function
	 */
	

	@test
	
	public void testfirstnameValidator()
	{
		try{
			String fistname = "jo";
			assertTrue( myService.firstnameValidator(firstname));
		}catch (DuplicateValueException e) {
			
			fail(e.getMessage());
		}
	} 
	}
			
			

