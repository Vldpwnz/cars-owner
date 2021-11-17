package ee.hansabIT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ee.hansabIT.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
}
