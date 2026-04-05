package Model.Customer;

public class Customer {
    private final String name;
    private final String email;

    public Customer(String name, String email) {
        if (name == null || email == null) {
            throw new IllegalArgumentException("Name and/or email cannot be null.");
        }

        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
