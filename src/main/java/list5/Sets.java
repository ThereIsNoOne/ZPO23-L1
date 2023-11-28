package list5;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class providing static methods for sets operations.
 */
public final class Sets {

    /**
     * Private constructor to prevent initialization of this class.
     */
    private Sets() { }

    /**
     * Performs a union operation on given sets.
     * @param first first set to union.
     * @param second second set to union.
     * @return union of first and second set.
     */
    public static Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>() {{
            addAll(first);
        }};
        result.addAll(second);
        return result;
    }

    /**
     * Performs a difference operation on given sets.
     * @param first first set to difference.
     * @param second second set to difference.
     * @return difference of first and second set.
     */
    public static Set<Integer> difference(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>() {{
            addAll(first);
        }};
        result.removeAll(second);
        return result;
    }

    /**
     * Perform an intersection operation on given sets.
     * @param first first set to intersect.
     * @param second second set to intersect.
     * @return intersection of given sets.
     */
    public static Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>() {{
            addAll(first);
        }};
        result.retainAll(second);
        return result;
    }

    /**
     * Performs a symmetric difference operation on given sets.
     * @param first first set to symmetric difference.
     * @param second second set to symmetric difference.
     * @return symmetric difference of given sets.
     */
    public static Set<Integer> symmetricDifference(Set<Integer> first,
                                                   Set<Integer> second) {
        return difference(union(first, second), intersection(first, second));
    }
}
