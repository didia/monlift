package me.didia.monlift.requests;



import me.didia.monlift.visitor.RequestVisitor;


public abstract class BaseRequest implements IRequest{
	protected String m_token;
	protected boolean m_valid = false;
	public String getToken() {
		return m_token;
	}

	public void setToken(String token) {
		this.m_token = token;
	}

	public void validate(){
		if(m_token.isEmpty() || m_token == ""){
			m_valid = false;
		}
	}
	
	public boolean isValid()
	{
		return m_valid;
	}

	@Override
	public void accept(RequestVisitor visitor) {}


		
}
