package me.didia.monlift.requests;

import java.util.Date;

import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.User;
import me.didia.monlift.visitors.RequestValidatorVisitor;
import me.didia.monlift.visitors.RequestVisitor;

public class CreateLiftRequest extends BaseRequest {
	public static final String FROM_FIELD = "from";
	public static final String TO_FIELD = "to";
	public static final String TIME_FIELD = "time";
	public static final String PRICE_FIELD = "price";
	public static final String MEETING_PLACE_FIELD = "meeting place";
	public static final String TOTAL_PLACE_FIELD = "total number of place";
	public static final String CAR_ID_FIELD = "car";
	
	public String from;
	public String to;
	public Date time;
	public Double price;
	public String meetingPlace;
	public Integer totalPlace;
	public Long carId;
	public Car car = null;
	public User driver = null;
	
	
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String p_from) {
		from = p_from;
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
	public void setTo(String p_to) {
		to = p_to;
	}
	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date p_time) {
		time = p_time;
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
	public void setPrice(Double p_price) {
		price = p_price;
	}
	/**
	 * @return the meetingPlace
	 */
	public String getMeetingPlace() {
		return meetingPlace;
	}
	/**
	 * @param meetingPlace the meetingPlace to set
	 */
	public void setMeetingPlace(String p_meetingPlace) {
		meetingPlace = p_meetingPlace;
	}
	/**
	 * @return the totalPlace
	 */
	public Integer getTotalPlace() {
		return totalPlace;
	}
	/**
	 * @param totalPlace the totalPlace to set
	 */
	public void setTotalPlace(Integer p_totalPlace) {
		totalPlace = p_totalPlace;
	}
	/**
	 * @return the carId
	 */
	public Long getCarId() {
		return carId;
	}
	/**
	 * @param carId the carId to set
	 */
	public void setCarId(Long p_carId) {
		carId = p_carId;
	}

	/**
	 * @return the driver
	 */
	public User getDriver() {
		return driver;
	}
	/**
	 * @param driver the driver to set
	 */
	public void setDriver(User p_driver) {
		driver = p_driver;
	}
	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}
	
	public void setCar(Car p_car) {
		car = p_car;
	}
	@Override
	public void accept(RequestVisitor p_visitor)
	{
		p_visitor.visit(this);
	}

	

	
	
	
}
