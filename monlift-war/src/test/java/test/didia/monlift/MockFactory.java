/**
 * 
 */
package test.didia.monlift;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.entities.User;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.managers.LiftManager;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.requests.CreateCarRequest;
import me.didia.monlift.requests.CreateLiftRequest;
import me.didia.monlift.requests.RegisterRequest;
import me.didia.monlift.securities.AuthentificationErrorException;
import me.didia.monlift.securities.AuthentificationManager;
import me.didia.monlift.securities.Session;

/**
 * @author didia
 * 
 * This class is a test helper which provides Mock object obtained from the datastore
 */
public class MockFactory {
	public static final String MOCK_CAR_NAME = "Volvo new model";
	public static final String MOCK_CAR_DESCRIPTION = "5 seat, imatriculation 483 CKR, Blue";
	
	public static final String MOCK_USER_FIRSTNAME = "John";
	public static final String MOCK_USER_LASTNAME = "Doe";
	public static final String MOCK_USER_NUMBER = "15819999999";
	public static final String MOCK_USER_PASSWORD = "xyz123kgh";
	
	public static final String MOCK_LIFT_FROM = "Québec";
	public static final String MOCK_LIFT_TO = "Montréal";
	public static final double MOCK_LIFT_PRICE = 15.0;
	public static final String MOCK_LIFT_MEETING_PLACE = "Pavillon DesjarDins, Université Laval";
	public static final int MOCK_LIFT_TOTAL_PLACE = 4;
	
	private static User m_userInstance;
	
	private static Lift m_lift;
	
	public static User getUser() {
		if(m_userInstance != null)
		{
			return m_userInstance;
		}
		try {
			RegisterRequest request = getRegisterUserRequest();
			m_userInstance = UserManager.createUser(request);
			return m_userInstance;
		} catch (DuplicateValueException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	public static ArrayList<User> getMultipleUser(int number) {
		ArrayList<User> users = new ArrayList<User>(number);
		
		List<RegisterRequest> requests = getMultipleRegisterRequest(number);
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
	public static Car getCar() {
		User user = getUser();
		CreateCarRequest request = getCreateCarRequest();
		if(user == null || request == null)
		{
			return null;
		}
		  
		return LiftManager.createCar(user, request);
	}
	
	public static CreateCarRequest getCreateCarRequest() {
		CreateCarRequest request = new CreateCarRequest();
		request.setName(MOCK_CAR_NAME);
		request.setDescription(MOCK_CAR_DESCRIPTION);
		
		return request;
	}
	
	public static RegisterRequest getRegisterUserRequest() {
		return getRegisterRequest(MOCK_USER_FIRSTNAME, MOCK_USER_LASTNAME, 
				                  MOCK_USER_PASSWORD, MOCK_USER_NUMBER);
		
	}
	
	public static List<RegisterRequest> getMultipleRegisterRequest(int number) {
		
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
	
	private static RegisterRequest getRegisterRequest(String p_firstname, 
													  String p_lastname, 
													  String p_password, 
													  String p_phone) {
		RegisterRequest request = new RegisterRequest();
		request.setFirstname(p_firstname);
		request.setLastname(p_lastname);
		request.setPassword(p_password);
		request.setPhone(p_phone);
		String email = request.getFirstname() + "." + request.getLastname() + "@example.com";
		request.setEmail(email);
		
		return request;
	}
	
	public static Session getSession() {
		User user = getUser();
		if(user == null)
		{
			return null;
		}
		try {
			return AuthentificationManager.createSession(user.getEmail(), MOCK_USER_PASSWORD);
		} catch (AuthentificationErrorException e){
			return null;
		}
	}
	
	public static CreateLiftRequest getCreateLiftRequest() {
		Car car = getCar();
		if(car == null)
			return null;
		Calendar.getInstance().add(Calendar.DAY_OF_MONTH, 1);
		return getCreateLiftRequest(car.getId(), MOCK_LIFT_FROM, MOCK_LIFT_TO, 
								  MOCK_LIFT_MEETING_PLACE, MOCK_LIFT_PRICE,
								  MOCK_LIFT_TOTAL_PLACE, Calendar.getInstance().getTime());

	}
	
	public static List<CreateLiftRequest> getMultipleCreateLiftRequest(int number) {

		ArrayList<CreateLiftRequest> requests = new ArrayList<CreateLiftRequest>(number);
		
		CreateLiftRequest request = getCreateLiftRequest();
		
		requests.add(request);
		
		for(int i=0; i<number; i++)
		{
			request = getCreateLiftRequest();
			Calendar.getInstance().add(Calendar.DAY_OF_MONTH, 1*i);
			request.setTime(Calendar.getInstance().getTime());
			
			requests.add(request);
			
		}
		
		
		return requests;
	}
	
	private static CreateLiftRequest getCreateLiftRequest(long p_carId,
														  String p_from,
														  String p_to,
														  String p_meetingPlace,
														  double p_price,
														  int p_totalPlace,
														  Date p_date ) {
		
		CreateLiftRequest request = new CreateLiftRequest();
		request.setCarId(p_carId);
		request.setFrom(p_from);
		request.setTo(p_to);
		request.setMeetingPlace(p_meetingPlace);
		request.setPrice(p_price);
		request.setTotalPlace(p_totalPlace);
		request.setTime(p_date);
		
		return request;
	}
	
	public static Lift getLift() {
		if(m_lift != null){
			return m_lift;
		}
		CreateLiftRequest request = getCreateLiftRequest();
		User user = getUser();
		if(request == null || user == null)
		{
			return null;
		}
		
		try {
			Lift lift = LiftManager.createLift(user, request);
			m_lift = lift;
			return m_lift;
		} catch (DuplicateValueException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static ArrayList<Lift> getMultipleLifts() {
		
		return null;
	}
}
