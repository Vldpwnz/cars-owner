package ee.hansabIT.service;

import java.util.List;
import org.springframework.data.domain.Pageable;

import ee.hansabIT.entity.Car;

public interface CarService {
	
	public Car getCarById(Long id);
	public List<Car> getCarByNumberPlate(String numberPlate, Pageable pageble );
}
