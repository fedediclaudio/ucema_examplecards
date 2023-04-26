package ucema.progra3.examplecards.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Representa una tarjeta de debito
 * Extiende de la clase Card, que implementa una estructura comun para cualquier tajeta
 */
@Entity
@DiscriminatorValue("Debit")
public class DebitCard extends Card {


    private String pin;

    public DebitCard(){}


    public DebitCard(String number, String expiryDate, Customer customer, Bank bank, String pin) {
        super(number, expiryDate, customer, bank); //Llamado al constructor de la clase padre
        this.pin = pin;
    }

    public String getPin() {
        return this.pin;
    }

    @Override //Indica que sobreescribe un metodo de clase padre
    public double calculatePrice(Purchase purchase) {
        return purchase.getAmount();
    }
}
