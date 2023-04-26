package ucema.progra3.examplecards.services;

import ucema.progra3.examplecards.model.*;

import java.util.List;

public interface ICardService {

    CreditCard createCreditCard(String number, String expiryDate, Customer customer,Bank bank,  double creditLimit, double interestRate);

    DebitCard createDebitCard(String number, String expiryDate, Customer customer, Bank bank, String pin);

    List<Card> findByBankName(String name);
}

