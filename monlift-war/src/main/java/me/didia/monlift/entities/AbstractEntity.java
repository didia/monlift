package me.didia.monlift.entities;

import java.lang.reflect.Field;

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
}
