package Data;

import java.util.Arrays;

public enum Gender {
  MALE("Male"),
  FEMALE("Female"),
  UNDEFINED("Undefined");

  private final String displayName;

  Gender(String displayName) {
    this.displayName = displayName;
  }

  public static String[] getGenderDisplayNamesList()
  {
    return Arrays.stream(Gender.values())
        .map(Gender::toString)
        .toArray(String[]::new);  // Convert the List to an Array
  }


  @Override
  public String toString() {
    return displayName;
  }
}