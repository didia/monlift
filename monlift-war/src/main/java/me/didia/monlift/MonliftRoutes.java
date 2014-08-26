package me.didia.monlift;

import java.util.HashMap;

/**
 * @author didia
 *
 */
public class MonliftRoutes {
	
	//static final public String BASE_PATH = "api";
	static final public String BASE_PATH = ""; //small hack until the client stop building manually the path
	
	static final public String PROFILE_SELF_PATH = "/me";
	static final public String USER_PATH = "/{id}";
	static final public String USER_FIELD_PATH = "/{id}/{field}";
	static final public String LIFTS_BY_USER_PATH = "/{id}/lifts";
	static final public String USER_EDIT_PATH = "/me/edit";
	static final public String USER_PROMOTE_PATH = "/me/promote";
	static final public String USER_CARS_PATH = "/me/cars";
	
	static final public String OAUTH_BASE_PATH = "/oauth";
	static final public String OAUTH_LOGIN_PATH = "/login";
	static final public String OAUTH_REGISTER_PATH = "/register";
	static final public String OAUTH_LOGOUT_PATH = "/logout";
	
	static final public String LIFTS_BASE_PATH = "/lifts";
	static final public String LIFTS_CREATE_PATH ="/create";
	static final public String LIFTS_SHOW_PUBLIC_PATH = "/{userid}/{id}";
	static final public String LIFTS_SHOW_BY_ME_PATH = "/{id}";
	static final public String LIFTS_EDIT_PATH = "/{id}/edit";
	static final public String LIFTS_DELETE_PATH = "/{id}/delete";
	
	static final public String CARS_BASE_PATH = "/cars";
	static final public String CARS_CREATE_PATH = "/create";
	static final public String CARS_SHOW_PATH = "/{id}";
	static final public String CARS_EDIT_PATH = "/{id}/edit";
	static final public String CARS_DELETE_PATH = "/{id}/delete";
	
	static final public String ADMIN_BASE_PATH = "/admin";
	static final public String ADMIN_USER_DELETE = "/users/delete";
	
	static public String buildPath(String p_path, HashMap<String, String> p_values)
	{
		StringBuilder sb = new StringBuilder();
		String newPath = sb.append(BASE_PATH).append(p_path).toString();
		
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
