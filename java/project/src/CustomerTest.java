public class CustomerTest
{

  public static void main(String[] args)
  {
    Customer customer = new Customer("Fifi Malaga", "1234567890", "Sonderbro",
        "fifi123@via.dk");



    System.out.println("Customer Name: " + customer.getName());
    System.out.println("Customer Phone: " + customer.getPhoneNo());
    System.out.println("Customer Address: " + customer.getAddress());
    System.out.println("Customer Email: " + customer.getEmail());
    System.out.println("Customer Pets.Pet: " + customer.getPets());

    customer.setName("Fifi Malaga");
    customer.setPhoneNo("1234567890");
    customer.setAddress("Sondebro");
    customer.setEmail("fifi123@via.dk");

  }
}

