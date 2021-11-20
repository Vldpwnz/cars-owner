package ee.hansabIT.dto;

public class CarUserDTO {

	private CarDTO carDTO;
	private UserDTO userDTO;
	

	public UserDTO getUser() {
		return userDTO;
	}

	public void setUser(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public CarDTO getCar() {
		return carDTO;
	}

	public void setCar(CarDTO carDTO) {
		this.carDTO = carDTO;
	}

	
}
