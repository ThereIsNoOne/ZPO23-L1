package list3.interfaceimplementation;

import java.util.HashMap;
import java.util.Map;

public class Chocolate implements Product, Discountable{

    private String name;
    private int regularPrice = -1;
    private int price;
    private int quantity;
    private final HashMap<String, Integer> ingredients;

    private static final int barsPerPackage = 10;

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

    public boolean isWithSugar() {
        return ingredients.containsKey("sugar");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void discount(double percentage) {
        if (percentage < 0 || percentage > 1) {
            throw new IllegalArgumentException("Discount should be 0.0 and 1.0");
        }
        regularPrice = price;
        price = (int) ((1 - percentage) * price);
    }

    @Override
    public void setQuantity(int newQuantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity should be more than 0.");
        }
        quantity = newQuantity;
    }

    @Override
    public void removeDiscount() {
        if (regularPrice == -1) {
            throw new IllegalArgumentException("There is no discount given");
        }
        price = regularPrice;
        regularPrice = -1;
    }

    @Override
    public HashMap<String, Integer> storageInfo() {
        HashMap<String, Integer> storageInfoMap = new HashMap<>();
        storageInfoMap.put("Packages", quantity / barsPerPackage);
        storageInfoMap.put("Bars", quantity % barsPerPackage);
        return storageInfoMap;
    }

    @Override
    public void setPrice(int price) {
        if (price > 0) {
            throw new IllegalArgumentException("Price should be more than 0");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Chocolate: %s, price: %d", name, price);
    }
}
