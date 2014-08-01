/**
 * 
 */
package me.didia.monlift.responses;

import me.didia.monlift.entities.Car;

/**
 * @author didia
 *
 */
public class CarResponse implements IResponse<Car> {

	public String m_name;
	public Long m_id;
	public String m_description;
	@Override
	public void build(Car p_car) {
		
		m_name = p_car.getName();
		m_id = p_car.getId();
		m_description = p_car.getDescription();
		
	}

	@Override
	public void blurPrivate() {
		// No private attributes in car yet
		
	}

}
