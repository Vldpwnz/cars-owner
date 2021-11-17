package ee.hansabIT.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarsOwnerConfiguration {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
