package com.carleaseplatform;

import com.carleaseplatform.entity.Car;
import com.carleaseplatform.entity.Customer;
import com.carleaseplatform.repo.CarRepo;
import com.carleaseplatform.repo.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarLeasePlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarLeasePlatformApplication.class, args);
	}

	/** Dummy values for Customer class */
	@Bean
	CommandLineRunner initDatabase(CustomerRepo repository) {
		return args -> {
			repository.save(new Customer(1L,"Simon Onumajuru", "Dauphinelaan", "30", "5627 CP", "Eindhoven", "sonumajuru@gmail.com","0684029091"));
			repository.save(new Customer(2L,"Tagwoa Paul Foletia", "De Vriestraat", "212", "5637 JP", "Den Haag", "paultagwoa@gmail.com","0678453821"));
			repository.save(new Customer(3L,"John Doe", "Pisanostraat", "1", "5622 PP", "Amsterdam", "johndoe@gmail.com","067364533"));
			repository.save(new Customer(4L,"Sandra Hoogstraat", "Marseillestraat", "3", "5620 RP", "Utretch", "sandram@gmail.com","06755503"));
		};
	}

	/** Dummy values for Car  class */
	@Bean
	CommandLineRunner initDatabase2(CarRepo repository) {
		return args -> {
			repository.save(new Car(5L,"Toyota", "Camry", 2008, 4, 200, 45000, 63000,45000, 60, 4.5, 239.76));
			repository.save(new Car(6L,"Audi", "R8", 2022, 4, 150, 90000, 25999,0, 60, 8.5, 827.16));
			repository.save(new Car(7L,"BMW", "X4", 2021, 4, 100, 100000, 74000,1000, 24, 3.2, 509.99));
		};
	}
}
