package me.didia.monlift.helper;

import static com.googlecode.objectify.ObjectifyService.ofy;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
public class UniqueConstraint {
	@Id private String key;
	public void setKey (String value)
	{
		this.key = value;
	}
	public String getKeyString()
	{
		return this.key;
	}
}
