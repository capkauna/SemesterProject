public class Pet {
    private String name;
    private char gender;
    private int age;
    private String color;
    private String comments;
    private double price;
    private double finalPrice;
    private Image photo;

    public Pet(String name, char gender, int age, String color, String comments, int Price, int finalPrice, Image photo){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.color = color;
        this.comments = comments;
        this.price = price;
        this.finalPrice = finalPrice;
        this.photo = photo;
    }

    public Pet(char gender, int age, String color, String comments, double price, double finalPrice, Image photo) {
        this.gender = gender;
        this.age = age;
        this.color = color;
        this.comments = comments;
        this.price = price;
        this.finalPrice = finalPrice;
        this.photo = photo;
    }

    public Pet(String name, char gender, int age, String color, String comments, Image photo) {
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

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
}
