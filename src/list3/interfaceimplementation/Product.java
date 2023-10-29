package list3.interfaceimplementation;

import java.util.HashMap;

/**
 * Abstract representation of generic product behaviors.
 */
public interface Product {

    /**
     * Gets name.
     * @return name.
     */
    String getName();

    /**
     * Gets price.
     * @return price.
     */
    int getPrice();

    /**
     * Gets quantity.
     * @return quantity.
     */
    int getQuantity();

    /**
     * Sets quantity.
     * @param newQuantity new quantity.
     */
    void setQuantity(int newQuantity);

    /**
     * Sets price.
     * @param newPrice new price.
     */
    void setPrice(int newPrice);

    /**
     * Gets information about product storage.
     * @return product storage information.
     */
    HashMap<String, Integer> storageInfo();
}
