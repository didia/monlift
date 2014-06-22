package me.didia.monlift.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import me.didia.monlift.entities.User;

@Entity
@DiscriminatorValue("Passenger")
public class Passenger extends User{
	private boolean driver = false;
	
	public boolean isDriver()
	{
		return true;
	}
}