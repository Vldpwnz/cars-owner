package ee.hansabIT.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import ee.hansabIT.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM user u WHERE LOWER(name) LIKE LOWER(concat ('%', ?1, '%' ))")
	List<User> findByName(String name, Pageable pageble);
	
}
