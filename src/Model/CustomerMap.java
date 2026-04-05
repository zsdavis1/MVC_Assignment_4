package Model;

import java.util.HashMap;

public class CustomerMap {
    private final HashMap<Integer, String []> customers;
    private int increment;

    public CustomerMap() {
        customers = new HashMap<>();
        increment = 1;
    }

    public boolean addCustomer(String customerName, String customerAddress) {
        try {
            Customer customer = new Customer(customerName, customerAddress);
            customers.put(increment, new String[]{customerName, customerAddress});
            increment++;
            return true;
        }
        catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean customerExists(String customerId) {
        if (customerId == null || customerId.length() < 2 || customerId.charAt(0) != 'c') {
            return false;
        }

        try {
            int customerIdInt = Integer.parseInt(customerId.substring(1));
            return customers.containsKey(customerIdInt);
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public int getCustomerCount() {
        return customers.size();
    }

    public HashMap<Integer, String []> getCustomers() {
        return new HashMap<>(customers);
    }
}
