package test.didia.monlift.managers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import me.didia.monlift.entities.User;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.managers.UserManager;

import org.junit.Test;

import test.didia.monlift.AbstractTest;
import test.didia.monlift.MockFactory;

public class UserManagerTest extends AbstractTest {

	/**
	 * Test of the Create passenger function
	 */
	User p;
	Long id;
	Long second_id;

	@Test
	public void testPromoteToDriver() {
		String username = "jakeIbee";
		User user = MockFactory.getUser();
		try {

			UserManager.promoteToDriver(user.getId(), username);
			User sameUser = UserManager.getUser(user.getId());
			assertEquals(sameUser.getUsername(), username);
			assertTrue(sameUser.isDriver());
		} catch (DuplicateValueException e) {

			fail(e.getMessage());
		}
	}

	@Test
	public void testPromoteDriverDuplicate() {
		String username = "TheBlaze";
		ArrayList<User> users = MockFactory.getMultipleUser(2);
		for (User user: users)
		{
			assertNotNull(user);
		}
		try {
			
			UserManager.promoteToDriver(users.get(0).getId(), username);
			try {
				UserManager.promoteToDriver(users.get(1).getId(), username);
				fail("Exception DuplicateValueException should be thrown as user is promoted with an existing username");
			} catch (DuplicateValueException e) {
				assertTrue(true);
			}
		} catch (DuplicateValueException e) {

			fail(e.getMessage());
		}

	}

}
