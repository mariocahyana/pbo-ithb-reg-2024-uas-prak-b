package Model.Model_class;

public class CustomerCheckSession {
    private static CustomerCheckSession instance;
    private Customer customer;

    private CustomerCheckSession() {}

    public static CustomerCheckSession getInstance() {
        if (instance == null) {
            instance = new CustomerCheckSession();
        }
        return instance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void logout() {
        customer = null;
    }
}
