package ucema.progra3.examplecards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucema.progra3.examplecards.model.*;
import ucema.progra3.examplecards.services.interfaces.IBankService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/bank")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BankController {

    @Autowired
    private IBankService service;

    @GetMapping(path = "")
    public List<Bank> getAllBanks() {
        return this.service.allBanks();
    }

    @GetMapping(path = "/{id}")
    public Bank getBankById(@PathVariable Long id){
        return this.service.getBankById(id);
    }

    @GetMapping(path = "/search")
    public Bank getBankByName(@RequestParam(name = "name") String name) {
        return this.service.searchBankByName(name);
    }

    @GetMapping(path = "/card")
    public Bank getBankByCardNumber(@RequestParam String number) {
        return this.service.searchByCardNumber(number);
    }

    @PostMapping(path = "")
    public Bank createBank(@RequestBody Bank bank) {
        return this.service.createBank(bank.getName(), bank.getAddress());
    }

    @PutMapping(path = "")
    public Bank updateBank(@RequestBody Bank bank) {
        return this.service.updateBank(bank, bank.getName(), bank.getAddress());
    }

    @DeleteMapping(path = "{id}")
    public void deleteBank(@PathVariable Long id) {
        this.service.deleteBank(id);
    }
}
