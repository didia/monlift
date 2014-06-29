package test.didia.monlift.service;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

/**
 * Testing of the rest api.
 * THE SERVER NEEDS TO BE RUNNING FOR THESE TEST TO RUN
 * @author theotherside
 *
 */
public class OauthServiceTest {
	
	@Test
	public void oauthServiceLogin() {
		DataSent dataBeingSend = new DataSent();
		dataBeingSend.setEmail("jac.massa0908@gmail.com");
		dataBeingSend.setPassword("pass");
		
		expect().
			body("status", equalTo("not found")).
		given().
			contentType("application/json; charset=UTF-8").
			body(dataBeingSend).
		when().
			post("/api/oauth/login");
	}
}

class DataSent{
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
