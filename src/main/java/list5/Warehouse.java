package list5;

import list3.abstractimplementation.ChewingGum;
import list3.abstractimplementation.Chocolate;
import list3.abstractimplementation.Lollipop;
import list3.abstractimplementation.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class represents warehouse.
 */
public class Warehouse<T extends Product> {
    private final Map<ProductType, List<T>> products = new HashMap<>() {{
        for (ProductType type: ProductType.values()) {
            put(type, new ArrayList<>());
        }
    }};

    /**
     * Initialize warehouse object.
     * @param products initial map of products in the warehouse. Might be
     *                 extended with {@code addProduct} method or products can be
     *                 removed with {@code removeProduct} method.
     */
    public Warehouse(List<T> products) {
        products.forEach(this::addProductToMap);
    }

    /**
     * Add product to storage map, based on product type.
     * @param product product to be added.
     */
    private void addProductToMap(T product) {
        if (product instanceof Lollipop) {
            products.get(ProductType.LOLLIPOP).add(product);
        } else if (product instanceof Chocolate) {
            products.get(ProductType.CHOCOLATE).add(product);
        } else if (product instanceof ChewingGum) {
            products.get(ProductType.CHOCOLATE).add(product);
        } else {
            products.get(ProductType.UNKNOWN).add(product);
        }
    }

    /**
     * Retrieves products with certain type..
     * @param type type of product
     * @return product at index.
     */
    public List<T> getListOfProducts(ProductType type) {
        return products.get(type);
    }

    /**
     * Adds new product to products list.
     * @param product product to be added.
     */
    public void addProduct(T product) {
        addProductToMap(product);
    }

    /**
     * Removes product from products list.
     * @param product product to be removed.
     */
    public void removeProduct(ProductType type, T product) {
        products.get(type).remove(product);
    }

    /**
     * String representation of warehouse.
     * @return string representation of warehouse.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (ProductType key : products.keySet()) {
            products.get(key).forEach((value) -> builder.append(value.toString()).append("\n"));
        }
        return builder.toString();
    }

}
