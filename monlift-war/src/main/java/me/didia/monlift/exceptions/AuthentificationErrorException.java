package me.didia.monlift.exceptions;


@SuppressWarnings("serial")
public class AuthentificationErrorException extends MonliftException {

	public AuthentificationErrorException()
	{
		super("The request cannot be authentificated");
	}
	public AuthentificationErrorException(String message) {
		super(message);
		
	}

}
