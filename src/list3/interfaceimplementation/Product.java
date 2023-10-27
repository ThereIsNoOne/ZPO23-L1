package list3.interfaceimplementation;

import java.util.HashMap;

public interface Product {

    String getName();
    int getPrice();
    int getQuantity();

    void setQuantity(int newQuantity);
    void setPrice(int newPrice);

    HashMap<String, Integer> storageInfo();
}
