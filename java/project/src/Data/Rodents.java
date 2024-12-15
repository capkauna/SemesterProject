package Data;

import javafx.scene.image.Image;

import java.util.Objects;

public class Rodents extends Pet {
    private String species;
    private boolean bites; // can be a String for additional context (e.g., "Yes, occasionally") That can be added to comments section

    public Rodents(String name, String gender, double age, String color, String comments, Image photo, boolean forSale, String ownerName, String species, boolean bites) {
        super(name,gender,age,color,comments,photo,forSale,ownerName);
        this.species = species;
        this.bites = bites;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public boolean isBitesBites() {
        return bites;
    }

    public void setBites(boolean bites) {
        this.bites = bites;
    }

    @Override
    public String toString() {
        return super.toString() + ", species: " + species + ", bites: " + (bites ? "Yes" : "No" );
    }

    @Override public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass())
            return false;
        Rodents rodents = (Rodents) o;
        return bites == rodents.bites && Objects.equals(getSpecies(),
            rodents.getSpecies());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getSpecies(), bites);
    }
}