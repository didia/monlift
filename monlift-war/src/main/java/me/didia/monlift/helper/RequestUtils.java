package me.didia.monlift.helper;

import org.joda.time.DateTime;

/**
 * @author didia
 *
 */
public class RequestUtils {

	public static DateTime html5DateToJodaDatetime(String p_date) {
		
		String parts[] = p_date.split("T");
		String date = parts[0];
		String time = parts[1];
		parts = date.split("-");
		Integer year = Integer.parseInt(parts[0]);
		Integer month = Integer.parseInt(parts[1]);
		Integer day = Integer.parseInt(parts[2]);
		parts = time.split(":");
		Integer hour = Integer.parseInt(parts[0]);
		Integer minutes = Integer.parseInt(parts[1]);
		
		
		
		return new DateTime(year, month, day, hour, minutes);
	}
}
