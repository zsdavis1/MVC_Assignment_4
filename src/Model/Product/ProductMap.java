package Model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductMap {
    private final Map<Integer, String []> products;
    private int increment;

    public ProductMap() {
        products = new HashMap<>();
        increment = 1;
    }

    public boolean addProduct(String productName, String productPrice, String productQuantity) {
        try {
            Product product = new Product(productName, productPrice, productQuantity);
            products.put(increment, new String[] {productName, productPrice, productQuantity});
            increment++;
            return true;
        }
        catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean productExists(String productId) {
        if (productId == null || productId.length() < 2 || productId.charAt(0) != 'p') {
            return false;
        }

        try {
            int productIdInt = Integer.parseInt(productId.substring(1));
            return products.containsKey(productIdInt);
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public int getProductQuantity(String productId) {
        if (productId == null || productId.length() < 2 || productId.charAt(0) != 'p') {
            return -1;
        }

        try {
            int productIdInt = Integer.parseInt(productId.substring(1));
            String[] item = products.get(productIdInt);

            if (item == null) {
                return -1;
            }

            return Integer.parseInt(item[2]);
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }

    public boolean updateProductQuantity(String productId, int desiredQuantity) {
        if (productId == null || productId.length() < 2 || productId.charAt(0) != 'p') {
            return false;
        }

        int currentQuantity = getProductQuantity(productId);

        if (currentQuantity == -1 || currentQuantity < desiredQuantity) {
            return false;
        }

        int productIdInt = Integer.parseInt(productId.substring(1));
        String[] item = products.get(productIdInt);

        if (item == null) {
            return false;
        }

        item[2] = Integer.toString(currentQuantity - desiredQuantity);
        return true;
    }

    public double getProductPrice(String productId) {
        if (productId == null || productId.length() < 2 || productId.charAt(0) != 'p') {
            return -1;
        }

        if (!productExists(productId)) {
            return -1;
        }

        int productIdInt = Integer.parseInt(productId.substring(1));
        String[] item = products.get(productIdInt);

        if (item == null) {
            return -1;
        }

        try {
            return Double.parseDouble(item[1]);
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }

    public int getProductCount() {
        return products.size();
    }

    public HashMap<Integer, String[]> getProducts() {
        return new HashMap<>(products);
    }
}
