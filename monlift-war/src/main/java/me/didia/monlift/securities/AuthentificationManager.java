package me.didia.monlift.securities;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.joda.time.DateTime;

import com.googlecode.objectify.Ref;

import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.AuthentificationErrorException;
import me.didia.monlift.managers.UserManager;

public class AuthentificationManager {
	

	private static SecureRandom random = new SecureRandom();

	private static final int HASH_STRENGTH = 16;
	

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
	
	private static UserToken createUserToken(User user, String subject)
	{
		UserToken userToken = new UserToken();
		String token = nextSessionId();
		String key = String.format("%s.%s.%s", user.getId().toString(), subject, token);
		userToken.key = key;
		userToken.token = token;
		userToken.subject = subject;
		userToken.date_created = new DateTime();
		userToken.date_updated = userToken.date_created;
		userToken.user = Ref.create(user);
		ofy().save().entity(userToken).now();
		
		return userToken;
	}
	
	
	private static void updateToken(UserToken userToken)
	{
		userToken.date_updated = new DateTime();
		ofy().save().entity(userToken);
	}
	
	private static User getUserByPassword(String email, String password) throws AuthentificationErrorException
	{
		User user = UserManager.getUserByEmail(email);

		if (user != null && checkPassword(password, user.getPassword()))
		{
			return user;
		}
		else
		{
			throw new AuthentificationErrorException("The email/password combination cannot be found");
		}
	}
	private static User getUserByToken(String token,String subject) throws AuthentificationErrorException
	{
		UserToken userToken = getUserToken(token, subject);
		if (userToken == null)
		{
			throw new AuthentificationErrorException("The authentification token is not recognized");
		}
		updateToken(userToken);
		User user =  userToken.user.get();
		if (user == null)
		{
			throw new AuthentificationErrorException("This user account has either been suspended or deleted");
		}
		return user;
	}
	
	private static UserToken getUserToken(String token, String subject)
	{
		
		return ofy().load().type(UserToken.class).filter("token", token).filter("subject",subject).first().now();
	}
	
	public static Session createSession(String email, String password) throws AuthentificationErrorException
	{
		User user = getUserByPassword(email, password);
		UserToken userToken = createUserToken(user, UserToken.AUTHENTIFICATION);
		Session newSession = new Session(user, userToken.token);
		return newSession;
	}
	
	public static Session getSession(String token) throws AuthentificationErrorException
	{
		User user = getUserByToken(token,UserToken.AUTHENTIFICATION);
		Session newSession = new Session(user, token);
		return newSession;
	}
	
	public static void deleteSession(String token)
	{
		UserToken userToken = getUserToken(token, UserToken.AUTHENTIFICATION);
		ofy().delete().entity(userToken).now();
	}
 }
