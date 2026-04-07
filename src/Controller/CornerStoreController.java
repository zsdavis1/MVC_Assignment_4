package Controller;

import Model.Customer.CustomerMap;
import Model.Product.ProductMap;
import Model.Sale.Sale;
import Model.Sale.SaleList;

import java.util.ArrayList;
import java.util.HashMap;

public class CornerStoreController {
    private final CustomerMap customers;
    private final ProductMap products;
    private final SaleList sales;

    public CornerStoreController() {
        this.customers = new CustomerMap();
        this.products = new ProductMap();
        this.sales = new SaleList(customers, products);

        // ADDING PRE-FILLED INFORMATION
        // Matches the original, monolithic code
        customers.addCustomer("Alice", "alice@example.com");
        customers.addCustomer("Bob", "bob@example.com");
        customers.addCustomer("Charlie", "charlie@example.com");

        products.addProduct("Laptop", "1200.00", "10");
        products.addProduct("Mouse", "25.50", "50");
        products.addProduct("Keyboard", "75.00", "30");
        products.addProduct("Monitor", "300.75", "20");
    }

    // Customer specific methods
    public boolean addCustomer(String name, String email) {
        return customers.addCustomer(name, email);
    }

    public boolean customerExists(String customerId) {
        return customers.customerExists(customerId);
    }

    public int getCustomerCount() {
        return customers.getCustomerCount();
    }

    public HashMap<Integer, String []> getCustomers() {
        return customers.getCustomers();
    }

    // Product specific methods
    public boolean addProduct(String name, String price, String quantity) {
        return products.addProduct(name, price, quantity);
    }

    public boolean productExists(String productId) {
        return products.productExists(productId);
    }

    public int getProductCount() {
        return products.getProductCount();
    }

    public HashMap<Integer, String[]> getProducts() {
        return products.getProducts();
    }

    // Sale specific methods
    public boolean addSale(String customerId, String productId, int quantity) {
        return sales.addSale(customerId, productId, quantity);
    }

    public ArrayList<Sale> getSales() {
        return sales.getSales();
    }

    public double getSaleTotal(String productId, int quantity) {
        double price = products.getProductPrice(productId);
        return price * quantity;
    }
}
