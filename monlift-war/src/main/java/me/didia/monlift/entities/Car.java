package me.didia.monlift.entities;

import static com.googlecode.objectify.ObjectifyService.ofy;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

/**
 * @author didia
 * 
 */

@Entity
public class Car extends AbstractEntity {
	@Id private Long m_id;
	private String m_name;
	private String m_description;
	@Parent Key<User> m_owner;

	public Long getId() {
		return m_id;
	}

	public void setId(Long id) {
		m_id = id; 
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return m_name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		m_name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return m_description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		m_description = description;
	}

	public void setOwner(User user) {
		m_owner = Key.create(User.class, user.getId());
	}
	
	public User getOwner(){
		return ofy().load().key(m_owner).now();
	}

}
