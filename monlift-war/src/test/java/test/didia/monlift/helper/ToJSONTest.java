package test.didia.monlift.helper;

import me.didia.monlift.entities.User;
import me.didia.monlift.helper.ToJSON;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import static org.junit.Assert.*;


public class ToJSONTest {
	User user = new User();
	@Test
	public void testObjectToJSON(){
		String json="";
		user.setEmail("test@monlift.com");
		user.setFirstname("monlift");
		user.setDriver(false);
		user.setId(1234242);
		user.setLastname("monlift");
		user.setPassword("1233242");
		user.setPhone("32323232");
		user.setUsername("monlift");
		try {
			json =ToJSON.ObjectToJSON(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		String jsonformat="{\"id\":1234242,\"firstname\":\"monlift\",\"lastname\":\"monlift\",\"email\":\"test@monlift.com\",\"phone\":\"32323232\",\"username\":\"monlift\",\"password\":\"1233242\",\"driver\":false}";
		assertEquals(json.replaceAll("\\s",""),jsonformat);
	}
}
