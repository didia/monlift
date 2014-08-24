package test.didia.monlift;

import java.util.ArrayList;
import java.util.List;

import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.DuplicateValueException;
import me.didia.monlift.helper.UniqueConstraint;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.requests.CreateUserRequest;
import me.didia.monlift.securities.UserToken;

import org.junit.After;
import org.junit.Before;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.impl.translate.opt.joda.JodaTimeTranslators;

public class AbstractTest {
	/**
	 * Implementation of the local service
	 */
	private final LocalServiceTestHelper helper =
	        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	public User m_userInstance;
	
	
	public User getUser() {
		if(m_userInstance != null)
		{
			return m_userInstance;
		}
		
		try {
			CreateUserRequest request = MockFactory.getRegisterUserRequest();
			m_userInstance = UserManager.createUser(request);
			return m_userInstance;
		} catch (DuplicateValueException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<User> getMultipleUser(int number) {
		ArrayList<User> users = new ArrayList<User>(number);
		
		List<CreateUserRequest> requests = MockFactory.getMultipleRegisterRequest(number);
		for(CreateUserRequest request : requests)
		{
			try{
				users.add(UserManager.createUser(request));
			}catch(DuplicateValueException e){
				e.printStackTrace();
				users.add(null);
			}
			
		}
		
		return users;
	}

	/**
	 * keeps all the local data in memory
	 */
	@Before
    public void setUp() {
		JodaTimeTranslators.add(ObjectifyService.factory());
		ObjectifyService.register(User.class);
		ObjectifyService.register(UniqueConstraint.class);
		ObjectifyService.register(UserToken.class);
		ObjectifyService.register(Car.class);
		ObjectifyService.register(Lift.class);
		
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
