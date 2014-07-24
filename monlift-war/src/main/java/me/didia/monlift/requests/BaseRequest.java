package me.didia.monlift.requests;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;

public class BaseRequest implements IRequest{
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void validate() throws ValidationErrorException {
		if(token.isEmpty() || token == ""){
			throw new ValidationErrorException("empty token provided");
		}
	}


		
}
