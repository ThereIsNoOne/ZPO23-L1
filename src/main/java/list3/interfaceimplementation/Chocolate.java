package list3.interfaceimplementation;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents chocolate product.
 */
public class Chocolate implements Product, Discountable {

    private final String name;
    private int regularPrice = -1;
    private int price;
    private int quantity;
    private final HashMap<String, Integer> ingredients;

    private static final int barsPerPackage = 10;

    /**
     * Initialize chocolate object.
     * @param name name of chocolate.
     * @param price price of chocolate (in 0.01 PLN)
     * @param quantity quantity of chocolate (bars)
     * @param ingredients ingredients of this product, should be all lower case,
     *                    and percentages should sum up to 100.
     * @throws IllegalArgumentException when quantity or price is illegal or
     *                                  percentages of ingredients do not
     *                                  sum up to 100 or are more than 100.
     */
    public Chocolate(String name,
                     int price,
                     int quantity,
                     HashMap<String, Integer> ingredients) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity should be more than 0.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price should be more than 0.");
        }
        if (!checkIngredients(ingredients)) {
            throw new IllegalArgumentException("Percentage should sum up to 100%");
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ingredients = ingredients;
    }

    /**
     * Checks if percentage of ingredients sum up to 100.
     * @param ingredients map of pairs [ingredient name, percentage] to be
     *                    checked.
     * @return true if sums up to 100 otherwise false.
     */
    private static boolean checkIngredients(HashMap<String, Integer> ingredients) {
        int sum = 0;
        for (Map.Entry<String, Integer> ingredient: ingredients.entrySet()) {
            sum += ingredient.getValue();
            if (sum > 100) {
                return false;
            }
        }
        return sum == 100;
    }

    /**
     * Checks if ingredients contains sugar.
     * @return true if contains otherwise false.
     */
    public boolean isWithSugar() {
        return ingredients.containsKey("sugar");
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
     * Returns the information about the storage used.
     * @return the information about the storage used.
     */
    @Override
    public HashMap<String, Integer> storageInfo() {
        HashMap<String, Integer> storageInfoMap = new HashMap<>();
        storageInfoMap.put("Packages", quantity / barsPerPackage);
        storageInfoMap.put("Bars", quantity % barsPerPackage);
        return storageInfoMap;
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
     * Returns string representation of the product.
     * @return string representation of the product.
     */
    @Override
    public String toString() {
        return String.format("Chocolate: %s, price: %d", name, price);
    }
}
