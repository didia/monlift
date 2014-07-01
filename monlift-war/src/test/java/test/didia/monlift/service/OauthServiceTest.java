package test.didia.monlift.service;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.CoreMatchers.notNullValue;
import me.didia.monlift.requests.RegisterRequest;
import me.didia.monlift.requests.LoginRequest;
import me.didia.monlift.requests.RegisterRequest;

import org.junit.Test;

/**
 * Testing of the rest api.
 * THE SERVER NEEDS TO BE RUNNING FOR THESE TEST TO RUN
 * @author theotherside
 *
 */
public class OauthServiceTest {
	
	@Test
	public void oauthServiceRegister() {	
		RegisterRequest registerData = new RegisterRequest();
		
		registerData.setFirstname("jérôm");
		registerData.setLastname("app");
		registerData.setEmail("test@monlift223.com");
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
	
	
	@Test
	public void oauthServiceLogin() {
		LoginRequest dataBeingSend = new LoginRequest();
		dataBeingSend.setEmail("test@monlift223.com");
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
