package me.didia.monlift.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Passenger")
public class Passenger extends User{
	public boolean driver = false;
}
