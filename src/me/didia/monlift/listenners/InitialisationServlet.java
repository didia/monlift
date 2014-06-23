package me.didia.monlift.listenners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import me.didia.monlift.entities.User;
import me.didia.monlift.helper.UniqueConstraint;

import com.googlecode.objectify.ObjectifyService;

public class InitialisationServlet implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		registerObjectifyEntities();
		
	}
	private void registerObjectifyEntities()
	{
		ObjectifyService.register(User.class);
		ObjectifyService.register(UniqueConstraint.class);
	}

}
