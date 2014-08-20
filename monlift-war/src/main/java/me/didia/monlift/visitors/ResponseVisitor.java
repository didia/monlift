package me.didia.monlift.visitors;

import me.didia.monlift.responses.CarResponse;
import me.didia.monlift.responses.LiftResponse;
import me.didia.monlift.responses.SessionResponse;
import me.didia.monlift.responses.SuccessResponse;
import me.didia.monlift.responses.UserResponse;

public interface ResponseVisitor {
	public void visit(CarResponse p_response);
	public void visit(LiftResponse p_response);
	public void visit(SessionResponse p_response);
	public void visit(SuccessResponse p_response);
	public void visit(UserResponse p_response);
}
