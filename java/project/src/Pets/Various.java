package Pets;

public class Various extends Pet {
    private String species;
    private String otherInfo;

    public Various(String name, String gender, int age, String color, String comments, double price, String photo, String species, String otherInfo) {
        super(name, gender, age, color, comments, price, photo);
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
}