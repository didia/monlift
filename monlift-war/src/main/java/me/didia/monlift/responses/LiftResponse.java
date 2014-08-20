package me.didia.monlift.responses;

import java.util.HashMap;

import org.joda.time.format.DateTimeFormatter;

import me.didia.monlift.entities.Lift;
import me.didia.monlift.visitors.ResponseVisitor;

public class LiftResponse implements IResponse<Lift> {
	
	public String from;
	public String to;
	public String date;
	public Integer availablePlace;
	public Double price;
	public UserResponse driver;
	public CarResponse car;
	public HashMap<String, String> linkTo = new HashMap<String, String>();


	
	@Override
	public void build(Lift p_lift) {
		from = p_lift.getFrom();
		to = p_lift.getTo();
		date = p_lift.getTime().toString();
		availablePlace = p_lift.getAvailablePlace();
		price = p_lift.getPrice();
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

}
