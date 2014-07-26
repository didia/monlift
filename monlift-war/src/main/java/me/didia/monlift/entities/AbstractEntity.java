/**
 * 
 */
package me.didia.monlift.entities;

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
