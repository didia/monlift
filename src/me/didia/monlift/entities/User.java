package me.didia.monlift.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
/**
 * User class
 * SuperClass to all typer of users in the program
 * Abstract to avoid being directly used
 */
@Entity
public abstract class User {

	@Id private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String username;
	private String password;
	private boolean isDriver;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
		return isDriver;
	}
	public void setDriver(boolean driver) {
		this.isDriver = driver;
	}
	
	
}
