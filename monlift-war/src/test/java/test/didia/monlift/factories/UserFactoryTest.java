package test.didia.monlift.factories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import me.didia.monlift.entities.User;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.factories.UserFactory;

import org.junit.Test;

import test.didia.monlift.AbstractTest;

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
	User p;
	Long id;

	@Test
	public void testCreateUser(){
		try {
			id= UserFactory.createUser("Jake", "Massa", "jac.massa0908@gmail.com", "7838073831","12345678");
			p = UserFactory.getUser(id);
			assertEquals(p.getFirstname(),"Jake");
			assertEquals(p.getLastname(),"Massa");
			assertEquals(p.getEmail(),"jac.massa0908@gmail.com");
			assertEquals(p.getPhone(),"7838073831");
			assertFalse(p.isDriver());
		} catch (DuplicateValueException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
		
	}
	@Test
	public void testCreateUserDuplicate()
	{
		try{
			id= UserFactory.createUser("Jake", "Massa", "jac.massa0908@gmail.com", "7838073831","12345678");
		} catch (DuplicateValueException e) {
			fail(e.getMessage());
		}
		try{
			id= UserFactory.createUser("Jake", "Didia", "jac.massa0908@gmail.com", "7838073831","12345678");
			fail("Expected function createUser to throw DuplicateValueException");
		} catch(DuplicateValueException e){
			assertTrue(true);
		}
	}
	
	
	@Test
	public void testGetUser(){
		
		try {
			String firstname = "Jake";
			String lastname = "Massa";
			String email = "jac.massa0908@gmail.com";
			id = UserFactory.createUser("Jake", "Massa", "jac.massa0908@gmail.com", "7838073831","12345678");
			User user = UserFactory.getUser(id);
			assertNotNull(user);
			assertEquals(user.getFirstname(),firstname);
			assertEquals(user.getLastname(), lastname);
			assertEquals(user.getEmail(), email);
		} catch (DuplicateValueException e) {
			
			fail(e.getMessage());
		}
		
		
	}
	
	@Test
	public void testGetUserByEmail()
	{
		try {
			String firstname = "Jake";
			String lastname = "Massa";
			String email = "jac.massa0908@gmail.com";
			id = UserFactory.createUser(firstname, lastname, email, "7838073831","12345678");
			User user = UserFactory.getUserByEmail(email);
			assertNotNull(user);
			assertEquals(user.getFirstname(), firstname);
			assertEquals(user.getLastname(), lastname);
			assertEquals(user.getEmail(), email);
		} catch (DuplicateValueException e) {
	
			fail(e.getMessage());
		}
	}
	
}
