package Controller;

import Model.Customer.Customer;
import Model.Customer.CustomerMap;
import Model.Product.ProductMap;
import Model.Sale.SaleList;

import java.util.HashMap;

public class CornerStoreController {
    private final CustomerMap customers;
    private final ProductMap products;
    private final SaleList sales;

    public CornerStoreController() {
        this.customers = new CustomerMap();
        this.products = new ProductMap();
        this.sales = new SaleList(customers, products);
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
}
