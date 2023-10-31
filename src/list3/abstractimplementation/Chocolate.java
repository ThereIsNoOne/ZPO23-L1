package list3.abstractimplementation;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents chocolate product.
 */
public class Chocolate extends Product implements Discountable {

    private int regularPrice = -1;

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
        super(name, quantity, price);
        if (!checkIngredients(ingredients)) {
            throw new IllegalArgumentException("Percentage should sum up to 100%");
        }

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
        HashMap<String, Integer> storageInfoMap = new HashMap<>();
        storageInfoMap.put("Packages", quantity / barsPerPackage);
        storageInfoMap.put("Bars", quantity % barsPerPackage);
        return storageInfoMap;
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
