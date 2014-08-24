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
		
		while(getUserToken(token) != null) {
			token = nextSessionId();
		}
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
		UserToken userToken = getUserToken(token);
		
		if (userToken == null || !userToken.subject.equals(subject))
		{
			throw new AuthentificationErrorException("The authentification token is not recognized");
		}
		
		
		
		User user =  userToken.user.get();
		if (user == null)
		{
			throw new AuthentificationErrorException("This user account has either been suspended or deleted");
		}
		
		updateToken(userToken);
		
		return user;
	}
	
	private static UserToken getUserToken(String token)
	{
		
		return ofy().load().type(UserToken.class).id(token).now();
	}
	
	public static Session createSession(String p_email, String p_password) throws AuthentificationErrorException
	{
		User user = getUserByPassword(p_email, p_password);
		return createSessionForUser(user);
	}
	
	public static Session createSession(User p_user) {
		return createSessionForUser(p_user);
	}
	
	private static Session createSessionForUser(User p_user) {
		UserToken userToken = createUserToken(p_user, UserToken.AUTHENTIFICATION);
		Session newSession = new Session(p_user, userToken.token);
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
		UserToken userToken = getUserToken(token);
		if(userToken.subject.equals(UserToken.AUTHENTIFICATION)) {
			deleteToken(userToken);
		}
		
	}
	
	public static void deleteToken(UserToken p_token) {
		ofy().delete().entity(p_token).now();
	}
 }
