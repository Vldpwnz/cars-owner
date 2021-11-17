package ee.hansabIT.service;

import java.util.List;

import ee.hansabIT.entity.Car;

public interface CarService {
	
	public List<Car> getAllCars();
	public Car getCarById(Long id);
}
