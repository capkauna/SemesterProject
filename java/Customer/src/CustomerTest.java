public class CustomerTest
{
  public static void main(String[] args)
  {
    String email = new String();
    Customer customer = new Customer("John Doe", "1234567890", "123 Main St", new Booking(), new Pet());
    System.out.println(customer);

  }
}
