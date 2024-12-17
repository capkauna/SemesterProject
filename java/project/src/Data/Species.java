package Data;

import java.util.Arrays;

public enum Species {
  CAT("Cat"),
  DOG("Dog"),
  FISH("Fish"),
  BIRD("Bird"),
  RODENTS("Rodents"),
  VARIOUS("Various");

  private final String displayName;

  Species(String displayName) {
    this.displayName = displayName;
  }

  @Override
  public String toString() {
    return displayName;
  }

  public static String[] getSpeciesDisplayNamesList() {
    return Arrays.stream(Species.values())
        .map(Species::toString)
        .toArray(String[]::new);  // Convert the List to an Array
  }
}



