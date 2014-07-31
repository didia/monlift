package me.didia.monlift.requests;

import java.util.ArrayList;
import java.util.Date;

import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.User;
import me.didia.monlift.visitor.RequestValidatorVisitor;
import me.didia.monlift.visitor.RequestVisitor;

public class CreateLiftRequest extends BaseRequest {
	public static final String FROM_FIELD = "from";
	public static final String TO_FIELD = "to";
	public static final String TIME_FIELD = "time";
	public static final String PRICE_FIELD = "price";
	public static final String MEETING_PLACE_FIELD = "meeting place";
	public static final String TOTAL_PLACE_FIELD = "total number of place";
	public static final String CAR_ID_FIELD = "car";
	
	private String m_from;
	private String m_to;
	private Date m_time;
	private Double m_price;
	private String m_meetingPlace;
	private Integer m_totalPlace;
	private Long m_carId;
	private Car m_car = null;
	private User m_driver = null;
	
	
	/**
	 * @return the from
	 */
	public String getFrom() {
		return m_from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		m_from = from;
	}
	/**
	 * @return the to
	 */
	public String getTo() {
		return m_to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		m_to = to;
	}
	/**
	 * @return the time
	 */
	public Date getTime() {
		return m_time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		m_time = time;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return m_price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		m_price = price;
	}
	/**
	 * @return the meetingPlace
	 */
	public String getMeetingPlace() {
		return m_meetingPlace;
	}
	/**
	 * @param meetingPlace the meetingPlace to set
	 */
	public void setMeetingPlace(String meetingPlace) {
		m_meetingPlace = meetingPlace;
	}
	/**
	 * @return the totalPlace
	 */
	public Integer getTotalPlace() {
		return m_totalPlace;
	}
	/**
	 * @param totalPlace the totalPlace to set
	 */
	public void setTotalPlace(Integer totalPlace) {
		m_totalPlace = totalPlace;
	}
	/**
	 * @return the carId
	 */
	public Long getCarId() {
		return m_carId;
	}
	/**
	 * @param carId the carId to set
	 */
	public void setCarId(Long carId) {
		m_carId = carId;
	}

	/**
	 * @return the driver
	 */
	public User getDriver() {
		return m_driver;
	}
	/**
	 * @param driver the driver to set
	 */
	public void setDriver(User driver) {
		m_driver = driver;
	}
	/**
	 * @return the car
	 */
	public Car getCar() {
		return m_car;
	}
	
	public void setCar(Car p_car) {
		m_car = p_car;
	}
	@Override
	public void accept(RequestVisitor visitor)
	{
		visitor.visit(this);
	}
	@Override
	public void validate(){
		
		accept(RequestValidatorVisitor.getInstance());
	}
	

	
	
	
}
