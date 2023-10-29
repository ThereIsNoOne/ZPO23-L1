package list3.interfaceimplementation;

import java.util.HashMap;

/**
 * Represents lollipop product.
 */
public class Lollipop implements Product, Discountable {
    private final String name;
    private int quantity;
    private int price;
    private int regularPrice;
    private final Taste taste;

    private static final int lollipopsPerJar = 25;

    /**
     * Initializes the lollipop product.
     * @param name name of the product.
     * @param quantity quantity of the product.
     * @param price price of the product.
     * @param taste taste of the product.
     * @throws IllegalArgumentException if quantity is negative or price
     * is negative
     */
    public Lollipop(String name, int quantity, int price, Taste taste) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity should be more than 0.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price should be more than 0.");
        }
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.taste = taste;
    }

    /**
     * Checks if taste of the product is fruity or not.
     * @return true if taste is fruity, false otherwise.
     */
    public boolean isFruity() {
        return taste.fruity;
    }

    /**
     * Gets name of the product.
     * @return the name of the product.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the product.
     * @return price of the product.
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * Gets the quantity of the product.
     * @return quantity of the product.
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * Calculates discount to be applied.
     * @param percentage discount percentage as a double. E.g. 1% should be
     *                   represented as 0.01.
     */
    @Override
    public void discount(double percentage) {
        if (percentage < 0 || percentage > 1) {
            throw new IllegalArgumentException("Discount should be 0.0 and 1.0");
        }
        regularPrice = price;
        price = (int) ((1 - percentage) * price);
    }

    /**
     * Sets the quantity of the product.
     * @param newQuantity new quantity of the product.
     * @throws IllegalArgumentException if the quantity is negative.
     */
    @Override
    public void setQuantity(int newQuantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity should be more than 0.");
        }
        quantity = newQuantity;
    }

    /**
     * Removes the discount.
     * @throws IllegalArgumentException when there was no discount.
     */
    @Override
    public void removeDiscount() {
        if (regularPrice == -1) {
            throw new IllegalArgumentException("There is no discount given");
        }
        price = regularPrice;
        regularPrice = -1;
    }

    /**
     * Sets new price.
     * @param price price to be applied.
     * @throws IllegalArgumentException when price is negative.
     */
    @Override
    public void setPrice(int price) {
        if (price > 0) {
            throw new IllegalArgumentException("Price should be more than 0");
        }
        this.price = price;
    }

    /**
     * Returns the information about the storage used.
     * @return the information about the storage used.
     */
    @Override
    public HashMap<String, Integer> storageInfo() {
        return new HashMap<>() {{
            put("Jars", quantity / lollipopsPerJar);
            put("Lollipops", quantity % lollipopsPerJar);
        }};
    }

    /**
     * Returns string representation of the product.
     * @return string representation of the product.
     */
    @Override
    public String toString() {
        return String.format("Lollipop: %s ,Taste: %s, price: %d",
                name,
                taste.name(),
                price);
    }
}
