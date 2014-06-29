package me.didia.monlift.helper;

import me.didia.monlift.securities.Session;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * This utility will convert a Object List data into JSONArray format.
 * 
 * @author JakeIbeeMassa
 */

public class ToJSON {
	
	/**
	 * Convert Session object to Json object
	 * @throws JSONException 
	 * @throws JsonProcessingException 
	 */
	public static JSONObject sessionToJSON(Session session) throws JsonProcessingException, JSONException{
		JSONObject sessionTOJson = new JSONObject();
		sessionTOJson.put("user", ObjectToJSON(session.getUser()));
		sessionTOJson.put("token", session.getToken());
		return sessionTOJson;
	}
	
	public static String ObjectToJSON(Object obj) throws JsonProcessingException{
		ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = mapper.writeValueAsString(obj);
		return json;
	}

}
