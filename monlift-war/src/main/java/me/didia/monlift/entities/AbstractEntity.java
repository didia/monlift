package me.didia.monlift.entities;

import java.lang.reflect.Field;

import com.googlecode.objectify.Key;

/**
 * @author didia
 *
 */
public abstract class AbstractEntity {
	abstract Long getId();
	
	public boolean equals(AbstractEntity other){
		return getId().equals(other.getId());
	}
	
	public Object getField(String name) {
		
		try {
			Field thefield = this.getClass().getDeclaredField(name);
			thefield.setAccessible(true);
			return thefield.getType().cast(thefield.get(this));
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			return null;
		}
	}
	
	public void setField(String name, Object value) {
		try {
			Field thefield = this.getClass().getDeclaredField(name);
			thefield.setAccessible(true);
			thefield.set(this, value);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
		
		}
		
	}
	
	public Key<AbstractEntity> getKey(){
		return Key.create(this.getClass(), getId());
	}
}
