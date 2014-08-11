/**
 * 
 */
package me.didia.monlift.responses;

import java.util.HashMap;

import me.didia.monlift.entities.Car;

/**
 * @author didia
 *
 */
public class CarResponse implements IResponse<Car> {

	public String name;
	public Long id;
	public String description;
	public HashMap<String, String> linkTo = new HashMap<String, String>() ;
	
	@Override
	public void build(Car p_car) {
		
		name = p_car.getName();
		id = p_car.getId();
		description = p_car.getDescription();
	}

	@Override
	public void blurPrivate() {
		// No private attributes in car yet
		
	}

	@Override
	public void setLinkTo(HashMap<String, String> p_linkTo) {
		linkTo = p_linkTo;
		
	}

}
