package ee.hansabIT.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ee.hansabIT.dto.CarDTO;
import ee.hansabIT.entity.Car;
import ee.hansabIT.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

	private final CarService carService;
	private final ModelMapper mapper;
	

	@Autowired
	public CarController(CarService carService, ModelMapper mapper) {
		this.carService = carService;
		this.mapper = mapper;
	}
	
	@GetMapping
	public ResponseEntity<List<CarDTO>> getAllCars(){
		List<Car> cars = this.carService.getAllCars();
		
		if(cars.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.header("causedBy", "No cars exist")
					.body(null);
		}
		List<CarDTO> carsDTO = cars
				.stream()
				.map(car -> mapper.map(car, CarDTO.class))
				.collect(Collectors.toList());
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(carsDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarDTO> getCarById(@PathVariable Long id) {
		
		try {
			Car car = carService.getCarById(id);
			CarDTO carDTO = mapper.map(car, CarDTO.class);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(carDTO);
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.header("error", "No such car" )
					.body(null);
		}
	}
	
	
}
