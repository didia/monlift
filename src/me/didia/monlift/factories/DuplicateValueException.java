package me.didia.monlift.factories;

import me.didia.monlift.BaseException;

@SuppressWarnings("serial")
public class DuplicateValueException extends BaseException {
	
	public DuplicateValueException()
	{
		super("A value which was supposed to be unique was duplicated");
	}
	
	public DuplicateValueException(String message)
	{
		super(message);
	}
}
