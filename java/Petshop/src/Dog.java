public class Dog extends Pet {
    private String breed;
    private String breeder;

    public Dog(String name, String gender, int age, String color, String comments, double price, String photo, String breed, String breeder) {
        super(name, gender, age, color, comments, price, photo);
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
}