package list3.interfaceimplementation;

import java.util.HashMap;

public class Lollipop implements Product, Discountable{
    private String name;
    private int quantity;
    private int price;
    private int regularPrice;
    private Taste taste;

    private static final int lollipopsPerJar = 25;

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

    public boolean isFruity() {
        return taste.fruity;
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
            put("Jars", quantity / lollipopsPerJar);
            put("Lollipops", quantity % lollipopsPerJar);
        }};
    }

    @Override
    public String toString() {
        return String.format("Lollipop: %s ,Taste: %s, price: %d",
                name,
                taste.name(),
                price);
    }
}
