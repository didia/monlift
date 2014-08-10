package me.didia.monlift.requests;

import me.didia.monlift.exceptions.ValidationErrorException;
import me.didia.monlift.visitors.RequestVisitor;


public interface IRequest {
	
	public void validate() throws ValidationErrorException;
	public void accept(RequestVisitor visitor);

	
}
