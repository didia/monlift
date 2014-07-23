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
		
	private static String EMAIL = "test@monlift.ca";
	private static String PASSWORD = "1234monlift";
	
	private static User getUser()
	{
		try {
			return UserManager.getUser(UserManager.createUser("John", "Doe", EMAIL, "15819999", PASSWORD));
		} catch (DuplicateValueException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	private static Session generateSession()
	{
		User user = getUser();
		assert user != null;
		try {
			return AuthentificationManager.createSession(EMAIL, PASSWORD);
		} catch (AuthentificationErrorException e){
			return null;
		}
		
	}
	
	@Test
	public void testCreateSession()
	{
		User user = getUser();
		assert user!= null;
		try {
			Session session = AuthentificationManager.createSession(EMAIL, PASSWORD);
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
			AuthentificationManager.createSession(EMAIL, "badpassword");
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
			AuthentificationManager.createSession("test2@monlift.ca", PASSWORD);
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
			Session session = AuthentificationManager.createSession(EMAIL, PASSWORD);
			Session session2 = AuthentificationManager.getSession(session.getToken());
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
			String token = AuthentificationManager.createSession(EMAIL, PASSWORD).getToken();
			AuthentificationManager.getSession(token + "abc");
			fail("The retrieval of a session with an invalid token should always fail");
			
			
		} catch (AuthentificationErrorException e) {
			assertTrue(true);
			
		}
	}
	
	@Test
	public void testDeleteSession()
	{
		Session session = generateSession();
		assert session != null;
		AuthentificationManager.deleteSession(session.getToken());
		try {
			session = AuthentificationManager.getSession(session.getToken());
			fail("The getSession with deleted token should raise AuthentificationErrorException");
		} catch (AuthentificationErrorException e) {
			assertTrue(true);
		}
	}
	
}
