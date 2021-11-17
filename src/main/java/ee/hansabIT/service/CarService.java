package ee.hansabIT.service;

import java.util.List;

import ee.hansabIT.entity.Car;

public interface CarService {
	
	public List<Car> findAll();
	public Car findById(Long id);
}
