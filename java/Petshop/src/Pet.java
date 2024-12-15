public abstract class Pet {
    private String name;
    private char gender;
    private int age;
    private String color;
    private String comments;
    private double price;
    private String photo;

    public Pet(String name, char gender, int age, String color, String comments, double price, String photo) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.color = color;
        this.comments = comments;
        this.price = price;
        this.photo = photo;
    }

    public Pet(char gender, int age, String color, String comments, double price, String photo) {
        this.gender = gender;
        this.age = age;
        this.color = color;
        this.comments = comments;
        this.price = price;
        this.photo = photo;
    }

    public Pet(String name, char gender, int age, String color, String comments, String photo) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.color = color;
        this.comments = comments;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isInPetshop() {
        return price > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Pet pet = (Pet) obj;
        return gender == pet.gender &&
                age == pet.age &&
                Double.compare(pet.price, price) == 0 &&
                name.equals(pet.name) &&
                color.equals(pet.color) &&
                comments.equals(pet.comments) &&
                photo.equals(pet.photo);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", comments='" + comments + '\'' +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                '}';
    }
}
