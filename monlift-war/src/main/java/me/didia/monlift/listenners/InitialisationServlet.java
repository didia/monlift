package me.didia.monlift.listenners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.entities.User;
import me.didia.monlift.helper.UniqueConstraint;
import me.didia.monlift.securities.UserToken;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.impl.translate.opt.joda.JodaTimeTranslators;

public class InitialisationServlet implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		registerObjectifyEntities();
		
	}
	
	private void registerObjectifyEntities()
	{
		JodaTimeTranslators.add(ObjectifyService.factory());
		ObjectifyService.register(User.class);
		ObjectifyService.register(UniqueConstraint.class);
		ObjectifyService.register(UserToken.class);
		ObjectifyService.register(Car.class);
		ObjectifyService.register(Lift.class);
	}

}
