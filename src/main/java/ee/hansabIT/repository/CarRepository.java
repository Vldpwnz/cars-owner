package ee.hansabIT.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import ee.hansabIT.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	List<Car> findByUserId(Long id);
	
	@Query("SELECT c FROM car c WHERE LOWER(c.numberPlate) LIKE LOWER(concat ('%', ?1, '%' ))")
	List<Car> findByNumberPlate(String numberPlate, Pageable pageble);
}
