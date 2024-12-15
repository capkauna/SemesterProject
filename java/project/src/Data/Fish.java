package Data;

import javafx.scene.image.Image;

import java.util.Objects;

public class Fish extends Pet {
    private String species;
    private WaterType waterType;
    private String possiblePredators;

    public enum WaterType {
        Freshwater,
        Saltwater
    }

    public Fish(String name, String gender, double age, String color, String comments, String photoUrl, boolean forSale, String ownerName, String species, WaterType waterType, String possiblePredators) {
        super(name,gender,age,color,comments,photoUrl,forSale,ownerName);
        if (waterType == null)
        {
            throw new IllegalArgumentException("Please specify water type");
        }
        this.species = species;
        this.waterType = waterType;
        this.possiblePredators = possiblePredators;
    }

    public void setWaterType(WaterType waterType)
    {
        if (waterType == null)
        {
            throw new IllegalArgumentException("Please specify water type");
        }
        this.waterType = waterType;
    }
    public WaterType getWaterType() {
        return waterType;
    }

    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPossiblePredators() {
        return possiblePredators;
    }
    public void setPossiblePredators(String possiblePredators) {
        this.possiblePredators = possiblePredators;
    }

    @Override
    public String toString() {
        return super.toString() + ", species='" + species + '\'' +
                ", waterType='" + waterType + '\'' +
                ", possiblePredators='" + possiblePredators + '\'' + '}';
    }

    @Override public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass())
            return false;
        Fish fish = (Fish) o;
        return Objects.equals(getSpecies(), fish.getSpecies())
            && getWaterType() == fish.getWaterType() && Objects.equals(
            getPossiblePredators(), fish.getPossiblePredators());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getSpecies(), getWaterType(),
            getPossiblePredators());
    }
}