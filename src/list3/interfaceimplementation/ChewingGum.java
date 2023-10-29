package list3.interfaceimplementation;

import java.util.HashMap;

/**
 * Represents chewing gum product.
 */
public class ChewingGum implements Product, Discountable {
    private final String name;
    private int price;
    private int regularPrice = -1;
    private int quantity;


    private static final int gumsPerPackages = 30;
    private static final int packagesPerBox = 300;
    private final boolean isBubble;

    /**
     * Initialize the chewing gum product.
     * @param name name of the product.
     * @param price price of the product (inn 0.01 PLN).
     * @param quantity quantity of the product.
     * @param isBubble is the gum bubble or not.
     * @throws IllegalArgumentException if quantity is negative or
     * price is negative.
     */
    public ChewingGum(String name, int price, int quantity, boolean isBubble) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity should be more than 0.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price should be more than 0.");
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isBubble = isBubble;
    }

    /**
     * Checks if it is bubble gum or not.
     * @return true if gum is bubble gum, false otherwise.
     */
    public boolean isBubble() {
        return isBubble;
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
            put("Gums", quantity % gumsPerPackages);
            put("Packages", (quantity / gumsPerPackages) % packagesPerBox);
            put("Boxes", (quantity / gumsPerPackages) / packagesPerBox);
        }};
    }

    /**
     * Returns string representation of the product.
     * @return string representation of the product.
     */
    @Override
    public String toString() {
        return String.format("ChewingGum: %s, price: %d", name, price);
    }
}
