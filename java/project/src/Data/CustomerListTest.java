package Data;

public class CustomerListTest {

  public static void main(String[] args) {

CustomerListContainer customerList = new CustomerListContainer();
Customer customer1 = new Customer("Fifi Malaga", "1234567890", "Sonderbro",
    "fifi123@via.dk");
Customer customer2 = new Customer("Gloria Gayana", "3456789234", "IWill Survive", "spoty@via.dk");

    customerList.addCustomer(customer1);
    customerList.addCustomer(customer2);

    System.out.println("All Customers: ");
    for (Customer c : customerList.getAllCustomers()) {
    System.out.println(c);
    }

        System.out.println("Get Main.Customer at Index 1: " + customerList.getCustomer(1));

    customerList.cancelCustomer(0);
    System.out.println("All Customers after removal: ");
    for (Customer c : customerList.getAllCustomers()) {
    System.out.println(c);
    }

        try {
        customerList.getCustomer(5);
    } catch (IndexOutOfBoundsException e) {
    System.out.println("Error: " + e.getMessage());
    }

    try {
    customerList.cancelCustomer(5);
    } catch (IndexOutOfBoundsException e) {
    System.out.println("Error: " + e.getMessage());
    }

    System.out.println("Main.CustomerList toString: " + customerList);
  }
      }

