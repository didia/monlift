package me.didia.monlift.requests;

public interface IRequest {
	
	public void validate() throws ValidationErrorException;
}
