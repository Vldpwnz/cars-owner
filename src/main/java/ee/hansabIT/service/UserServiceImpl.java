 package ee.hansabIT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.hansabIT.entity.User;
import ee.hansabIT.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	
	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.userRepository = repository;
	}



	@Override
	public User getUserById(final Long id) {
		
		Optional<User> result = userRepository.findById(id);
		User user = null;
		
		if(result.isPresent()) {
			user = result.get();
		} else {
			throw new RuntimeException("User doesn't exist with such id: " + id);
		}
		
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		
		return this.userRepository.findAll();
	}
	
	
}
