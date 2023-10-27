package list3.interfaceimplementation;

import java.util.HashMap;

public class ChewingGum implements Product, Discountable {
    private String name;
    private int price;
    private int regularPrice = -1;
    private int quantity;


    private static final int gumsPerPackages = 30;
    private static final int packagesPerBox = 300;

    public ChewingGum(String name, int price, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity should be more than 0.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price should be more than 0.");
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
    public void setPrice(int price) {
        if (price > 0) {
            throw new IllegalArgumentException("Price should be more than 0");
        }
        this.price = price;
    }

    @Override
    public HashMap<String, Integer> storageInfo() {
        return new HashMap<>() {{
            put("Gums", quantity % gumsPerPackages);
            put("Packages", (quantity / gumsPerPackages) % packagesPerBox);
            put("Boxes", (quantity / gumsPerPackages) / packagesPerBox);
        }};
    }

    @Override
    public String toString() {
        return String.format("ChewingGum: %s, price: %d", name, price);
    }
}
