package me.didia.monlift.requests;

import me.didia.monlift.BaseException;

@SuppressWarnings("serial")
public class ValidationErrorException extends BaseException{

	public ValidationErrorException(String message) {
		super(message);
	}

}
