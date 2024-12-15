import Main.Bird;
import Main.Date;
import Main.Pet;

public class TestClass
{
  public static void main(String[] args)
  {
    Customer customer1 = new Customer("Alex", "61480884", "Undeva 69 Horsens",
        "alex@alex.dk");


    Pet bird = new Bird("Polly", "Female", 2.5, "Green", "A very talkative bird",
        null, true, "Alex", "Parrot", "Seeds");

    bird.setForSale(true, 100);

    bird.markAsSold(new Date(2024, 12, 15), 100);

    customer1.addPet(bird);
  }
}
