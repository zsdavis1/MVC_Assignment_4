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
}
