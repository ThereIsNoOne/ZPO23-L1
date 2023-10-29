package list3.interfaceimplementation;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

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

        Warehouse warehouse = new Warehouse(
                new ArrayList<>() {{
                    add(wedelChocolate);
                    add(lollipop);
                    add(turbo);
                }}
        );

        for (Product product : warehouse) {
            System.out.println(product);
        }

        warehouse.addProduct(milkaChocolate);
        warehouse.removeProduct(wedelChocolate);

        for (Product product : warehouse) {
            System.out.println(product);
            if (product.getClass() == Chocolate.class) {
                System.out.println(((Chocolate) product).isWithSugar());
            } else if (product.getClass() == Lollipop.class) {
                System.out.println(((Lollipop) product).isFruity());
            } else if (product.getClass() == ChewingGum.class) {
                System.out.println(((ChewingGum) product).isBubble());
            } else {
                System.out.printf("Unspecified product class: %s", product.getClass());
            }
        }
    }
}
