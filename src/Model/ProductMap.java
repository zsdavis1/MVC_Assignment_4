package Model;

import java.util.HashMap;
import java.util.Map;

public class ProductMap {
    private final Map<Integer, String []> products;
    private int increment;

    public ProductMap() {
        products = new HashMap<>();
        increment = 1;
    }

    public int getProductCount() {
        return products.size();
    }

    public HashMap<Integer, String[]> getProducts() {
        return new HashMap<>(products);
    }

}
