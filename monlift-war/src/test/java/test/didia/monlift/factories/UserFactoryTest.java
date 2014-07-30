package test.didia.monlift.factories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import me.didia.monlift.entities.User;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.factories.UserFactory;
import me.didia.monlift.requests.RegisterRequest;

import org.junit.Before;
import org.junit.Test;

import test.didia.monlift.AbstractTest;
import test.didia.monlift.MockFactory;

/**
 * Test for the UserFactory class
 * THESE TEST USES LOCAL MEMORY TO SIMULATE DATASTORE WORKING
 * YOU DON'T NEED THE SERVER RUNNING
 *
 */
public class UserFactoryTest extends AbstractTest {
		
	/**
	 * Test of the Create passenger function
	 */
	

	@Test
	public void testCreateUser(){
		// Testing normal procedure
		RegisterRequest request = MockFactory.getRegisterUserRequest();
		try {
			
			User user = UserFactory.createUser(request);
			assertNotNull(user.getId());
			assertEquals(user.getFirstname(),request.getFirstname());
			assertEquals(user.getLastname(),request.getLastname());
			assertEquals(user.getEmail(), request.getEmail());
			assertEquals(user.getPhone(), request.getPhone());
			assertFalse(user.isDriver());
		} catch (DuplicateValueException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
		//Testing in case duplicate: Should throw DuplicateValueException
		
		try{
			 UserFactory.createUser(request);
			fail("Expected function createUser to throw DuplicateValueException");
		} catch(DuplicateValueException e){
			assertTrue(true);
		}
		
	}
		
	@Test
	public void testGetUser(){
		User aUser = getUser();
		User sameUser = UserFactory.getUser(aUser.getId());
		assertNotNull(sameUser);
		assertEquals(aUser.getEmail(), sameUser.getEmail()); //is enough already
		assertEquals(aUser.getFirstname(), sameUser.getFirstname());
		assertEquals(aUser.getLastname(), sameUser.getLastname());
	}
	
	@Test
	public void testGetUserByEmail()
	{
		User aUser = getUser();
		User sameUser = UserFactory.getUserByEmail(aUser.getEmail());
		assertNotNull(sameUser);
		assertEquals(aUser.getId(), sameUser.getId()); // is enough already
		assertEquals(aUser.getPhone(), sameUser.getPhone());
		assertEquals(aUser.getPassword(), sameUser.getPassword());
		
	}
	
}
