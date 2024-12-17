package Data.AnimalDTO;

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
}



