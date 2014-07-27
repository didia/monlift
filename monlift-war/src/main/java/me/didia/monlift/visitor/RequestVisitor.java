/**
 * 
 */
package me.didia.monlift.visitor;

import me.didia.monlift.requests.CreateCarRequest;
import me.didia.monlift.requests.CreateLiftRequest;
import me.didia.monlift.requests.LoginRequest;
import me.didia.monlift.requests.RegisterRequest;
import me.didia.monlift.requests.UpdateUserRequest;

/**
 * @author didia
 *
 */
public interface RequestVisitor {
	public  void visit(CreateCarRequest request);
	public  void visit(LoginRequest request);
	public  void visit(RegisterRequest request);
	public  void visit(UpdateUserRequest request);
	public  void visit(CreateLiftRequest request);
}
