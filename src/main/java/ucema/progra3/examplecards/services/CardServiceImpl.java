package ucema.progra3.examplecards.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucema.progra3.examplecards.authentication.SpringSecurityConfig;
import ucema.progra3.examplecards.model.*;
import ucema.progra3.examplecards.repositories.CardRepository;
import ucema.progra3.examplecards.services.interfaces.ICardService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements ICardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    @Transactional
    public CreditCard createCreditCard(String number, String expiryDate, User customer, Bank bank, double creditLimit, double interestRate) {
        CreditCard card = new CreditCard(number, expiryDate, customer, bank, creditLimit, interestRate);
        bank.addCard(card);
        customer.addCard(card);
        return this.cardRepository.save(card);
    }

    @Override
    @Transactional
    public DebitCard createDebitCard(String number, String expiryDate, User customer, Bank bank, String pin) {
        DebitCard card = new DebitCard(number, expiryDate, customer, bank, pin);
        bank.addCard(card);
        customer.addCard(card);
        return this.cardRepository.save(card);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Card> findByBankName(String name) {
        return this.cardRepository.findByBank_Name(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Card> getCardOfUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Card> cards = (List<Card>) this.cardRepository.findByCustomer_Username(username);
        return cards;
    }
}
