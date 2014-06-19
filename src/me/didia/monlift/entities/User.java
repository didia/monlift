package me.didia.monlift.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.google.appengine.api.datastore.Key;
/**
 * User class
 * SuperClass to all typer of users in the program
 * Abstract to avoid being directly used
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type")
public abstract class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private boolean driver;
	
	public Key getId() {
		return id;
	}
	public void setId(Key id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isDriver() {
		return driver;
	}
	public void setDriver(boolean driver) {
		this.driver = driver;
	}
	
	
}
