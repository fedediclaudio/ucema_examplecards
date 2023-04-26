package ucema.progra3.examplecards.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Card representa la estructura comun de cualquier tipo de tarjeta
 * Es una clase abstracta, no puede instanciarse directamente sino
 * solo a traves de sus clases hijas
 */

@Entity
@Table(name = "card")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card")
    private Long id;

    @Column(unique = true, updatable = false, nullable = false, length = 16)
    private String number;

    @Column(name = "expiry_date", length = 7)
    private String expiryDate;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_bank", nullable = false)
    private Bank bank;

    @Transient
    private Customer customer;

    @Transient
    private List<Purchase> purchases;

    @Transient
    private double totalSpent;

    /**
     * Constructores
     */
    public Card() {
        // Constructor vacio
    }

    public Card(String number, String expiryDate, Customer customer, Bank bank){
        this.number = number;
        this.expiryDate = expiryDate;
        this.customer = customer;
        this.purchases = new ArrayList<Purchase>();
        this.bank = bank;
    }

    public Card(String number, String expiryDate, Customer customer, Bank bank, List<Purchase> purchases){
        this.number = number;
        this.expiryDate = expiryDate;
        this.customer = customer;
        this.purchases = purchases;
        this.bank = bank;
    }

    /**
     * Metodos
     */

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public void addToBank(Bank bank) {
        bank.addCard(this);
    }

    public void deletePurchase(Purchase purchase) {
        purchases.remove(purchase);
        totalSpent -= purchase.getAmount();
    }

    /**
     * Calcula el precio a pagar de una compra, con los recargos o descuentos de una tarjeta
     * @param purchase una compra que posee un valor
     * @return el valor final de la compra
     * Es un metoodo abstracto, cada clase hija debe darle una implementación ya que
     * su valor final dependera del tipo de tarjeta con el que se va a pagar
     */
    public abstract double calculatePrice(Purchase purchase);


    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
