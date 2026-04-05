package Model;

public class Sale {
    private final String customerId;
    private final String productId;
    private final int quantity;
    private double total;

    public Sale (String customerId, String productId, int quantity) {
        if (customerId == null || customerId.isEmpty() || productId == null || productId.isEmpty() || quantity <= 0) {
            throw new IllegalArgumentException("Invalid sale data.");
        }

        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
