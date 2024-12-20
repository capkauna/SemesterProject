package Data.AnimalDTO;

import Data.Gender;

import java.io.Serializable;
import java.util.Objects;

public class Cat extends Pet implements Serializable
{
    private String breed;
    private String breeder;

    public Cat(String name, Gender gender, double age, String color, String comments, String photoUrl, boolean forSale, String ownerName, String breed, String breeder) {
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
        Cat cat = (Cat) o;
        return Objects.equals(getBreed(), cat.getBreed()) && Objects.equals(
            getBreeder(), cat.getBreeder());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getBreed(), getBreeder());
    }
}
