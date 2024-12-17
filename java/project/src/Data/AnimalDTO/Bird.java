package Data.AnimalDTO;

import Data.Gender;

import java.util.Objects;

public class Bird extends Pet {
    private String species;
    private String preferredFood;

    public Bird(String name, Gender gender, double age, String color, String comments, String photoUrl, boolean forSale, String ownerName, String species, String preferredFood) {
        super(name,gender,age,color,comments,photoUrl,forSale,ownerName);
        if (species == null)
        {
            throw new IllegalArgumentException("Please add species information");
        }
        if (preferredFood == null)
        {
            throw new IllegalArgumentException("Please add food information");
        }
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

    @Override public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass())
            return false;
        Bird bird = (Bird) o;
        return Objects.equals(getSpecies(), bird.getSpecies())
            && Objects.equals(getPreferredFood(), bird.getPreferredFood());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getSpecies(), getPreferredFood());
    }
}