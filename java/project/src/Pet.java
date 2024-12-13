public abstract class Pet {
    private String name;
    private String gender;
    private int age;
    private String color;
    private String comments;
    private double price;
    private String photo;

    public Pet(String name, String gender, int age, String color, String comments, double price, String photo) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.color = color;
        this.comments = comments;
        this.price = price;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    @Override
    public String toString() {
        return "Pet{name='" + name + '\'' + ", gender='" + gender + '\'' + ", age=" + age + ", color='" + color + '\'' + ", comments='" + comments + '\'' + ", price=" + price + ", photo='" + photo + '\'' + '}';
    }
}