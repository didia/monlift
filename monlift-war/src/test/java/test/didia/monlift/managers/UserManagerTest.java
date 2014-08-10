package test.didia.monlift.managers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.DuplicateValueException;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.requests.PromoteUserRequest;

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
		User user = getUser();
		try {
			PromoteUserRequest request = MockFactory.getPromoteUserRequest();
			UserManager.promoteToDriver(user, request);
			User sameUser = UserManager.getUser(user.getId());
			assertEquals(sameUser.getUsername(), request.getUsername());
			assertTrue(sameUser.isDriver());
		} catch (DuplicateValueException e) {

			fail(e.getMessage());
		}
	}

	@Test
	public void testPromoteDriverDuplicate() {
		PromoteUserRequest request = MockFactory.getPromoteUserRequest();
		ArrayList<User> users = getMultipleUser(2);
		for (User user: users)
		{
			assertNotNull(user);
		}
		try {
			
			UserManager.promoteToDriver(users.get(0), request);
			try {
				UserManager.promoteToDriver(users.get(1), request);
				fail("Exception DuplicateValueException should be thrown as user is promoted with an existing username");
			} catch (DuplicateValueException e) {
				assertTrue(true);
			}
		} catch (DuplicateValueException e) {

			fail(e.getMessage());
		}

	}

}
