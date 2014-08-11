package me.didia.monlift;

import java.util.HashMap;

/**
 * @author didia
 *
 */
public class MonliftPath {
	
	static final public String BASE_PATH = "api";
	static final public String PROFILE_SELF_PATH = "me";
	static final public String USER_PATH = "{id}";
	static final public String USER_FIELD_PATH = "{id}/{field}";
	static final public String USER_LIFTS_PATH = "{id}/lifts";
	static final public String USER_EDIT_PATH = "{id}/edit";
	static final public String USER_PROMOTE_PATH = "{id}/promote";
	
	static public String buildPath(String p_path, HashMap<String, String> p_values)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(BASE_PATH).append("/").append(p_path);
		String newPath = sb.toString();
		if(p_values == null)
		{
			return newPath;
		}
		for(String placeHolder: p_values.keySet()) {
			newPath = newPath.replace("{" + placeHolder + "}", p_values.get(placeHolder));
		}
		
		return newPath;
	}
	
}
