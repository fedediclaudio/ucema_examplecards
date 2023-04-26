package ucema.progra3.examplecards.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela un Banco
 * Es final, por lo que no puede extenderse
 */

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bank")
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(updatable = true, nullable = false, length = 200)
    private String address;

    @Column(name = "total_spent")
    private double totalSpent;

    @OneToMany(mappedBy = "bank", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Card> cards;

    public Bank () {
    }

    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
        this.cards = new ArrayList<Card>();
        this.totalSpent = 0;
    }

    public Bank(String name, String address, ArrayList<Card> cards) {
        this.name = name;
        this.address = address;
        this.cards = cards;
        for(Card card : cards) {
            this.totalSpent += card.getTotalSpent();
        }
    }

    public void addCard(Card card) {
        this.cards.add(card);
        this.totalSpent += card.getTotalSpent();
    }

    public void removeAccount(Card card) {
        this.cards.remove(card);
        this.totalSpent -= card.getTotalSpent();
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
