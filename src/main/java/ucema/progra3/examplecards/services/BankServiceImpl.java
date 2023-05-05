package ucema.progra3.examplecards.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucema.progra3.examplecards.model.Bank;
import ucema.progra3.examplecards.repositories.BankRepository;
import ucema.progra3.examplecards.services.interfaces.IBankService;

import java.util.List;

@Service
public class BankServiceImpl implements IBankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    @Transactional
    public Bank createBank(String name, String address) {
        Bank bank = new Bank(name, address);
        Bank savedBank = this.bankRepository.save(bank);
        return savedBank;
    }

    @Override
    @Transactional
    public Bank updateBank(Bank bank, String name, String address) {
        bank.setName(name);
        bank.setAddress(address);
        Bank updateBank = this.bankRepository.save(bank);
        return updateBank;
    }

    @Override
    @Transactional
    public void deleteBank(Bank bank) {
        this.bankRepository.delete(bank);
    }

    @Override
    public Bank getBankById(Long id) {
        return this.bankRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Bank searchBankByName(String name) {
        return this.bankRepository.findByName(name).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Bank> allBanks() {
        return (List<Bank>) this.bankRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Bank> searchBankByMinTotalSpent(float spent) {
        return this.bankRepository.findByTotalSpentGreaterThanEqual(spent);
    }

    @Override
    public Bank searchByCardNumber(String number) {
        return this.bankRepository.findByCards_Number(number).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Bank> allBanksWithoutCard() {
        return this.bankRepository.findByWithoutCards();
    }

    @Override
    public List<Bank> allBanksWithoutCardSQL() {
        return this.bankRepository.findByWithoutCardsSQL();
    }
}
