package me.didia.monlift.factories;

import static com.googlecode.objectify.ObjectifyService.ofy;
import me.didia.monlift.entities.User;
import me.didia.monlift.managers.UniqueConstraintManager;
import me.didia.monlift.requests.RegisterRequest;

import com.googlecode.objectify.Key;



/**
 * UserFactory , used to create Users as Driver or Passenger
 * uses a singleton patterns: Only one object of this can be available.
 *
 */
public class UserFactory {

	
	/**
	 * function to create a passenger
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param phone
	 * @return UserResponse object
	 * @throws DuplicateValueException 
	 */
	public static Long createUser(String firstname,String lastname, String email,String phone, String password) throws DuplicateValueException{
		User newUser= new User();
		newUser.setFirstname(firstname);
		newUser.setLastname(lastname);
		newUser.setPhone(phone);
		newUser.setEmail(email);
		newUser.setPassword(password);
		setUniqueConstraint(newUser, "email", email);
		save(newUser);
		return newUser.getId();
	}
	
	public static User createUser(RegisterRequest request) throws DuplicateValueException
	{
		User newUser = new User();
		newUser.setFirstname(request.getFirstname());
		newUser.setLastname(request.getLastname());
		newUser.setPhone(request.getPhone());
		newUser.setEmail(request.getEmail());
		newUser.setPassword(request.getPassword());
		setUniqueConstraint(newUser, UserAttributes.EMAIL, request.getEmail());
		save(newUser);
		return newUser;
		
	}
	/**
	 * function to return user from an Id
	 * @return User object 
	 */
	public static User getUser(Long id){
		User user = ofy().load().type(User.class).id(id).now();
		return user;
	}
	
	/**
	 * function to return user from an email
	 * @return User object 
	 */
	public static User getUserByEmail(String email) {
		
		return ofy().load().type(User.class).filter(UserAttributes.EMAIL, email).first().now();
	}
	
	/**
	 * save the given user object into the database and return the id of the newly saved object
	 * @param u user object
	 * @return id the id of the newly saved object
	 */
	public static Key<User> save(User user){
		return ofy().save().entity(user).now();
	}

	public static void setUniqueConstraint(Object object, String fieldname, String value) throws DuplicateValueException
	{
		if(!UniqueConstraintManager.create(object, fieldname, value))
		{
			String errorMessage = String.format("User with %s \"%s\" already exists", fieldname, value);
			throw new DuplicateValueException(errorMessage);
		}
	}


	
	/**
	 * delete the users that is given from the database
	 * @param u
	 * @return true if user deleted and false elsewhere 
	 */
	/*
	public boolean deleteUser(Key id){
		UserResponse userTobeDeleted = getUser(id);
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
