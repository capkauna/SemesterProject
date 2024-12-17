package Data;
import java.util.ArrayList;

public class CustomerListContainer
{
  private ArrayList<Customer> customers;

  public CustomerListContainer() {
    this.customers = new ArrayList<>();
  }

  public CustomerListContainer(ArrayList<Customer> customers) {
    this.customers = customers;
  }

  public Customer getCustomer(int index) {
    if (index < 0 || index >= customers.size()) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    return customers.get(index);
  }

  public Customer getCustomer(String name) {
    for (Customer customer : customers) {
      if (customer.getName().equals(name)) {
        return customer;
      }
    }
    return null;
  }

  public void addCustomer(Customer customer) {
    if (customer == null) {
      throw new IllegalArgumentException("Customer cannot be null");
    }
    customers.add(customer);
  }

  public void cancelCustomer(int index) {
    if (index < 0 || index >= customers.size()) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    customers.remove(index);
  }

  public ArrayList<Customer> getAllCustomers() {
    return customers;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    CustomerListContainer that = (CustomerListContainer) obj;
    return customers.equals(that.customers);
  }

  @Override
  public String toString() {
    return "CustomerList{" + "customers=" + customers + '}';
  }
}
