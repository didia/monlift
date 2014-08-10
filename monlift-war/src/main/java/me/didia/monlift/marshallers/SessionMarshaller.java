package me.didia.monlift.marshallers;

import java.util.ArrayList;
import java.util.List;

import me.didia.monlift.exceptions.MonliftException;
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

	@Override
	public List<SessionResponse> marshall(List<Session> p_sessions) {
		//NOT IMPLEMENTED cannot return multiple session
		return null;
	}


	
}
