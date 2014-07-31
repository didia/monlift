/**
 * 
 */
package me.didia.monlift.entities;

import com.googlecode.objectify.annotation.Entity;

/**
 * @author didia
 *
 */
public abstract class AbstractEntity {
	abstract Long getId();
	
	public boolean equals(AbstractEntity other)
	{
		return getId().equals(other.getId());
	}
}
