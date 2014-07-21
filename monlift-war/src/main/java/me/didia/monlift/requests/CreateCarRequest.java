package me.didia.monlift.requests;

/**
 * @author didia
 *
 */
public class CreateCarRequest extends BaseRequest {
	private String m_name;
	private String m_brand;
	private String m_description;
	private String m_number;
	private String m_color;
	private Integer m_year;
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
	 * @return the brand
	 */
	public String getBrand() {
		return m_brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		m_brand = brand;
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
	/**
	 * @return the number
	 */
	public String getNumber() {
		return m_number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		m_number = number;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return m_color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		m_color = color;
	}
	/**
	 * @return the year
	 */
	public Integer getYear() {
		return m_year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(Integer year) {
		m_year = year;
	}
}
