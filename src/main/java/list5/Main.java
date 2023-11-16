package list5;

import list3.abstractimplementation.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting exercise one demo:\n");
        exerciseOne();
        System.out.println("\nStarting exercise two demo:\n");
        exerciseTwo();
        System.out.println("\nStarting exercise three demo:\n");
        exerciseThree();
    }

    private static void exerciseThree() {
        Subject analysis = new Subject("Mathematical analysis", "Issac Newton", 2, 5, Subject.SubjectType.LECTURE);
        Subject biology = new Subject("Advanced biology", "Gregor Mendel", 1, 3, Subject.SubjectType.EXERCISE);
        Subject analysisA2 = new Subject("Mathematical analysis", "Carl F. Gauss", 3, 10, Subject.SubjectType.LECTURE);

        SubjectStore store = new SubjectStore(new HashMap<>() {{
            put("MA000123W", analysis);
            put("BL00424C", biology);
            put("MA000423W", analysisA2);
        }});

        Subject biologyLab = new Subject("Advanced biology", "Gregor Mendel", 3, 4, Subject.SubjectType.LABORATORY);
        System.out.printf("Subjects:\n%s\n", store);

        store.add("BL000423L", biologyLab);
        System.out.printf("Subjects after addition:\n%s\n", store);

        store.set("BL000423L", new Subject("Advanced microbiology", "Julie Theriot", 3, 5, Subject.SubjectType.LABORATORY));
        System.out.printf("Subjects after change:\n%s\n", store);

        store.remove("BL000423L");
        System.out.printf("Subjects after removal:\n%s\n", store);
    }

    private static void exerciseOne() {
        Set<Integer> integerSetFirst = new HashSet<>() {{
            add(1);
            add(5);
            add(-120);
            add(14);
        }};

        Set<Integer> integerSetSecond = new HashSet<>() {{
            add(1);
            add(3);
            add(120);
            add(14);
        }};

        System.out.printf("A = %s, B = %s, A union B = %s\n",
                integerSetFirst,
                integerSetSecond,
                Sets.union(integerSetFirst, integerSetSecond));

        System.out.printf("A = %s, B = %s, A intersection B = %s\n",
                integerSetFirst,
                integerSetSecond,
                Sets.intersection(integerSetFirst, integerSetSecond));

        System.out.printf("A = %s, B = %s, A difference B = %s\n",
                integerSetFirst,
                integerSetSecond,
                Sets.difference(integerSetFirst, integerSetSecond));

        System.out.printf("A = %s, B = %s, A difference B = %s\n",
                integerSetFirst,
                integerSetSecond,
                Sets.symmetricDifference(integerSetFirst, integerSetSecond));
    }

    private static void exerciseTwo() {

        Chocolate milkaChocolate = new Chocolate("Milka",
                760,
                104,
                new HashMap<>() {{
                    put("sugar", 13);
                    put("cocoa", 17);
                    put("milk", 65);
                    put("palm oil", 5);
                }});

        Chocolate wedelChocolate = new Chocolate("Wedel",
                1200,
                209,
                new HashMap<>() {{
                    put("cocoa", 60);
                    put("milk", 40);
                }});

        ChewingGum turbo = new ChewingGum("Turbo",
                300,
                1_200_921,
                false);

        Lollipop lollipop = new Lollipop("Chupa-Chups",
                3067,
                250,
                Taste.APPLE);

        Warehouse<Product> warehouse = new Warehouse<>(
                Arrays.asList(milkaChocolate, wedelChocolate, turbo, lollipop)
        );

        ChewingGum gumToRemove = new ChewingGum("Gum",
                110,
                1092,
                true);

        System.out.println("Warehouse before adding gum:");
        System.out.println(warehouse);
        warehouse.addProduct(gumToRemove);

        System.out.println("Warehouse after adding gum:");
        System.out.println(warehouse);

        warehouse.removeProduct(ProductType.CHEWING_GUM, gumToRemove);

        System.out.println("Warehouse after removing gum:");
        System.out.println(warehouse);
    }
}
