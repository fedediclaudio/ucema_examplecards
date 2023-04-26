package ucema.progra3.examplecards.model;

import ucema.progra3.examplecards.model.interfaces.IPurchase;

import java.util.Date;

/**
 * Representa una compra
 * Implementa la interfaz IPurchase por lo debe implementar los metodos de esta
 */
public class Purchase implements IPurchase {

    private double amount;
    private String description;
    private Date date;
    private Card card;
    private boolean cancel = false;

    public Purchase(){}

    public Purchase(double amount, String description, Date date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    /**
     * Implementación del comportamiento dado por la interfaz
     */
    @Override //Indica que sobreescribe un metodo de clase padre
    public void cancel() {
        if(card != null) { //Si todavia no fue pagada
            card.deletePurchase(this); //Ejemplo de uso de this como parametro
        }
        cancel = true;
    }

    /**
     * Implementación del comportamiento dado por la interfaz
     */
    @Override //Indica que sobreescribe un metodo de clase padre
    public void printReceipt() {
        System.out.println("Compra: " + description);
        System.out.println("Fecha: " + date.toString());

        if(card != null) {
            System.out.println("Estado: Pagada");
        } else if(!cancel) {
            System.out.println("Estado: Cancelada");
        } else {
            System.out.println("Estado: Pendiente");
        }

        if(card != null) {
            System.out.println("Valor total: " + card.calculatePrice(this)); //Ejemplo del uso de this como parametro
        } else {
            System.out.println("Valor: " + amount);
        }
    }


}
