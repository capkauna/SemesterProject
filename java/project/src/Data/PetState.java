package Data;

import java.util.Arrays;

public enum PetState
{
  FORSALE("For Sale"),
  OWNED("Owned");

  private final String displayName;

  PetState(String displayName) {
    this.displayName = displayName;
  }

  public static String[] getPetStateDisplayName()
  {
    return Arrays.stream(PetState.values())
        .map(PetState::toString)
        .toArray(String[]::new);  // Convert the List to an Array
  }


  @Override
  public String toString() {
    return displayName;
  }
}
