package me.didia.monlift.factories;

import static com.googlecode.objectify.ObjectifyService.ofy;
import me.didia.monlift.entities.User;

import com.googlecode.objectify.Key;



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
	 * @return User object
	 */
	public Long createUser(String firstname,String lastname, String email,String phone){
		User newUser= new User();
		newUser.setFirstname(firstname);
		newUser.setLastname(lastname);
		newUser.setPhone(phone);
		newUser.setEmail(email);
		save(newUser);
		
		return newUser.getId();
	}
	

	
	/**
	 * function to return user from an Id
	 * @return User object (passenger or Driver)
	 */
	public User getUser(Long id){
		User user = ofy().load().type(User.class).id(id).now();
		return user;
	}
	
	/**
	 * save the given user object into the database and return the id of the newly saved object
	 * @param u user object
	 * @return id the id of the newly saved object
	 */
	public Key<User> save(User user){
		return ofy().save().entity(user).now();
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
