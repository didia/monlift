package me.didia.monlift.entities;

import javax.persistence.Entity;

@Entity
public class Driver extends User {
	public boolean driver = true;
}
