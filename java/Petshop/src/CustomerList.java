import java.util.ArrayList;
import java.util.List;

public class CustomerList {
    private List<Customer> allCustomers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        allCustomers.add(customer);
    }

    public Customer getCustomer(int index) {
        return allCustomers.get(index);
    }

    public void cancelCustomer(int index) {
        allCustomers.remove(index);
    }

    public List<Customer> getAllCustomers() {
        return allCustomers;
    }

    @Override
    public String toString() {
        return "CustomerList{" + "allCustomers=" + allCustomers + '}';
    }
}