package test.didia.monlift.services;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.HashMap;
import java.util.Map;

import me.didia.monlift.requests.BaseRequest;
import me.didia.monlift.requests.LoginRequest;
import me.didia.monlift.requests.CreateUserRequest;
import test.didia.monlift.AbstractTest;

/**
 * Testing of the rest api.
 * THE SERVER NEEDS TO BE RUNNING FOR THESE TEST TO RUN
 * @author theotherside
 *
 */
public class OauthServiceTest extends AbstractTest {
	
	//@Test
	public void oauthServiceRegister() {	
		CreateUserRequest registerData = new CreateUserRequest();
		
		registerData.setFirstname("monlift");
		registerData.setLastname("app");
		registerData.setEmail("test@monlift.com");
		registerData.setPhone("7838073831");
		registerData.setPassword("monliftpass");
		
		expect().
			body("token", notNullValue()).
		given().
			contentType("application/json; charset=UTF-8").
			body(registerData).
		when().
			post("/api/oauth/register");
	}
	
	
	//@Test
	public void oauthServiceLogin() {
		LoginRequest dataBeingSend = new LoginRequest();
		dataBeingSend.setEmail("test@monlift.com");
		dataBeingSend.setPassword("monliftpass");
		
		expect().
			body("token", notNullValue()).
		given().
			contentType("application/json; charset=UTF-8").
			body(dataBeingSend).
		when().
			post("/api/oauth/login");
	}
	
	//@Test
	public void oauthServiceLoginIncorrect() {
		LoginRequest dataBeingSend = new LoginRequest();
		dataBeingSend.setEmail("test@monlift.com");
		dataBeingSend.setPassword("monlpass");
		
		expect().
			body("status", equalTo("Invalid credentials")).
		given().
			contentType("application/json; charset=UTF-8").
			body(dataBeingSend).
		when().
			post("/api/oauth/login");
	}
	
	//@Test
	public void oauthServiceLogout() {
		Map<String, String> request = new HashMap<String, String >();
		request.put("token", "hf184vbvk3gfnr66oct7vaq");
		expect().
			body("status", equalTo("logged_out")).
		given().
			contentType("application/json; charset=UTF-8").
			body(request).
		when().
			post("/api/oauth/logout");
	}
}
