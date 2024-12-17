package Data.AnimalDTO;

import Data.Gender;

import java.util.Objects;

public class Various extends Pet {
    private String species;
    private String otherInfo;

    public Various(String name, Gender gender, double age, String color, String comments, String photoUrl, boolean forSale, String ownerName, String species, String otherInfo) {
        super(name,gender,age,color,comments,photoUrl,forSale,ownerName);
        this.species = species;
        this.otherInfo = otherInfo;
    }

    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }

    public String getOtherInfo() {
        return otherInfo;
    }
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return super.toString() + ", species='" + species + '\'' + ", otherInfo='" + otherInfo + '\'' + '}';
    }

    @Override public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass())
            return false;
        Various various = (Various) o;
        return Objects.equals(getSpecies(), various.getSpecies())
            && Objects.equals(getOtherInfo(), various.getOtherInfo());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getSpecies(), getOtherInfo());
    }
}