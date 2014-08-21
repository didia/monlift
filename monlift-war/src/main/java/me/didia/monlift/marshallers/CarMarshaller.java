package me.didia.monlift.marshallers;

import java.util.ArrayList;
import java.util.List;

import me.didia.monlift.entities.Car;
import me.didia.monlift.responses.CarResponse;

public class CarMarshaller implements IMarshaller<CarResponse, Car> {

	@Override
	public CarResponse marshall(Car p_car) {
		CarResponse response = new CarResponse();
		response.build(p_car);
		response.buildLinkTo();
		return response;
	}

	@Override
	public List<CarResponse> marshall(List<Car> p_cars) {
		
		List<CarResponse> responses = new ArrayList<CarResponse>();
		
		for (Car car: p_cars){
			responses.add(marshall(car));
		}
		return responses;
	}

}
