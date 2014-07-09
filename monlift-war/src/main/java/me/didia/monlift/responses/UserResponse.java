package me.didia.monlift.responses;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import me.didia.monlift.BaseException;
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserResponse implements IResponse<me.didia.monlift.entities.User> {
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String username;
	private String fullname;
	private Boolean driver;
	public void build(me.didia.monlift.entities.User user) {
		id = user.getId();
		firstname = user.getFirstname();
		lastname = user.getLastname();
		email = user.getEmail();
		phone = user.getPhone();
		fullname = firstname + " " + lastname;
		driver = user.isDriver();
		if(user.isDriver())
			username = user.getUsername();
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}
	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	@Override
	public void blurPrivate() {
		this.email = null;
		this.phone = null;
	}
	/**
	 * @return the driver
	 */
	public Boolean isDriver() {
		return driver;
	}
	/**
	 * @param driver the driver to set
	 */
	public void setDriver(Boolean driver) {
		this.driver = driver;
	}
}
