package me.didia.monlift.managers;

import static com.googlecode.objectify.ObjectifyService.ofy;


import com.googlecode.objectify.Work;

import me.didia.monlift.helper.UniqueConstraint;

public class UniqueConstraintManager {
	private static UniqueConstraintManager instance = null;
	
	private UniqueConstraintManager(){}
	
	public static  UniqueConstraintManager getInstance(){
		if(instance == null)
			instance = new UniqueConstraintManager();
		return instance;
	}
	
	public boolean create(Object object, String fieldname, String value)
	{
		final String key = String.format("%s.%s:%s", object.getClass().toString(), fieldname, value);
		final UniqueConstraint newUniqueConstraint = new UniqueConstraint();
		newUniqueConstraint.setKey(key);
		return ofy().transact(new Work<Boolean>(){
			public Boolean run()
			{
				UniqueConstraint aConstraint = ofy().load().type(UniqueConstraint.class).id(key).now();
				if(aConstraint == null)
				{
					ofy().save().entity(newUniqueConstraint).now();
					return new Boolean(true);
				}
				return new Boolean(false);
			}
		}).booleanValue();
		
	}
}
