package me.didia.monlift.responses;

import java.util.HashMap;


public interface IResponse<In> {
	public void build(In o);
	public void blurPrivate();
	public void setLinkTo(HashMap<String, String> p_linkTo);
}
