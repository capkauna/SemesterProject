package Pets;

public class Bird extends Pet {
    private String species;
    private String preferredFood;

    public Bird(String name, String gender, int age, String color, String comments, double price, String photo, String species, String preferredFood) {
        super(name, gender, age, color, comments, price, photo);
        this.species = species;
        this.preferredFood = preferredFood;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPreferredFood() {
        return preferredFood;
    }

    public void setPreferredFood(String preferredFood) {
        this.preferredFood = preferredFood;
    }

    @Override
    public String toString() {
        return super.toString() + ", species='" + species + '\'' + ", preferredFood='" + preferredFood + '\'' + '}';
    }
}