package ucema.progra3.examplecards.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Representa una tarjeta de credito
 * Extiende de la clase Card, que implementa una estructura comun para cualquier tajeta
 */
@Entity
@DiscriminatorValue("Credit")
public class CreditCard extends Card{

    private double creditLimit;
    private double interestRate;

    public CreditCard(){}

    public CreditCard(String number, String expiryDate, Customer customer,Bank bank,  double creditLimit, double interestRate) {
        super(number, expiryDate, customer, bank); //Llamado al constructor de la clase padre
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    @Override //Indica que sobreescribe un metodo de clase padre
    public double calculatePrice(Purchase purchase) {
        return purchase.getAmount() + (purchase.getAmount() * interestRate);
    }

}
