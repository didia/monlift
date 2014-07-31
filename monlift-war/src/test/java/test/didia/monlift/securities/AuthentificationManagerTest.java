package test.didia.monlift.securities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import me.didia.monlift.entities.User;
import me.didia.monlift.securities.AuthentificationErrorException;
import me.didia.monlift.securities.AuthentificationManager;
import me.didia.monlift.securities.Session;

import org.junit.Test;

import test.didia.monlift.AbstractTest;
import test.didia.monlift.MockFactory;

public class AuthentificationManagerTest extends AbstractTest {
		

	private Session m_session;
	
	public Session getSession(){
		if(m_session != null)
			return m_session;
		
		try {
			m_session = AuthentificationManager.createSession(getUser().getEmail(), MockFactory.MOCK_USER_PASSWORD);
		} catch (AuthentificationErrorException e) {
			e.printStackTrace();
		}
		
		return m_session;
		
		
	}
	@Test
	public void testCreateSession()
	{
		User user = getUser();
		assert user!= null;
		
		//create with valid password
		try {
			Session session = AuthentificationManager.createSession(user.getEmail(), MockFactory.MOCK_USER_PASSWORD);
			assertEquals(session.getUser().getEmail(), user.getEmail());
			assertEquals(session.getUser().getId(), user.getId());
			
		} catch (AuthentificationErrorException e) {
			
			fail("The creation of session with valid email and password should not raise an exception\n"
					+ "Error Message: " + e.getMessage());
		}
		
		//create with invalid password
		try {
			AuthentificationManager.createSession(user.getEmail(), "badpassword");
			fail("The creation of session with invalid password should raise an exception");
			
			
		} catch (AuthentificationErrorException e) {
			assertTrue(true);
			
		}
		
		//create with invalid email
		try {
			AuthentificationManager.createSession("test2@monlift.ca", MockFactory.MOCK_USER_PASSWORD);
			fail("The creation of session with invalid email should raise an exception");
			
			
		} catch (AuthentificationErrorException e) {
			assertTrue(true);
			
		}
		
	}
	
	
	public void testGetSession()
	{

		try {
			Session session = getSession();
			Session sameSession = AuthentificationManager.getSession(session.getToken());
			assertEquals(session.getUser().getEmail(), sameSession.getUser().getEmail());
			assertEquals(session.getUser().getId(), sameSession.getUser().getId());
			
		} catch (AuthentificationErrorException e) {
			
			fail("The retrieval of a session with a valid token should not fail");
		}
		
	}
	
	@Test
	public void testGetSessionInvalidToken()
	{
		try {
			String token = getSession().getToken();
			AuthentificationManager.getSession(token + "abc");
			fail("The retrieval of a session with an invalid token should always fail");
			
			
		} catch (AuthentificationErrorException e) {
			assertTrue(true);
			
		}
	}
	
	@Test
	public void testDeleteSession()
	{
		Session session = getSession();
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
