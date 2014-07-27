package me.didia.monlift.requests;

import me.didia.monlift.visitor.RequestVisitor;


public interface IRequest {
	
	public void validate() throws ValidationErrorException;
	public void accept(RequestVisitor visitor);

	
}
