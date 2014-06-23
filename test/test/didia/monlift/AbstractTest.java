package test.didia.monlift;

import me.didia.monlift.entities.User;
import me.didia.monlift.helper.UniqueConstraint;

import org.junit.After;
import org.junit.Before;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;

public class AbstractTest {
	/**
	 * Implementation of the local service
	 */
	private final LocalServiceTestHelper helper =
	        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	
	
	/**
	 * keeps all the local data in memory
	 */
	@Before
    public void setUp() {
		ObjectifyService.register(User.class);
		ObjectifyService.register(UniqueConstraint.class);
        helper.setUp();
    }

	/**
	 * Wipes out all the local data after the test
	 */
    @After
    public void tearDown() {
        helper.tearDown();
    }
}
