package Pets;

public class Rodents extends Pet {
    private String species;
    private String bites; // can be a String for additional context (e.g., "Yes, occasionally")

    public Rodents(String name, String gender, int age, String color, String comments, double price, String photo, String species, String bites) {
        super(name, gender, age, color, comments, price, photo);
        this.species = species;
        this.bites = bites;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBites() {
        return bites;
    }

    public void setBites(String bites) {
        this.bites = bites;
    }

    @Override
    public String toString() {
        return super.toString() + ", species='" + species + '\'' + ", bites='" + bites + '\'' + '}';
    }
}