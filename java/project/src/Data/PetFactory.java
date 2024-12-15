package Data;

//TODO stil missing data
public class PetFactory
{
  public static Pet createPet(Species species, String name, String gender,
      double age, String color, String comments, String photoUrl,
      boolean forSale, String ownerName)
  {
    return switch (species)
    {
      case Species.DOG ->
          new Dog(name, gender, age, color, comments, photoUrl, forSale,
              ownerName, "Default Breed", "Default Breeder");
      case Species.CAT ->
          new Cat(name, gender, age, color, comments, photoUrl, forSale,
              ownerName, "Default Breed", "Default Breeder");
      case FISH ->
          new Fish(name, gender, age, color, comments, photoUrl, forSale,
              ownerName, "", Fish.WaterType.Saltwater, "Small");
      case BIRD ->
          new Bird(name, gender, age, color, comments, photoUrl, forSale,
              ownerName, "Default Species", "Default Food");
      case RODENTS ->
          new Rodent(name, gender, age, color, comments, photoUrl, forSale,
              ownerName, "Default Species", true);
      case VARIOUS ->
          new Various(name, gender, age, color, comments, photoUrl, forSale,
              ownerName, "Default Species", "Default Food");
      default ->
          throw new IllegalStateException("Unexpected value: " + species);
    };
  }
}
