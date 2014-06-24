package me.didia.monlift.securities;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.joda.time.DateTime;

import me.didia.monlift.entities.User;
import me.didia.monlift.managers.UserManager;

public class AuthentificationManager {
	
	private static AuthentificationManager instance = null;
	private static SecureRandom random = new SecureRandom();
	private static UserManager userManager = UserManager.getInstance();
	private static final int HASH_STRENGTH = 16;
	private AuthentificationManager(){};
	
	public AuthentificationManager getInstance()
	{
		if(instance == null)
		{
			instance = new AuthentificationManager();
		}
		return instance;
	}
	
	private static String nextSessionId(){
	    return new BigInteger(130, random).toString(32);
	}
	
	public static String generateHashedPassword(String password)
	{
		
		return BCrypt.hashpw(password, BCrypt.gensalt(HASH_STRENGTH));
	}
	
	private static Boolean checkPassword(String password, String generatedPassword)
	{
		return BCrypt.checkpw(password, generatedPassword);
	}
	
	private UserToken createUserToken(User user, String subject)
	{
		UserToken userToken = new UserToken();
		String token = nextSessionId();
		String key = String.format("%s.%s.%s", user.getId().toString(), subject, token);
		userToken.key = key;
		userToken.token = token;
		userToken.subject = subject;
		userToken.date_created = new DateTime();
		userToken.date_updated = userToken.date_created;
		ofy().save().entity(userToken).now();
		
		return userToken;
	}
	
	
	private void updateToken(UserToken userToken)
	{
		userToken.date_updated = new DateTime();
		ofy().save().entity(userToken);
	}
	
	private User getUserByPassword(String email, String password)
	{
		User user = userManager.getUserByEmail(email);
		if (checkPassword(password, user.getPassword()))
		{
			return user;
		}
		
		return null;
	}
	private User getUserByToken(String subject, String token)
	{
		UserToken userToken = getUserToken(subject, token);
		updateToken(userToken);
		return userToken.user.get();
	}
	
	private UserToken getUserToken(String token, String subject)
	{
		return ofy().load().type(UserToken.class).filter("token", token).filter("subject",subject).first().now();
	}
	
	public Session createSession(String email, String password)
	{
		User user = getUserByPassword(email, password);
		UserToken userToken = createUserToken(user, UserToken.AUTHENTIFICATION);
		Session newSession = new Session(user, userToken.token);
		return newSession;
	}
	
	public Session getSession(String token)
	{
		User user = getUserByToken(token,UserToken.AUTHENTIFICATION);
		Session newSession = new Session(user, token);
		return newSession;
	}
}
