package ee.hansabIT.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ee.hansabIT.entity.*;

@DataJpaTest
public class RepositoryTest {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired 
	private CarRepository carRepo;
	
	@Test
	public void testIfUserSaved() {
		User user = new User();
		user.setName("Steve Developer");
		User savedUser = userRepo.save(user);
		
		assertEquals(savedUser.getName(), user.getName());
	}
	
	@Test
	public void testIfCarSaved() {
		Car car = new Car();
		car.setNumberPlate("123AAD");
		Car savedCar = carRepo.save(car);
		
		assertEquals(savedCar.getNumberPlate(), car.getNumberPlate());
	}
}
