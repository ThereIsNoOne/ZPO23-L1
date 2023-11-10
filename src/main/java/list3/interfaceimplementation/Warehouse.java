package list3.interfaceimplementation;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Class represents warehouse.
 */
public class Warehouse<T extends Product> implements Iterable<T> {
    private final List<T> products;

    /**
     * Initialize warehouse object.
     * @param products initial list of products in the warehouse. Might be
     *                 extended with {@code addProduct} method or products can be
     *                 removed with {@code removeProduct} method.
     */
    public Warehouse(List<T> products) {
        this.products = products;
    }

    /**
     * Retrieves product at certain index.
     * @param index index of product
     * @return product at index.
     */
    public T get(int index) {
        return products.get(index);
    }

    /**
     * Adds new product to products list.
     * @param product product to be added.
     */
    public void addProduct(T product) {
        products.add(product);
    }

    /**
     * Removes product from products list.
     * @param product product to be removed.
     */
    public void removeProduct(T product) {
        products.remove(product);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return products.iterator();
    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Actions are performed in the order of iteration, if that
     * order is specified.  Exceptions thrown by the action are relayed to the
     * caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side-effects that modify the underlying source of elements, unless an
     * overriding class has specified a concurrent modification policy.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    /**
     * Creates a {@link Spliterator} over the elements described by this
     * {@code Iterable}.
     *
     * @return a {@code Spliterator} over the elements described by this
     * {@code Iterable}.
     * @implSpec The default implementation creates an
     * <em><a href="../util/Spliterator.html#binding">early-binding</a></em>
     * spliterator from the iterable's {@code Iterator}.  The spliterator
     * inherits the <em>fail-fast</em> properties of the iterable's iterator.
     * @implNote The default implementation should usually be overridden.  The
     * spliterator returned by the default implementation has poor splitting
     * capabilities, is unsized, and does not report any spliterator
     * characteristics. Implementing classes can nearly always provide a
     * better implementation.
     * @since 1.8
     */
    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
