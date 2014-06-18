package me.didia.monlift.entities;

public class UserFactory {
	
	private static UserFactory instance = null;
	
	private UserFactory(){};
	
	public static UserFactory getInstance(){
		if (instance == null){
			instance = new UserFactory();
		}
		return instance;
	}
	
	public Passenger createPassenger(String firstname,String lastname, String email,String phone){
		Passenger p= new Passenger();
		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setPhone(phone);
		p.setEmail(email);
		
		return p;
	}
}
