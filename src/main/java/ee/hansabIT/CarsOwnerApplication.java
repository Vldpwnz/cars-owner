package ee.hansabIT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "")
public class CarsOwnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsOwnerApplication.class, args);
	}

}
