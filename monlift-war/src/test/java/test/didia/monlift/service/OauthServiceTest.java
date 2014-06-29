package test.didia.monlift.service;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.CoreMatchers.notNullValue;
import me.didia.monlift.rest_entities.LoginDataReceived;
import me.didia.monlift.rest_entities.RegisterDataReceived;

import org.junit.Test;

/**
 * Testing of the rest api.
 * THE SERVER NEEDS TO BE RUNNING FOR THESE TEST TO RUN
 * @author theotherside
 *
 */
public class OauthServiceTest {
	
	//@Test
	public void oauthServiceRegister() {	
		RegisterDataReceived registerData = new RegisterDataReceived();
		
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
		LoginDataReceived dataBeingSend = new LoginDataReceived();
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
}
