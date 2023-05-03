package ucema.progra3.examplecards;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import ucema.progra3.examplecards.config.AppConfig;
import ucema.progra3.examplecards.model.*;
import ucema.progra3.examplecards.services.IBankService;
import ucema.progra3.examplecards.services.ICardService;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {AppConfig.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExamplecardsApplicationTests {

	@Autowired
	private IBankService bankService;

	@Autowired
	private ICardService cardService;

	@BeforeAll
	void beforeAll() {
		Bank bank1 = this.bankService.createBank("Banco Santander", "Av. Libertador 1234");
		Bank bank2 = this.bankService.createBank("Banco Galicia", "Av. Corrientes 4321");
		Bank bank3 = this.bankService.createBank("Banco Ciudad", "Av. de Mayo 5678");
		Bank bank4 = this.bankService.createBank("Banco Provincia", "Av. Rivadavia 9101");
		Bank bank5 = this.bankService.createBank("Banco Macro", "Av. Belgrano 2468");
		Bank bank6 = this.bankService.createBank("Banco Nación", "Av. Paseo Colón 3456");
		Bank bank7 = this.bankService.createBank("Banco Hipotecario", "Av. Santa Fe 7890");
		Bank bank8 = this.bankService.createBank("Banco BBVA", "Av. Córdoba 123");
		Bank bank9 = this.bankService.createBank("Banco Supervielle", "Av. Cabildo 456");
		Bank bank10 = this.bankService.createBank("Banco Itaú", "Av. Juan B. Justo 789");

		Card card1 = this.cardService.createCreditCard("1111222233334444", "12/25", null, bank1, 5000.0, 20.0);
		Card card2 = this.cardService.createCreditCard("5555666677778888", "01/26", null, bank2, 10000.0, 18.5);
		Card card3 = this.cardService.createCreditCard("9999888877776666", "08/27", null, bank3, 2500.0, 25.0);
		Card card4 = this.cardService.createCreditCard("4444333322221111", "06/28", null, bank4, 7500.0, 15.0);
		Card card5 = this.cardService.createCreditCard("3333444455556666", "11/29", null, bank5, 5000.0, 21.0);
		Card card6 = this.cardService.createCreditCard("7777666655554444", "07/30", null, bank6, 1000.0, 30.0);
		Card card7 = this.cardService.createCreditCard("2222333344445555", "02/31", null, bank7, 15000.0, 12.5);
		Card card8 = this.cardService.createCreditCard("6666555577778888", "09/32", null, bank8, 5000.0, 22.5);
		Card card9 = this.cardService.createCreditCard("8888777766665555", "04/33", null, bank9, 10000.0, 17.5);
		Card card10 = this.cardService.createCreditCard("4444555566667777", "03/34", null, bank1, 5000.0, 20.0);

		Card card11 = this.cardService.createDebitCard("1111222233335555", "05/25", null, bank1, "123");
		Card card12 = this.cardService.createDebitCard("5555666677779999", "12/26", null, bank2, "456");
		Card card13 = this.cardService.createDebitCard("9999888877774444", "07/27", null, bank3, "789");
		Card card14 = this.cardService.createDebitCard("4444333322227777", "02/28", null, bank4, "321");
		Card card15 = this.cardService.createDebitCard("3333444455559999", "09/29", null, bank5, "654");
		Card card16 = this.cardService.createDebitCard("7777666655554442", "04/30", null, bank6, "987");
		Card card17 = this.cardService.createDebitCard("2222333344441112", "01/31", null, bank7, "159");
		Card card18 = this.cardService.createDebitCard("6666555577778884", "08/32", null, bank8, "753");
		Card card19 = this.cardService.createDebitCard("8888777766665556", "03/33", null, bank9, "246");
		Card card20 = this.cardService.createDebitCard("4444555566663337", "06/34", null, bank1, "852");

	}

	@Test
	void findBankByName() {
		Bank bank = this.bankService.searchBankByName("Banco Santander");
		int size = bank.getCards().size();
	}

	@Test
	void allBanks() {
		List<Bank> banks = this.bankService.allBanks();
	}

	@Test
	void findBanksByCardNumber(){
		Bank bank = this.bankService.searchByCardNumber("1111222233335555");
	}


	@Test
	void findBanksWithoutCards() {
		List<Bank> banks = this.bankService.allBanksWithoutCard();
	}

	@Test
	void findBanksWithoutCardsSQL() {
		List<Bank> banks = this.bankService.allBanksWithoutCardSQL();
	}


}
