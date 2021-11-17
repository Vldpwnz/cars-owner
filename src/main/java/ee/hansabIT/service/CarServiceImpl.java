package ee.hansabIT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ee.hansabIT.entity.Car;
import ee.hansabIT.repository.CarRepository;

public class CarServiceImpl implements CarService {
	
	private final CarRepository carRepository;
	
	
	@Autowired
	public CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public List<Car> findAll() {
		return carRepository.findAll();
	}

	@Override
	public Car findById(final Long id) {
		Optional<Car> result = carRepository.findById(id);
		Car car = null;
		
		if(result.isPresent()) {
			car = result.get();
		} else {
			throw new RuntimeException("Car doesn't exist with such id : " + id);
		}
		return car;
	}
	
	

}
