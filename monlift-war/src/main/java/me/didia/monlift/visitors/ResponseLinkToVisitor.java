package me.didia.monlift.visitors;

import java.util.HashMap;

import me.didia.monlift.MonliftRoutes;
import me.didia.monlift.responses.CarResponse;
import me.didia.monlift.responses.InitResponse;
import me.didia.monlift.responses.LiftResponse;
import me.didia.monlift.responses.SessionResponse;
import me.didia.monlift.responses.SuccessResponse;
import me.didia.monlift.responses.UserResponse;

public class ResponseLinkToVisitor implements ResponseVisitor {

	@Override
	public void visit(CarResponse p_response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(LiftResponse p_response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(SessionResponse p_response) {
		HashMap<String, String> linkTo = new HashMap<String, String>();
		String logoutPath = MonliftRoutes.OAUTH_BASE_PATH + MonliftRoutes.OAUTH_LOGOUT_PATH;
		linkTo.put("logout", MonliftRoutes.buildPath(logoutPath, null));
		p_response.setLinkTo(linkTo);

	}

	@Override
	public void visit(SuccessResponse p_response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(UserResponse p_response) {
		HashMap<String, String> values = new HashMap<String, String>();
		values.put("id", p_response.getId().toString());
		
		HashMap<String, String> linkTo = new HashMap<String, String>();
		linkTo.put("edit", MonliftRoutes.buildPath(MonliftRoutes.USER_EDIT_PATH,values));
		linkTo.put("liftsByUser", MonliftRoutes.buildPath(MonliftRoutes.LIFTS_BY_USER_PATH, values));
		if(!p_response.isDriver()) {
			linkTo.put("promote", MonliftRoutes.buildPath(MonliftRoutes.USER_PROMOTE_PATH, values));
		}
		linkTo.put("show", MonliftRoutes.buildPath(MonliftRoutes.USER_PATH, values));
		linkTo.put("userCars", MonliftRoutes.buildPath(MonliftRoutes.USER_CARS_PATH, values));
		
		p_response.setLinkTo(linkTo);
		

	}

	@Override
	public void visit(InitResponse p_response) {
		HashMap<String,String> linkTo = new HashMap<String, String>();
		String loginPath = MonliftRoutes.OAUTH_BASE_PATH + MonliftRoutes.OAUTH_LOGIN_PATH;
		String registerPath = MonliftRoutes.OAUTH_BASE_PATH + MonliftRoutes.OAUTH_REGISTER_PATH;
		linkTo.put("login", MonliftRoutes.buildPath(loginPath, null));
		linkTo.put("register", MonliftRoutes.buildPath(registerPath, null));
		p_response.setLinkTo(linkTo);
		
		
	}

}
