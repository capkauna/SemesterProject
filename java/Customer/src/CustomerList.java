
  import java.util.ArrayList;

  public class CustomerList {
    private ArrayList<Customer> customers;

    public CustomerList() {
      this.customers = new ArrayList<>();
    }

    public Customer getCustomer(int index) {
      if (index < 0 || index >= customers.size()) {
        throw new IndexOutOfBoundsException("Invalid index");
      }
      return customers.get(index);
    }

    // Add a customer
    public void addCustomer(Customer customer) {
      if (customer == null) {
        throw new IllegalArgumentException("Customer cannot be null");
      }
      customers.add(customer);
    }

    // Cancel (remove) a customer by index
    public void cancelCustomer(int index) {
      if (index < 0 || index >= customers.size()) {
        throw new IndexOutOfBoundsException("Invalid index");
      }
      customers.remove(index);
    }

    // Get all customers
    public Customer[] getAllCustomer() {
      return customers.toArray(new Customer[0]);
    }

    // Check if this CustomerList equals another object
    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      CustomerList that = (CustomerList) obj;
      return customers.equals(that.customers);
    }

    // Convert to string
    @Override
    public String toString() {
      return "CustomerList{" +
          "customers=" + customers +
          '}';
    }
  }



