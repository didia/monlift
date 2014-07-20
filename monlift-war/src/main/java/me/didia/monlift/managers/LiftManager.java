package me.didia.monlift.managers;

/**
 * @author didia
 *
 */
public class LiftManager {
	
	private static LiftManager m_instance = null;
	
	private LiftManager(){}
	
	public static LiftManager getInstance()
	{
		if(m_instance == null)
		{
			m_instance = new LiftManager();
		}
		return m_instance;
	}
}
