package me.didia.monlift.responses;

import java.util.HashMap;

import me.didia.monlift.visitors.ResponseVisitor;


public interface IResponse<In> {
	public void build(In o);
	public void blurPrivate();
	public void setLinkTo(HashMap<String, String> p_linkTo);
	public void accept(ResponseVisitor p_visitor);
	public void buildLinkTo();
}
