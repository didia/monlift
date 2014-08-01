package me.didia.monlift.responses;

import me.didia.monlift.entities.Lift;

public class LiftResponse implements IResponse<Lift> {
	
	public String m_from;
	public String m_to;
	public String m_date;
	public Integer m_availablePlace;
	public Double m_price;
	public UserResponse m_driver;
	public CarResponse m_car;


	
	@Override
	public void build(Lift p_lift) {
		m_from = p_lift.getFrom();
		m_to = p_lift.getTo();
		m_date = p_lift.getTime().toString();
		m_availablePlace = p_lift.getAvailablePlace();
		m_price = p_lift.getPrice();
		m_car = new CarResponse();
		m_car.build(p_lift.getCar());
		m_driver = new UserResponse();
		m_driver.build(p_lift.getDriver());
		m_driver.blurPrivate();
	}

	@Override
	public void blurPrivate() {
		m_driver.blurPrivate();
		
	}

}
