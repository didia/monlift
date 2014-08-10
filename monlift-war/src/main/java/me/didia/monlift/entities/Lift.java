package me.didia.monlift.entities;

import static com.googlecode.objectify.ObjectifyService.ofy;

import org.joda.time.DateTime;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import com.googlecode.objectify.annotation.Parent;

/**
 * @author didia
 *
 */
@Entity
public class Lift extends AbstractEntity{
	
	@Id private Long m_id;
	@Index private String m_from;
	@Index private String m_to;
	@Index private DateTime m_time;
	private Double m_price;
	private String m_meetingPlace;
	private Integer m_totalPlace;
	@Index private Integer m_availablePlace;
	@Load @Parent private Key<User> m_driver;
	@Load private Ref<Car> m_car;
	
	
	public Long getId() {
		return m_id;
	}
	
	public void setId(Long p_id) {
		m_id = p_id;
	}
	public String getFrom() {
		return m_from;
	}

	public void setFrom(String p_from) {
		m_from = p_from;
	}

	public String getTo() {
		return m_to;
	}

	public void setTo(String p_to) {
		m_to = p_to;
	}

	public DateTime getTime() {
		return m_time;
	}

	public void setTime(DateTime p_time) {
		m_time = p_time;
	}

	public Double getPrice() {
		return m_price;
	}

	public void setPrice(Double p_price) {
		m_price = p_price;
	}

	public String getMeetingPlace() {
		return m_meetingPlace;
	}

	public void setMeetingPlace(String p_meetingPlace) {
		m_meetingPlace = p_meetingPlace;
	}

	public Integer getTotalPlace() {
		return m_totalPlace;
	}

	public void setTotalPlace(Integer p_totalPlace) {
		m_totalPlace = p_totalPlace;
	}

	public Integer getAvailablePlace() {
		return m_availablePlace;
	}

	public void setAvailablePlace(Integer p_availablePlace) {
		m_availablePlace = p_availablePlace;
	}

	public Car getCar() {
		return m_car.get();
	}

	public void setCar(Car p_car) {
		m_car = Ref.create(p_car);
	}
	
	public User getDriver(){
		return ofy().load().key(m_driver).now();
	}
	
	public Long getDriverId(){
		return Key.create(Lift.class, m_id).getParent().getId();
	}
	
	public Key<User> getDriverKey(){
		return Key.create(Lift.class, m_id).getParent();
	}
	public void setDriver(User p_user)
	{
		m_driver = Key.create(User.class, p_user.getId());
	}
	
}
