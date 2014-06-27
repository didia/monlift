package me.didia.monlift.securities;

import me.didia.monlift.BaseException;

@SuppressWarnings("serial")
public class AuthentificationErrorException extends BaseException {

	public AuthentificationErrorException()
	{
		super("The request cannot be authentificated");
	}
	public AuthentificationErrorException(String message) {
		super(message);
		
	}

}
