package ucema.progra3.examplecards.services.interfaces;

import ucema.progra3.examplecards.model.Bank;
import ucema.progra3.examplecards.model.Card;

import java.util.List;

public interface IBankService {

    Bank createBank(String name, String address);
    Bank updateBank(Bank bank, String name, String address);
    void deleteBank(Long id);

    Bank getBankById(Long id);
    Bank searchBankByName(String name);
    List<Bank> allBanks();
    List<Bank> searchBankByMinTotalSpent(float spent);
    Bank searchByCardNumber(String number);

    List<Bank> allBanksWithoutCard();
    List<Bank> allBanksWithoutCardSQL();

}
