package me.didia.monlift.marshallers;

import java.util.ArrayList;
import java.util.List;

import me.didia.monlift.entities.Lift;
import me.didia.monlift.responses.LiftResponse;

public class LiftMarshaller implements IMarshaller<LiftResponse, Lift> {

	@Override
	public LiftResponse marshall(Lift p_lift) {
		LiftResponse response = new LiftResponse();
		response.build(p_lift);
		return response;
	}

	@Override
	public List<LiftResponse> marshall(List<Lift> p_lifts) {
		List<LiftResponse> responses = new ArrayList<LiftResponse>();
		for (Lift lift: p_lifts){
			responses.add(marshall(lift));
		}
		
		return responses;
	}

}
