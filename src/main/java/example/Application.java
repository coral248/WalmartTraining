package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean
	Clock clock() {
		return () -> System.currentTimeMillis();
	}

	@Bean
	ParkingStorage parkingStorage(ParkingRepository repository) {
		return new ParkingStorageImpl(repository);
	}

	@Bean
	ParkingService parkingService(Clock clock, ParkingStorage storage) {
		return new ParkingService(clock, storage);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}