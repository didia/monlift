package me.didia.monlift.securities;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.joda.time.DateTime;

import me.didia.monlift.entities.User;

public class AuthentificationManager {
	
	private static AuthentificationManager instance = null;
	private  static SecureRandom random = new SecureRandom();
	private AuthentificationManager(){};
	
	public AuthentificationManager getInstance()
	{
		if(instance == null)
		{
			instance = new AuthentificationManager();
		}
		return instance;
	}
	
	public static String nextSessionId(){
	    return new BigInteger(130, random).toString(32);
	}
	
	public UserToken create(User user, String subject)
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
	
	public void updateToken(UserToken userToken)
	{
		userToken.date_updated = new DateTime();
		ofy().save().entity(userToken);
	}
	
	public User getUserByPassword(String email, String password)
	{
		return new User();
	}
	public User getUserByToken(String subject, String token)
	{
		UserToken userToken = getUserToken(subject, token);
		updateToken(userToken);
		return userToken.user.get();
	}
	
	private UserToken getUserToken(String subject, String token)
	{
		return ofy().load().type(UserToken.class).filter("token", token).filter("subject",subject).first().now();
	}
	
}
