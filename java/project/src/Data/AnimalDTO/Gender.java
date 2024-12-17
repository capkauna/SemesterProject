package Data.AnimalDTO;

public enum Gender {
  MALE("Male"),
  FEMALE("Female"),
  UNDEFINED("Undefined");

  private final String displayName;

  Gender(String displayName) {
    this.displayName = displayName;
  }

  @Override
  public String toString() {
    return displayName;
  }
}