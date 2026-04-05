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

    public boolean addProduct(String productID, String productName, String productQuantity) {
        try {
            Product product = new Product(productID, productName, productQuantity);
            products.put(increment, new String[] {productID, productName, productQuantity});
            increment++;
            return true;
        }
        catch (IllegalArgumentException e) {
            return false;
        }
    }

    public int getProductCount() {
        return products.size();
    }

    public HashMap<Integer, String[]> getProducts() {
        return new HashMap<>(products);
    }

}
