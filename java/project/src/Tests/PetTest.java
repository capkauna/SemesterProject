package Tests;

import Data.AnimalDTO.Date;
import Data.AnimalDTO.Fish;
import Data.AnimalDTO.Pet;
import Data.Customer;
import Data.Gender;
import Data.PetForSaleContainer;

import java.util.ArrayList;

public class PetTest
{
  public static void main(String[] args)
  {
    Pet glubglub = new Fish("Glubglub", Gender.FEMALE, 1, "Fish blue", "A goldfish", "http://cutefish.png", true, "John Doe", "Fish flakes", Fish.WaterType.Saltwater, "Your mom");
    Customer customer = new Customer("Fishlover42", "123456789", "Fish lane 123", "ilovefish@ilovelovefish.fish");
    PetForSaleContainer petForSaleContainer = new PetForSaleContainer(new ArrayList<>());

    glubglub.setForSale(true, 50.0);
    glubglub.markAsSold(new Date(24, 12, 2024), 50.0);

    petForSaleContainer.sellPet(glubglub, new Date(24, 12, 2024), 50.0, null, customer);

    System.out.println("Pet: " + glubglub.getName() + " sold to " + customer.getName() + " for " + glubglub.getSaleInfo().getPrice());
  }
}
