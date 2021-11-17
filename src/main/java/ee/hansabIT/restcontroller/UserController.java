package ee.hansabIT.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ee.hansabIT.entity.User;
import ee.hansabIT.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService service;
	
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return this.service.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserName(@PathVariable Long id) {
		return service.getUserById(id);
	}
}
