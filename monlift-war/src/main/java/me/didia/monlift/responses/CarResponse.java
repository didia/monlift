/**
 * 
 */
package me.didia.monlift.responses;

import java.util.HashMap;

import me.didia.monlift.entities.Car;
import me.didia.monlift.visitors.ResponseVisitor;

/**
 * @author didia
 *
 */
public class CarResponse implements IResponse<Car> {

	private String name;
	private Long id;
	private String description;
	public HashMap<String, String> linkTo = new HashMap<String, String>() ;
	
	@Override
	public void build(Car p_car) {
		
		setName(p_car.getName());
		setId(p_car.getId());
		setDescription(p_car.getDescription());
	}

	@Override
	public void blurPrivate() {
		// No private attributes in car yet
		
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
