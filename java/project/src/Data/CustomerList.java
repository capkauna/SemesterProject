package Data;
import java.util.ArrayList;

public class CustomerList {
  private ArrayList<Customer> customers;

  public CustomerList() {
    this.customers = new ArrayList<>();
  }

  public CustomerList(ArrayList<Customer> customers) {
    this.customers = customers;
  }

  public Customer getCustomer(int index) {
    if (index < 0 || index >= customers.size()) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    return customers.get(index);
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
    CustomerList that = (CustomerList) obj;
    return customers.equals(that.customers);
  }

  @Override
  public String toString() {
    return "CustomerList{" + "customers=" + customers + '}';
  }
}
