package test.didia.monlift.managers;

import static org.junit.Assert.*;
import me.didia.monlift.entities.User;
import me.didia.monlift.factories.UserFactory;
import me.didia.monlift.managers.UserManager;

import org.junit.Test;

import test.didia.monlift.AbstractTest;

public class UserManagerTest extends AbstractTest {

	/**
	 * Test of the Create passenger function
	 */
	UserManager userManager = UserManager.getInstance();
	User p;
	Long id;
	@Test
	public void testPromoteToDriver(){
		String username = "jakeIbee";
		id= userManager.createUser("Jake", "Massa", "jac.massa0908@gmail.com", "7838073831");
		userManager.promoteToDriver(id, username);
		p = userManager.getUser(id);
		assertEquals(p.getUsername(), username);
		assertTrue(p.isDriver());
		
		
	}

}
