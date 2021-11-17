package ee.hansabIT.dto;

import java.util.Set;

import ee.hansabIT.entity.Car;

public class UserDTO {

	private Long id;
	private String name;
	private Set<Car> cars;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Car> getCars() {
		return cars;
	}
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
