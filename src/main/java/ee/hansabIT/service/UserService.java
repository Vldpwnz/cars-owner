package ee.hansabIT.service;

import java.util.List;

import ee.hansabIT.entity.User;

public interface UserService {

	User getUserById(Long id);
	List<User> getAllUsers();
}
