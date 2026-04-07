package Model.Sale;

import Model.Product.Product;
import Model.Product.ProductMap;

public class Sale {
    private final String saleId;
    private final String customerId;
    private final String productId;
    private final int quantity;

    public Sale (String saleId, String customerId, String productId, int quantity) {
        if (customerId == null || customerId.isEmpty() || productId == null || productId.isEmpty()
                || saleId == null || saleId.isEmpty() || quantity <= 0) {
            throw new IllegalArgumentException("Invalid sale data.");
        }

        this.saleId = saleId;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getSaleId() {
        return saleId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal(ProductMap products) {
        double price = products.getProductPrice(productId);
        return price * quantity;
    }
}
