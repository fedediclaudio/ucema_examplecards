package ucema.progra3.examplecards.services.interfaces;

import ucema.progra3.examplecards.model.*;

import java.util.List;

public interface ICardService {

    CreditCard createCreditCard(String number, String expiryDate, User customer,Bank bank,  double creditLimit, double interestRate);

    DebitCard createDebitCard(String number, String expiryDate, User customer, Bank bank, String pin);

    List<Card> findByBankName(String name);

    List<Card> getCardOfUser();
}

