import Main.Customer;

public class CustomerTest
{

  public static void main(String[] args)
  {
    Customer customer = new Customer("Fifi Malaga", "1234567890", "Sonderbro", "fifi123@via.dk");



    System.out.println("Main.Customer Name: " + customer.getName());
    System.out.println("Main.Customer Phone: " + customer.getPhoneNo());
    System.out.println("Main.Customer Address: " + customer.getAddress());
    System.out.println("Main.Customer Email: " + customer.getEmail());
    System.out.println("Main.Customer Main.Booking: " + customer.getBookings());
    System.out.println("Main.Customer Pets.Pet: " + customer.getPets());

    customer.setName("Fifi Malaga");
    customer.setPhoneNo("1234567890");
    customer.setAddress("Sondebro");
    customer.setEmail("fifi123@via.dk");

  }
}

