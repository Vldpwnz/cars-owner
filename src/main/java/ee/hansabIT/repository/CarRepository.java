package ee.hansabIT.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import ee.hansabIT.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	List<Car> findByUserId(Long id);
	
	@Query("SELECT c FROM car c WHERE "
			+ "LOWER(c.producer) LIKE LOWER(concat ('%', ?1, '%' )) OR "
			+ "LOWER(c.model) LIKE LOWER(concat ('%', ?1, '%' )) OR "
			+ "LOWER(c.numberPlate) LIKE LOWER(concat ('%', ?1, '%' ))")
	List<Car> findBySearchField(String searchField, Pageable pageble);
}
