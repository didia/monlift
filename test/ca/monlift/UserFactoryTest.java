package ca.monlift;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import me.didia.monlift.entities.Passenger;
import me.didia.monlift.entities.UserFactory;

/**
 * Test for the UserFactory class
 * THESE TEST USES LOCAL MEMORY TO SIMULATE DATASTORE WORKING
 * YOU DON'T NEED THE SERVER RUNNING
 *
 */
public class UserFactoryTest {
	
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
        helper.setUp();
    }

	/**
	 * Wipes out all the local data after the test
	 */
    @After
    public void tearDown() {
        helper.tearDown();
    }
	
	/**
	 * Test of the Create passenger function
	 */
	Passenger p;
	static Key k;
	UserFactory uf = UserFactory.getInstance();
	@Test
	public void testCreatePassenger(){
		p = uf.createPassenger("Jake", "Massa", "jac.massa0908@gmail.com", "7838073831");
		assertEquals(p.getFirstname(),"Jake");
		assertEquals(p.getLastname(),"Massa");
		assertEquals(p.getEmail(),"jac.massa0908@gmail.com");
		assertEquals(p.getPhone(),"7838073831");
	}
	
	
	/**
	 * Test of the save function 
	 */
	@Test
	public void testSaveUser(){
		p = uf.createPassenger("Jake", "Massa", "jac.massa0908@gmail.com", "7838073831");
		k = uf.save(p);
		assertNotNull(k);
	}
	
	@Test
	public void testGetUser(){
		p = uf.createPassenger("Jake", "Massa", "jac.massa0908@gmail.com", "7838073831");
		k = uf.save(p);
		Passenger otherPassenger = (Passenger) uf.getUser(k);
		assertEquals(p.getFirstname(),otherPassenger.getFirstname());
		
	}
	
	
}
