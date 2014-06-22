package me.didia.monlift.service;

import me.didia.monlift.entities.UserFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class Service {

	public void doRegister(String firstname, String lastname, String email, String phone )
	{
		try{
			UserFactory.getInstance().createPassenger(firstname, lastname, email, phone);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
