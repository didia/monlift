package me.didia.monlift.exceptions;


@SuppressWarnings("serial")
public class ValidationErrorException extends MonliftException{

	public ValidationErrorException(String message) {
		super(message);
	}

}
