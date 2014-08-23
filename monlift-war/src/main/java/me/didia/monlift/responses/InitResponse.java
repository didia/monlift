package me.didia.monlift.responses;

import java.util.HashMap;

import me.didia.monlift.visitors.ResponseLinkToVisitor;
import me.didia.monlift.visitors.ResponseVisitor;

public class InitResponse implements IResponse<String> {
	
	public String message;
	public HashMap<String,String> linkTo = new HashMap<String,String>();
	
	@Override
	public void build(String p_object) {
		message = p_object;
		buildLinkTo();
		
	}

	@Override
	public void blurPrivate() {
		
	}

	@Override
	public void setLinkTo(HashMap<String, String> p_linkTo) {
		linkTo = p_linkTo;
		
	}

	@Override
	public void accept(ResponseVisitor p_visitor) {
		p_visitor.visit(this);
		
	}

	@Override
	public void buildLinkTo() {
		accept(new ResponseLinkToVisitor());
		
	}

}
