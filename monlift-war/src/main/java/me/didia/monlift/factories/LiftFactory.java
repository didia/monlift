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
import me.didia.monlift.requests.CreateCarRequest;
import me.didia.monlift.requests.CreateLiftRequest;

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
	
	public static Lift getLiftById(Long p_id)
	{
		return ofy().load().type(Lift.class).id(p_id).now();
	}
	
	public static List<Lift> getLiftsByUser(User p_user)
	{
		List<Lift> lifts = ofy().load().type(Lift.class).filter("m_driver", p_user).list();
		return lifts;
	}
	

	
	public static Car createCar(User user, CreateCarRequest p_request)
	{
		Car car = new Car();
		car.setName(p_request.getName());
		car.setDescription(p_request.getDescription());
		car.setOwner(user);
		saveCar(car);
		
		return car;	
	}
	
	public static Car getCar(User owner, Long p_id){
		return ofy().load().type(Car.class).parent(owner).id(p_id).now();
		
	}
	
	public static Key<Car> saveCar(Car car){
		return ofy().save().entity(car).now();
	}
	
	public static Key<Lift> save(Lift lift){
		return ofy().save().entity(lift).now();
	}
	
}
