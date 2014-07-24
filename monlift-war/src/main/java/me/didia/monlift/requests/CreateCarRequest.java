package me.didia.monlift.requests;

/**
 * @author didia
 *
 */
public class CreateCarRequest extends BaseRequest {
	private String m_name;
	private String m_description;

	/**
	 * @return the name
	 */
	public String getName() {
		return m_name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		m_name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return m_description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		m_description = description;
	}
}

