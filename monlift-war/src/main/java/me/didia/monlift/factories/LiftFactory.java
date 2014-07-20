/**
 * 
 */
package me.didia.monlift.factories;

import java.util.ArrayList;

import me.didia.monlift.entities.Lift;

/**
 * @author didia
 *
 */
public class LiftFactory {
	
	private static LiftFactory m_instance = null;
	private LiftFactory(){};
	
	public static LiftFactory getInstance(){
		if(m_instance == null)
			m_instance = new LiftFactory();
		return m_instance;
	}
	
	public Integer createLift() throws DuplicateValueException{
		return null;
	}
	
	public Lift getLiftById(Integer id)
	{
		return null;
	}
	
	public ArrayList<Lift> getLiftsByIds(ArrayList<Integer> ids)
	{
		return null;
	}
	
	public ArrayList<Lift> getLiftsByUser(Integer id)
	{
		return null;
	}
	
	public ArrayList<Lift> getLiftsByUsers(ArrayList<Integer> ids)
	{
		return null;
	}
}
