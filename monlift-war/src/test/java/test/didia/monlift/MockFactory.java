/**
 * 
 */
package test.didia.monlift;

import java.util.ArrayList;

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
	public static ArrayList<User> getMultipleUser(int number)
	{
		ArrayList<User> users = new ArrayList<User>(number);
		
		ArrayList<RegisterRequest> requests = getMultipleRegisterRequest(number);
		for(RegisterRequest request : requests)
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
		return getRegisterRequest(MOCK_USER_FIRSTNAME, MOCK_USER_LASTNAME, 
				                  MOCK_USER_PASSWORD, MOCK_USER_NUMBER);
		
	}
	
	public static ArrayList<RegisterRequest> getMultipleRegisterRequest(int number){
		
		ArrayList<RegisterRequest> requests = new ArrayList<RegisterRequest>(number);
		
		RegisterRequest request = getRegisterUserRequest();
		requests.add(request);
		for(int i=0; i<number; i++)
		{
			String firstname = request.getFirstname() + "-"+ i;
			String lastname = request.getLastname() + "-" + i;
			String password = request.getPassword() + "-" + i;
			String phone = request.getPhone() + "-" + i;
			RegisterRequest aRequest = getRegisterRequest(firstname, lastname,
														  password, phone);
			requests.add(aRequest);
			
		}
		
		return requests;
	}
	
	private static RegisterRequest getRegisterRequest(String p_firstname, String p_lastname, String p_password, String p_phone)
	{
		RegisterRequest request = new RegisterRequest();
		request.setFirstname(p_firstname);
		request.setLastname(p_lastname);
		request.setPassword(p_password);
		request.setPhone(p_phone);
		String email = request.getFirstname() + "." + request.getLastname() + "@example.com";
		request.setEmail(email);
		
		return request;
	}
}
