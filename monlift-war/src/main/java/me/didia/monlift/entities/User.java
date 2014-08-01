package me.didia.monlift.entities;

import java.security.Principal;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
/**
 * UserResponse class
 * SuperClass to all typer of users in the program
 * Abstract to avoid being directly used
 */
@Entity
public class User extends AbstractEntity implements Principal {

	@Id private Long id;
	private String firstname;
	private String lastname;
	@Index private String email;
	private String phone;
	@Index private String username;
	private String password;
	@Index private boolean isDriver = false;
	
	public User(){
		
	}
	public Long getId() {
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
	public String getFullName(){
		return this.firstname + " " + this.lastname;
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
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		
		return this.password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	@Override
	public String getName() {

		return email;
	}
}
