/**
 * 
 */
package me.didia.monlift.factories;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.googlecode.objectify.Key;

import me.didia.monlift.entities.Car;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.entities.User;
import me.didia.monlift.exceptions.DuplicateValueException;
import me.didia.monlift.requests.CreateCarRequest;
import me.didia.monlift.requests.CreateLiftRequest;
import com.googlecode.objectify.cmd.Query;

/**
 * @author didia
 *
 */
public class LiftFactory {
	

	public static Lift createLift(CreateLiftRequest p_createRequest) throws DuplicateValueException{
		
		Lift lift = new Lift();
		lift.setDriver(p_createRequest.getDriver());
		lift.setFrom(p_createRequest.getFrom());
		lift.setTo(p_createRequest.getTo());
		lift.setTime(new DateTime(p_createRequest.getTime()));
		lift.setTotalPlace(p_createRequest.getTotalPlace());
		lift.setAvailablePlace(lift.getTotalPlace());
		lift.setMeetingPlace(p_createRequest.getMeetingPlace());
		lift.setPrice(p_createRequest.getPrice());
		lift.setCar(p_createRequest.getCar());
		save(lift);
		return lift;
	}
	
	public static Lift getLiftById(User user, Long p_id)
	{
		Key<Lift> key = Key.create(user.getKey(), Lift.class, p_id);
	
		return ofy().load().key(key).now();
	}
	
	public static List<Lift> getLiftsByDriver(User p_driver)
	{
		List<Lift> lifts = ofy().load().type(Lift.class).ancestor(p_driver).list();
	
		return lifts;
	}
	
	public static List<Lift> getLiftByQuery(String from, String to){
		Query<Lift> query = ofy().load().type(Lift.class);
		query = query.filter("m_from",from);
		query = query.filter("m_to",to);
		return query.list();
	}
	

	
	public static Car createCar(User user, CreateCarRequest p_request)
	{
		Car car = new Car();
		car.setName(p_request.getName());
		car.setDescription(p_request.getDescription());
		car.setMatricule(p_request.getMatricule());
		car.setOwner(user);
		
		save(car);
		
		return car;	
	}
	
	public static Car getCar(User owner, Long p_id){
		return ofy().load().type(Car.class).parent(owner).id(p_id).now();
		
	}
	

	
	public static Key<?> save(Object entity) {
		return ofy().save().entity(entity).now();
	}
	
	public static void delete(Object p_entity) {
		ofy().delete().entity(p_entity).now();
	}

	public static List<Car> getCarsByDriver(User p_driver) {
		
		List<Car> cars = ofy().load().type(Car.class).ancestor(p_driver).list();
		
		return cars;
	}


	
}
