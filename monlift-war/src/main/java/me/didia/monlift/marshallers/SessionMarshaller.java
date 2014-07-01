package me.didia.monlift.marshallers;

import me.didia.monlift.BaseException;
import me.didia.monlift.responses.SessionResponse;
import me.didia.monlift.securities.Session;



public class SessionMarshaller implements IMarshaller<SessionResponse, Session> {
	
	private static SessionMarshaller instance = null;
	
	public static SessionMarshaller getInstance()
	{
		if (instance != null)
		{
			return instance;
		}
		instance = new SessionMarshaller();
		return instance;
	}
	
	public SessionResponse marshall(Session session) {
		SessionResponse response = new SessionResponse();
		response.build(session);
		return response;
		
		
	}

	public SessionResponse marshall(BaseException e) {
		SessionResponse response = new SessionResponse();
		response.build(e);
		return response;
	}

	
}
