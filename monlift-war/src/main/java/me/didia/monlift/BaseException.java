package me.didia.monlift;

@SuppressWarnings("serial")
public class BaseException extends Exception {
	private String rawMessage;
	public BaseException(String message)
	{
		super(message);
		rawMessage = "Error: " + message;
		
	}
	public String getRawMessage()
	{
		return rawMessage;
	}
}
