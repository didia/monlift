package test.didia.monlift.managers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import me.didia.monlift.entities.User;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.managers.UserManager;

import org.junit.Test;

import test.didia.monlift.AbstractTest;

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

		try {
			id = UserManager.createUser("Jake", "Massa",
					"jac.massa0908@gmail.com", "7838073831", "12345678");
			UserManager.promoteToDriver(id, username);
			p = UserManager.getUser(id);
			assertEquals(p.getUsername(), username);
			assertTrue(p.isDriver());
		} catch (DuplicateValueException e) {

			fail(e.getMessage());
		}
	}

	@Test
	public void testPromoteDriverDuplicate() {
		String username = "TheBlaze";
		try {
			id = UserManager.createUser("Jake", "Massa",
					"jac.massa0908@gmail.com", "7838073831", "12345678");
			second_id = UserManager.createUser("Jake", "Massa",
					"jac.massa0904@gmail.com", "7838073831", "12345678");
			UserManager.promoteToDriver(id, username);
			try {
				UserManager.promoteToDriver(second_id, username);
				fail("Exception DuplicateValueException should be thrown as user is promoted with an existing username");
			} catch (DuplicateValueException e) {
				assertTrue(true);
			}
		} catch (DuplicateValueException e) {

			fail(e.getMessage());
		}

	}

}
