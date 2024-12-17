package Data.AnimalDTO;

import java.util.Objects;

public class Dog extends Pet {
    private String breed;
    private String breeder;

    public Dog(String name, String gender, double age, String color, String comments, String photoUrl, boolean forSale, String ownerName, String breed, String breeder) {
        super(name,gender,age,color,comments,photoUrl,forSale,ownerName);
        if (breed == null){
            throw new IllegalArgumentException("Please add breed information");
        }
        this.breed = breed;
        this.breeder = breeder;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreeder() {
        return breeder;
    }

    public void setBreeder(String breeder) {
        this.breeder = breeder;
    }

    @Override
    public String toString() {
        return super.toString() + ", breed='" + breed + '\'' + ", breeder='" + breeder + '\'' + '}';
    }

    @Override public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass())
            return false;
        Dog dog = (Dog) o;
        return Objects.equals(getBreed(), dog.getBreed()) && Objects.equals(
            getBreeder(), dog.getBreeder());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getBreed(), getBreeder());
    }
}