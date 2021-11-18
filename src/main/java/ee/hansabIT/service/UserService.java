package ee.hansabIT.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import ee.hansabIT.entity.User;

public interface UserService {

	User getUserById(Long id);
	List<User> getUserByName(String name, Pageable pageble);
}
