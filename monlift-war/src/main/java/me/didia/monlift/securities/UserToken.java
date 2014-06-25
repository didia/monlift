package me.didia.monlift.securities;

import me.didia.monlift.entities.User;

import org.joda.time.DateTime;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

@Entity
public class UserToken {
	@Ignore public static final String AUTHENTIFICATION = "auth";
	@Ignore public static final String SIGNUP = "signup";
	@Ignore public static final String RESET_PASSWORD = "reset_password";
	@Id public String key;
	public DateTime date_created;
	public DateTime date_updated;
	@Load public Ref<User> user;
	@Index public String subject;
	@Index public String token;
	
}
