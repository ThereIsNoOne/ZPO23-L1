package list3.abstractimplementation;

import java.util.HashMap;

/**
 * Represents lollipop product.
 */
public class Lollipop extends Product implements Discountable {
    private int regularPrice = -1;
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
        super(name, price, quantity);
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity should be more than 0.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price should be more than 0.");
        }
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
