package Pets;

import javafx.scene.image.Image;

public abstract class Pet {
    private String name;
    private String gender;
    private double age;
    private String color;
    private String comments;
    private Image photo;
    private boolean forSale;
    private String ownerName;
    private Sale saleInfo;

    public Pet(String name, String gender, double age, String color, String comments, Image photo, boolean forSale, String ownerName)
    {
        validateAssignment(ownerName,forSale);
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.color = color;
        this.comments = comments;
        this.photo = photo;
        this.forSale = forSale;
        this.ownerName = ownerName;
        this.saleInfo = null;
    }
    //constructor without name
    public Pet(String gender, double age, String color, String comments, Image photo, boolean forSale, String ownerName) {
        this(null, gender,age,color,comments,photo,forSale,ownerName);
    }
    //constructor without photo, has name because petshop pets are the only ones that can be without a name, and those NEED a photo
    public Pet(String name, String gender, double age, String color, String comments, boolean forSale, String ownerName) {
        this(name,gender,age,color,comments,null,forSale,ownerName);
    }
    //handling common condition to assign a pet to either a customer, either for sale
    private void validateAssignment(String ownerName, boolean forSale)
    {
        if (ownerName == null && !forSale) {
            throw new IllegalArgumentException("A pet must either have an owner or be marked for sale.");
        }
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

    public double getAge() {
        return age;
    }
    public void setAge(double age) {
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

    //handling forSale situations
    public boolean isForSale(){
        return forSale;
    }
    public void setForSale(boolean forSale, double price)
    {
        if(forSale){
            if (price <= 0)
            {
                throw new IllegalArgumentException("Price invalid");
            }
            this.forSale = true;
            this.ownerName = null;
            this.saleInfo = new Sale(price);
        } else {
            this.forSale = false;
            this.saleInfo = null;
        }
    }
    public void markAsSold(Date saleDate, double finalPrice){
        if(!forSale || saleInfo == null)
        {
            throw new IllegalStateException("Pet is not for sale.");
        }
        this.saleInfo.markAsSold(saleDate, finalPrice);
        this.forSale = false;
    }
    public Sale getSaleInfo(){
        return saleInfo;
    }

    public Image getPhoto() {
        return photo;
    }
    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    //handling situation where pet has an owner
    public String getOwnerName(){
        return ownerName;
    }
    public void setOwnerName(String ownerName)
    {
        if(ownerName == null || ownerName.isEmpty())
        {
            throw new IllegalArgumentException("Add owner name");
        }
        this.forSale = false;
        this.saleInfo = null;
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pet name: ").append(name)
            .append(", Gender: ").append(gender)
            .append(", Age: ").append(age)
            .append(", Color: ").append(color)
            .append(", Comments: ").append(comments)
            .append(", Photo: ").append(photo != null ? "Available" : "None");

        if (ownerName != null) {
            sb.append(", Owner: ").append(ownerName);
        } else if (forSale) {
            sb.append(", FOR SALE, ").append(saleInfo);
        } else {
            sb.append(", No Owner Assigned (Pet Shop)");
        }

        return sb.toString();
    }
}