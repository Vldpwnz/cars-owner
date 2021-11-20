package ee.hansabIT.restcontroller;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ee.hansabIT.dto.CarDTO;
import ee.hansabIT.dto.UserDTO;
import ee.hansabIT.entity.Car;
import ee.hansabIT.entity.User;
import ee.hansabIT.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	private final ModelMapper mapper;
	
	
	@Autowired
	public UserController(UserService userService, ModelMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers(@RequestParam("find") Optional<String> name,
													 @RequestParam("sort") Optional<String> sort,
													 @RequestParam("page") Optional<Integer> page,
													 @RequestParam(required = false, defaultValue = "ASC") String order){
		List<User> users = this.userService
				.getUserByName(name.orElse("_"),
						PageRequest.of(page.orElse(0),10,
		                        Sort.Direction.fromString(order), sort.orElse("name")));
		
		if(users.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.body(null);
		}
		List<UserDTO> usersDTO = users
				.stream()
				.map(user -> mapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(usersDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		try {
			User user = userService.getUserById(id);
			UserDTO userDTO = mapper.map(user, UserDTO.class);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(userDTO);
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.header("error", "No such user" )
					.body(null);
		}
	
	}
	
	@GetMapping("/{id}/cars")
	public ResponseEntity<Set<CarDTO>> getUserCars(@PathVariable Long id){
		try {
			Set<Car> cars = userService.getUserById(id).getCars();
			Set<CarDTO> carsDTO = cars
					.stream()
					.map(car -> mapper.map(car, CarDTO.class))
					.collect(Collectors.toSet());
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(carsDTO);
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.header("error", "No such user")
					.body(null);
		}
	}
}
