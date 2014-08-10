/**
 * 
 */
package me.didia.monlift.visitors;

import me.didia.monlift.requests.CreateCarRequest;
import me.didia.monlift.requests.CreateLiftRequest;
import me.didia.monlift.requests.LoginRequest;
import me.didia.monlift.requests.PromoteUserRequest;
import me.didia.monlift.requests.RegisterRequest;
import me.didia.monlift.requests.UpdateUserRequest;

/**
 * @author didia
 *
 */
public interface RequestVisitor {
	public  void visit(CreateCarRequest p_request);
	public  void visit(LoginRequest p_request);
	public  void visit(RegisterRequest p_request);
	public  void visit(UpdateUserRequest p_request);
	public  void visit(CreateLiftRequest p_request);
	public  void visit(PromoteUserRequest p_request);
}
