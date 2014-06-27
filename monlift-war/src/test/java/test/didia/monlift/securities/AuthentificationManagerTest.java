package test.didia.monlift.securities;

import org.junit.Test;

import me.didia.monlift.entities.User;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.securities.AuthentificationErrorException;
import me.didia.monlift.securities.AuthentificationManager;
import me.didia.monlift.securities.Session;
import test.didia.monlift.AbstractTest;
import static org.junit.Assert.*;

public class AuthentificationManagerTest extends AbstractTest {
		
	private static AuthentificationManager authManager = AuthentificationManager.getInstance();
	private static UserManager userManager = UserManager.getInstance();
	private static String EMAIL = "test@monlift.ca";
	private static String PASSWORD = "1234monlift";
	
	private static User getUser()
	{
		try {
			return userManager.getUser(userManager.createUser("John", "Doe", EMAIL, "15819999", PASSWORD));
		} catch (DuplicateValueException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	@Test
	public void testCreateSession()
	{
		User user = getUser();
		assert user!= null;
		try {
			Session session = authManager.createSession(EMAIL, PASSWORD);
			assertEquals(session.getUser().getEmail(), user.getEmail());
			assertEquals(session.getUser().getId(), user.getId());
			
		} catch (AuthentificationErrorException e) {
			
			fail("The creation of session with valid email and password should not raise an exception\n"
					+ "Error Message: " + e.getMessage());
		}		
	}
	
	@Test
	public void testCreateSessionInvalidPassword()
	{
		User user = getUser();
		assert user!= null;
		try {
			authManager.createSession(EMAIL, "badpassword");
			fail("The creation of session with invalid password should raise an exception");
			
			
		} catch (AuthentificationErrorException e) {
			assertTrue(true);
			
		}
	}
	
	@Test
	public void testCreateSessionInvalidEmail()
	{
		User user = getUser();
		assert user!= null;
		try {
			authManager.createSession("test2@monlift.ca", PASSWORD);
			fail("The creation of session with invalid email should raise an exception");
			
			
		} catch (AuthentificationErrorException e) {
			assertTrue(true);
			
		}
	}
	
	public void testGetSession()
	{
		User user = getUser();
		assert user!= null;
		try {
			Session session = authManager.createSession(EMAIL, PASSWORD);
			Session session2 = authManager.getSession(session.getToken());
			assertEquals(session2.getUser().getEmail(), user.getEmail());
			assertEquals(session2.getUser().getId(), user.getId());
			
		} catch (AuthentificationErrorException e) {
			
			fail("The retrieval of a session with a valid token should not fail");
		}
		
	}
	
	@Test
	public void testGetSessionInvalidToken()
	{
		User user = getUser();
		assert user!= null;
		try {
			String token = authManager.createSession(EMAIL, PASSWORD).getToken();
			authManager.getSession(token + "abc");
			fail("The retrieval of a session with an invalid token should always fail");
			
			
		} catch (AuthentificationErrorException e) {
			assertTrue(true);
			
		}
	}
	
}
