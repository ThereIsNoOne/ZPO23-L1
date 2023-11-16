package list5;

import java.util.HashSet;
import java.util.Set;

public final class Sets {

    private Sets() { }

    public static Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>() {{
            addAll(first);
        }};
        result.addAll(second);
        return result;
    }

    public static Set<Integer> difference(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>() {{
            addAll(first);
        }};
        result.removeAll(second);
        return result;
    }

    public static Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>() {{
            addAll(first);
        }};
        result.retainAll(second);
        return result;
    }

    public static Set<Integer> symmetricDifference(Set<Integer> first,
                                                   Set<Integer> second) {
        return difference(union(first, second), intersection(first, second));
    }
}
