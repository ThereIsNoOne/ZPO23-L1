package list3.abstractimplementation;

import java.util.HashMap;

/**
 * Abstract representation of generic product.
 */
public abstract class Product {
    protected int price;
    protected int quantity;
    protected final String name;

    public Product(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Gets name of the product.
     * @return the name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the product.
     * @return price of the product.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the quantity of the product.
     * @return quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

       /**
     * Sets the quantity of the product.
     * @param newQuantity new quantity of the product.
     * @throws IllegalArgumentException if the quantity is negative.
     */
    public void setQuantity(int newQuantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity should be more than 0.");
        }
        quantity = newQuantity;
    }

    /**
     * Sets new price.
     * @param price price to be applied.
     * @throws IllegalArgumentException when price is negative.
     */
    public void setPrice(int price) {
        if (price > 0) {
            throw new IllegalArgumentException("Price should be more than 0");
        }
        this.price = price;
    }

    /**
     * Gets information about product storage.
     * @return product storage information.
     */
    public abstract HashMap<String, Integer> storageInfo();
}
