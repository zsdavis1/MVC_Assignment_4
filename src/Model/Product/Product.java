package Model.Product;

public class Product {
    private final String name;
    private final String price;
    private String quantity;

    public Product(String name, String price, String quantity) {
        if (name == null || price == null || quantity == null) {
            throw new IllegalArgumentException("Name, price, or quantity cannot be null");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
