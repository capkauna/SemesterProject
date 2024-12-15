package Data;

import java.util.Objects;

public class Rodent extends Pet {
    private String species;
    private boolean bites; // can be a String for additional context (e.g., "Yes, occasionally") That can be added to comments section

    public Rodent(String name, String gender, double age, String color, String comments, String photoUrl, boolean forSale, String ownerName, String species, boolean bites) {
        super(name,gender,age,color,comments,photoUrl,forSale,ownerName);
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
        Rodent rodents = (Rodent) o;
        return bites == rodents.bites && Objects.equals(getSpecies(),
            rodents.getSpecies());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getSpecies(), bites);
    }
}