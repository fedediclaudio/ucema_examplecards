package ucema.progra3.examplecards;

import org.apache.commons.lang3.math.Fraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ucema.progra3.examplecards.model.Bank;
import ucema.progra3.examplecards.model.Card;
import ucema.progra3.examplecards.model.Role;
import ucema.progra3.examplecards.model.User;
import ucema.progra3.examplecards.services.interfaces.IBankService;
import ucema.progra3.examplecards.services.interfaces.ICardService;
import ucema.progra3.examplecards.services.interfaces.IUserService;

@SpringBootApplication()
public class ExamplecardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamplecardsApplication.class, args);
	}

	@Bean
	CommandLineRunner run(@Autowired IBankService bankService, @Autowired ICardService cardService, @Autowired IUserService userService) {
		// INICIALIZACION DE BASE DE DATOS
		return args -> {
			Role admin = new Role("ADMIN");
			Role user = new Role("USER");
			userService.createRole(admin);
			userService.createRole(user);
			User userAdmin = userService.createUser(new User("useradmin", "pass123", admin));
			User user1 = userService.createUser(new User("user1", "pass123", user));
			User user2 = userService.createUser(new User("user2", "pass123", user));
			User user3 = userService.createUser(new User("user3", "pass123", user));

			Bank bank1 = bankService.createBank("Banco Santander", "Av. Libertador 1234");
			Bank bank2 = bankService.createBank("Banco Galicia", "Av. Corrientes 4321");
			Bank bank3 = bankService.createBank("Banco Ciudad", "Av. de Mayo 5678");
			Bank bank4 = bankService.createBank("Banco Provincia", "Av. Rivadavia 9101");
			Bank bank5 = bankService.createBank("Banco Macro", "Av. Belgrano 2468");
			Bank bank6 = bankService.createBank("Banco Nación", "Av. Paseo Colón 3456");
			Bank bank7 = bankService.createBank("Banco Hipotecario", "Av. Santa Fe 7890");
			Bank bank8 = bankService.createBank("Banco BBVA", "Av. Córdoba 123");
			Bank bank9 = bankService.createBank("Banco Supervielle", "Av. Cabildo 456");
			Bank bank10 = bankService.createBank("Banco Itaú", "Av. Juan B. Justo 789");

			Card card1 = cardService.createCreditCard("1111222233334444", "12/25", user1, bank1, 5000.0, 20.0);
			Card card2 = cardService.createCreditCard("5555666677778888", "01/26", user1, bank2, 10000.0, 18.5);
			Card card3 = cardService.createCreditCard("9999888877776666", "08/27", user2, bank3, 2500.0, 25.0);
			Card card4 = cardService.createCreditCard("4444333322221111", "06/28", user3, bank4, 7500.0, 15.0);
			Card card5 = cardService.createDebitCard("1111222233335555", "05/25", user1, bank1, "123");
			Card card6 = cardService.createDebitCard("5555666677779999", "12/26", user2, bank2, "456");
		};
	}

}
