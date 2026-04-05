package Model.Sale;

import Model.Customer.CustomerMap;
import Model.Product.ProductMap;

import java.util.ArrayList;

public class SaleList {
    private final ArrayList<Sale> sales;
    private CustomerMap customers;
    private ProductMap products;
    private int increment;

    public SaleList(CustomerMap customers, ProductMap products) {
        sales = new ArrayList<>();
        this.customers = customers;
        this.products = products;
        this.increment = 1;
    }

    public boolean addSale(String customerId, String productId, int quantity) {
        if (!customers.customerExists(customerId)) return false;

        if (!products.productExists(productId)) return false;

        int stock = products.getProductQuantity(productId);
        if (stock < quantity) return false;

        products.updateProductQuantity(productId, quantity);

        String saleId = "s" + increment;

        Sale sale = new Sale(saleId, customerId, productId, quantity);
        sales.add(sale);

        return true;
    }
}
