package list3.interfaceimplementation;

/**
 * Forces class to have discount related methods.
 */
public interface Discountable {

    /**
     * Applies the discount.
     * @param percentage percentage of the discount (1% -> 0.01).
     */
    void discount(double percentage);

    /**
     * Removes the discount.
     */
    void removeDiscount();
}
