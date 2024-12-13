package Pets;

import javafx.scene.image.Image;

import java.awt.*;

public class Bird extends Pet {
    private String species;
    private String preferredFood;

    public Bird(String name, String gender, double age, String color, String comments, Image photo, boolean forSale, String ownerName, String species, String preferredFood) {
        super(name,gender,age,color,comments,photo,forSale,ownerName);
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
}