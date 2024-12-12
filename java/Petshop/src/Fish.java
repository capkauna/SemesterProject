public class Fish extends Pet {
    private String species;
    private String waterType;
    private String possiblePredators;

    public Fish(String name, String gender, int age, String color, String comments, double price, String photo, String species, String waterType, String possiblePredators) {
        super(name, gender, age, color, comments, price, photo);
        this.species = species;
        this.waterType = waterType;
        this.possiblePredators = possiblePredators;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
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
}