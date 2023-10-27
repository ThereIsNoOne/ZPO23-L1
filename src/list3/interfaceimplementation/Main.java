package list3.interfaceimplementation;

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
                1_200_921);

        Lollipop lollipop = new Lollipop("Chupa-Chups",
                3067,
                250,
                Taste.APPLE);

        System.out.println(turbo.storageInfo());
        System.out.println(lollipop.storageInfo());
    }
}
