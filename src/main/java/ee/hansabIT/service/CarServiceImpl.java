package ee.hansabIT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ee.hansabIT.entity.Car;
import ee.hansabIT.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	
	private final CarRepository carRepository;
	
	
	@Autowired
	public CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public Car getCarById(final Long id) {
		Optional<Car> result = carRepository.findById(id);
		Car car = null;
		
		if(result.isPresent()) {
			car = result.get();
		} else {
			throw new RuntimeException("Car doesn't exist with such id : " + id);
		}
		return car;
	}

	@Override
	public List<Car> getCarByNumberPlate(String numberPlate, Pageable pageble) {
		return carRepository.findByNumberPlate(numberPlate, pageble);
	}
	
	

}
