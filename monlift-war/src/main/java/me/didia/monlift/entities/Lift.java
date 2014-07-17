package me.didia.monlift.entities;

import org.joda.time.DateTime;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * @author didia
 *
 */
@Entity
public class Lift {
	
	@Id private Long id;
	private String from;
	private String to;
	private DateTime time;
	private Double price;
	private String meeting_place;
	private Integer total_place;
	private Integer available_place;
	private Car car;
	
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * @return the time
	 */
	public DateTime getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(DateTime time) {
		this.time = time;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the meeting_place
	 */
	public String getMeetingPlace() {
		return meeting_place;
	}
	/**
	 * @param meeting_place the meeting_place to set
	 */
	public void setMeetingPlace(String meeting_place) {
		this.meeting_place = meeting_place;
	}
	/**
	 * @return the total_place
	 */
	public Integer getTotalPlace() {
		return total_place;
	}
	/**
	 * @param total_place the total_place to set
	 */
	public void setTotalPlace(Integer total_place) {
		this.total_place = total_place;
	}
	/**
	 * @return the available_place
	 */
	public Integer getAvailablePlace() {
		return available_place;
	}
	/**
	 * @param available_place the available_place to set
	 */
	public void setAvailablePlace(Integer available_place) {
		this.available_place = available_place;
	}
	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}
	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}
}
