package me.didia.monlift.requests;



import org.apache.commons.beanutils.BeanMap;

public interface IRequest {
	
	public void validate() throws ValidationErrorException;
	public BeanMap toMap();
}
