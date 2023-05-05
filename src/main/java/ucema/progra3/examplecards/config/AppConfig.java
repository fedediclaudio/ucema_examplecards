package ucema.progra3.examplecards.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ucema.progra3.examplecards.services.BankServiceImpl;
import ucema.progra3.examplecards.services.CardServiceImpl;
import ucema.progra3.examplecards.services.interfaces.IBankService;
import ucema.progra3.examplecards.services.interfaces.ICardService;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public IBankService createBankService() {
        return new BankServiceImpl();
    }

    @Bean
    @Primary
    public ICardService createCardService() {
        return new CardServiceImpl();
    }

}
