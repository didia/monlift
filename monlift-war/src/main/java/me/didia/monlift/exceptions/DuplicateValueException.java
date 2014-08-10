package me.didia.monlift.exceptions;


@SuppressWarnings("serial")
public class DuplicateValueException extends MonliftException {
	
	public DuplicateValueException()
	{
		super("A value which was supposed to be unique was duplicated");
	}
	
	public DuplicateValueException(String message)
	{
		super(message);
	}
}
