/**
 * 
 */
package test.didia.monlift;

import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.User;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.managers.LiftManager;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.requests.CreateCarRequest;
import me.didia.monlift.requests.RegisterRequest;

/**
 * @author didia
 * 
 * This class is a test helper which provides Mock object obtained from the datastore
 */
public class MockFactory {
	public static final String MOCK_CAR_NAME = "Volvo new model";
	public static final String MOCK_CAR_DESCRIPTION = "5 seat, imatriculation 483 CKR, Blue";
	public static final String MOCK_USER_EMAIL = "johndoe@example.com";
	public static final String MOCK_USER_FIRSTNAME = "John";
	public static final String MOCK_USER_LASTNAME = "Doe";
	public static final String MOCK_USER_NUMBER = "15819999999";
	public static final String MOCK_USER_PASSWORD = "xyz123kgh";
	
	public static User getUser()
	{
		try {
			RegisterRequest request = getRegisterUserRequest();
			return UserManager.createUser(request);
		} catch (DuplicateValueException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public static Car getCar()
	{
		CreateCarRequest request = getCreateCarRequest();
		return LiftManager.createCar(request);
	}
	
	public static CreateCarRequest getCreateCarRequest(){
		CreateCarRequest request = new CreateCarRequest();
		request.setName(MOCK_CAR_NAME);
		request.setDescription(MOCK_CAR_DESCRIPTION);
		
		return request;
	}
	
	public static RegisterRequest getRegisterUserRequest(){
		RegisterRequest request = new RegisterRequest();
		request.setEmail(MOCK_USER_EMAIL);
		request.setFirstname(MOCK_USER_FIRSTNAME);
		request.setLastname(MOCK_USER_LASTNAME);
		request.setPassword(MOCK_USER_PASSWORD);
		request.setPhone(MOCK_USER_NUMBER);
		
		return request;
		
		
	}
	
}
