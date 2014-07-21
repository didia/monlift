package me.didia.monlift.requests;

import java.util.Date;

public class CreateLiftRequest extends BaseRequest {
	private String m_from;
	private String m_to;
	private Date m_time;
	private Double m_price;
	private String m_meetingPlace;
	private Integer m_totalPlace;
	private Integer m_carId;
	
	/**
	 * @return the from
	 */
	public String getFrom() {
		return m_from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		m_from = from;
	}
	/**
	 * @return the to
	 */
	public String getTo() {
		return m_to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		m_to = to;
	}
	/**
	 * @return the time
	 */
	public Date getTime() {
		return m_time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		m_time = time;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return m_price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		m_price = price;
	}
	/**
	 * @return the meetingPlace
	 */
	public String getMeetingPlace() {
		return m_meetingPlace;
	}
	/**
	 * @param meetingPlace the meetingPlace to set
	 */
	public void setMeetingPlace(String meetingPlace) {
		m_meetingPlace = meetingPlace;
	}
	/**
	 * @return the totalPlace
	 */
	public Integer getTotalPlace() {
		return m_totalPlace;
	}
	/**
	 * @param totalPlace the totalPlace to set
	 */
	public void setTotalPlace(Integer totalPlace) {
		m_totalPlace = totalPlace;
	}
	/**
	 * @return the carId
	 */
	public Integer getCarId() {
		return m_carId;
	}
	/**
	 * @param carId the carId to set
	 */
	public void setCarId(Integer carId) {
		m_carId = carId;
	}
	
}
