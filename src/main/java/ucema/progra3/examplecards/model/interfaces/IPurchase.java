package ucema.progra3.examplecards.model.interfaces;

/**
 * Interface que debe implementar cualquier clase de compra
 */
public interface IPurchase {

    int MAX_VALUE = 100000;

    void cancel();
    void printReceipt();
}

