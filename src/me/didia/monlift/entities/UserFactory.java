package me.didia.monlift.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import me.didia.monlift.helper.EMF;

import com.google.appengine.api.datastore.Key;

/**
 * UserFactory , used to create Users as Driver or Passenger
 * uses a singleton patterns: Only one object of this can be available.
 *
 */
public class UserFactory {
	/**
	 * single instance of the UserFactory class.
	 */
	private static UserFactory instance = null;
	
	private UserFactory(){};
	
	/**
	 * Singleton method to return an instance of the UserFactory class
	 * @return UserFactory object
	 */
	public static UserFactory getInstance(){
		if (instance == null){
			instance = new UserFactory();
		}
		return instance;
	}
	
	/**
	 * function to create a passenger
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param phone
	 * @return Passenger object
	 */
	public Passenger createPassenger(String firstname,String lastname, String email,String phone){
		Passenger p= new Passenger();
		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setPhone(phone);
		p.setEmail(email);
		return p;
	}
	
	/**
	 * function to change User which is by default a passenger into a driver(Not yet Done)
	 * @param id
	 * @param username
	 * @return Driver object
	 */
	public Passenger createDriverFromPassenger( Key id, String username){
		Passenger  passBecomingDriver = (Passenger) getUser(id);
		EntityManager em = EMF.getInstance().get().createEntityManager();
		try{
			em.getTransaction().begin();
			passBecomingDriver.setDriver(true);
			em.getTransaction().commit();
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			em.close();
		}
		return passBecomingDriver;
	}
	
	/**
	 * function to return user from an Id
	 * @return User object (passenger or Driver)
	 */
	public User getUser(Key id){
		EntityManager em = EMF.getInstance().get().createEntityManager();
		List<User> result = new ArrayList<User>();
		try{
			Query query = em.createQuery("SELECT u FROM User u WHERE u.id = :key");
			query.setParameter("key", id);
			result = query.getResultList();
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			em.close();
		}
		return result.get(0);
	}
	
	/**
	 * save the given user object into the database and return the id of the newly saved object
	 * @param u user object
	 * @return id the id of the newly saved object
	 */
	public Key save(User u){
		EntityManager em = EMF.getInstance().get().createEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(u);
			em.flush();
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		return u.getId();
	}
	
	/**
	 * delete the users that is given from the database
	 * @param u
	 * @return true if user deleted and false elsewhere 
	 */
	/*
	public boolean deleteUser(Key id){
		User userTobeDeleted = getUser(id);
		EntityManager em = EMF.getInstance().get().createEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(userTobeDeleted);
			em.getTransaction().commit();
		}catch(Exception e ) {
			e.printStackTrace();
		}finally{
			em.close();
		}
		return true;
	}
	*/
}
