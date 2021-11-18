package ee.hansabIT.dto;

import java.util.Set;

import ee.hansabIT.entity.User;

public class CarUserDTO {

	private Set<CarDTO> carsDTO;
	private User user;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CarDTO> getCarsDTO() {
		return carsDTO;
	}

	public void setCarsDTO(Set<CarDTO> carsDTO) {
		this.carsDTO = carsDTO;
	}
}
