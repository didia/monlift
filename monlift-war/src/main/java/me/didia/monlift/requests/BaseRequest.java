package me.didia.monlift.requests;



import java.lang.reflect.Field;

import me.didia.monlift.visitors.RequestValidatorVisitor;
import me.didia.monlift.visitors.RequestVisitor;


public abstract class BaseRequest implements IRequest{
	protected String m_token;
	protected boolean m_valid = false;
	public String getToken() {
		return m_token;
	}

	public void setToken(String token) {
		this.m_token = token;
	}

	@Override
	public void validate(){
		accept(RequestValidatorVisitor.getInstance());
	}
	
	public boolean isValid()
	{
		return m_valid;
	}
	
	public void setValid(boolean p_valid){
		m_valid = p_valid;
	}
	
	@Override
	public void accept(RequestVisitor visitor) {}

	public Object getField(String name) {
		
		try {
			Field thefield = this.getClass().getDeclaredField(name);
			thefield.setAccessible(true);
			return thefield.getType().cast(thefield.get(this));
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			return null;
		}
	}
	
	public void setField(String name, Object value) {
		try {
			Field thefield = this.getClass().getDeclaredField(name);
			thefield.setAccessible(true);
			thefield.set(this, value);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
		
		}
		
	}

		
}
