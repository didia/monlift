package me.didia.monlift.responses;

import java.util.HashMap;

import org.joda.time.format.DateTimeFormatter;

import me.didia.monlift.entities.Lift;
import me.didia.monlift.visitors.ResponseVisitor;

public class LiftResponse implements IResponse<Lift> {
	private Long id;
	private String from;
	private String to;
	private String date;
	private Integer availablePlace;
	private Double price;
	private UserResponse driver;
	private CarResponse car;
	private HashMap<String, String> linkTo = new HashMap<String, String>();


	
	@Override
	public void build(Lift p_lift) {
		setId(p_lift.getId());
		setFrom(p_lift.getFrom());
		setTo(p_lift.getTo());
		setDate(p_lift.getTime().toString());
		setAvailablePlace(p_lift.getAvailablePlace());
		setPrice(p_lift.getPrice());
		car = new CarResponse();
		car.build(p_lift.getCar());
		driver = new UserResponse();
		driver.build(p_lift.getDriver());
		driver.blurPrivate();
	}

	@Override
	public void blurPrivate() {
		driver.blurPrivate();
		
	}

	@Override
	public void setLinkTo(HashMap<String, String> p_linkTo) {
		linkTo = p_linkTo;
	}

	@Override
	public void accept(ResponseVisitor p_visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildLinkTo() {
		// TODO Auto-generated method stub
		
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the availablePlace
	 */
	public Integer getAvailablePlace() {
		return availablePlace;
	}

	/**
	 * @param availablePlace the availablePlace to set
	 */
	public void setAvailablePlace(Integer availablePlace) {
		this.availablePlace = availablePlace;
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
	
	public Long getDriverId() {
		return this.driver.getId();
	}

}
