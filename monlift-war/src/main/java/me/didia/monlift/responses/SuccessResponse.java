/**
 * 
 */
package me.didia.monlift.responses;

import java.util.HashMap;

/**
 * @author didia
 *
 */
public class SuccessResponse implements IResponse<String> {
	public String message;
	public HashMap<String,String> linkTo = new HashMap<String,String>();
	
	public SuccessResponse(){};
	public SuccessResponse(String p_message) {
		message = p_message;
	}
	
	@Override
	public void build(String p_message) {
		message = p_message;
	}

	@Override
	public void blurPrivate() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setLinkTo(HashMap<String, String> p_linkTo) {
		linkTo = p_linkTo;
	}
	

}
