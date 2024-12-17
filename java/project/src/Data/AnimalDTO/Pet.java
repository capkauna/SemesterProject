package Data.AnimalDTO;

import Data.Gender;
import Data.Sale;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Pet implements Serializable
{
    private String name;
    private Gender gender;
    private double age;
    private String color;
    private String comments;
    //TODO use photo url for pet picture
    private String photoUrl;
    private boolean forSale;
    private String ownerName;
    private int ownerId; //this would have helped with assosiating pet and owner regardless of name
    private Sale saleInfo;
    private List<String> history = new ArrayList<>();


    public Pet(String name, Gender gender, double age, String color, String comments, String photoUrl, boolean forSale, String ownerName)
    {
        //TODO validate correctly pet state should we add a new input in pet list to determin either
        // Pet is owned or pet is marked for sale/salable?
        validateAssignment(ownerName,forSale);
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.color = color;
        this.comments = comments;
        this.photoUrl = photoUrl;
        this.forSale = forSale;
        this.ownerName = ownerName;
        this.saleInfo = null;
    }
    //constructor without name
    public Pet(Gender gender, double age, String color, String comments, String photoUrl, boolean forSale, String ownerName) {
        this(null, gender,age,color,comments,photoUrl,forSale,ownerName);
    }
    //constructor without photo, has name because petshop pets are the only ones that can be without a name, and those NEED a photo
    public Pet(String name, Gender gender, double age, String color, String comments, boolean forSale, String ownerName) {
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

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
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

    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
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
    //handling history pulled from SaleList (SaleRecord entries)
    public void addToHistory(String event) {
        if (event == null || event.isEmpty()) {
            throw new IllegalArgumentException("Event cannot be null or empty.");
        }
        history.add(event);
    }
    public List<String> getHistory() {
        return new ArrayList<>(history); // Return a copy to avoid external modification
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pet name: ").append(name)
            .append(", Gender: ").append(gender)
            .append(", Age: ").append(age)
            .append(", Color: ").append(color)
            .append(", Comments: ").append(comments)
            .append(", Photo: ").append(photoUrl != null ? "Available" : "None");

        if (ownerName != null) {
            sb.append(", Owner: ").append(ownerName);
        } else if (forSale) {
            sb.append(", FOR SALE, ").append(saleInfo);
        } else {
            sb.append(", No Owner Assigned (Pet Shop)");
        }

        return sb.toString();
    }

    @Override public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass())
            return false;
        Pet pet = (Pet) o;
        return Double.compare(getAge(), pet.getAge()) == 0
            && isForSale() == pet.isForSale() && Objects.equals(getName(),
            pet.getName()) && Objects.equals(getGender(), pet.getGender())
            && Objects.equals(getColor(), pet.getColor()) && Objects.equals(
            getComments(), pet.getComments()) && Objects.equals(getPhotoUrl(),
            pet.getPhotoUrl()) && Objects.equals(getOwnerName(),
            pet.getOwnerName()) && Objects.equals(getSaleInfo(),
            pet.getSaleInfo()) && Objects.equals(getHistory(),
            pet.getHistory());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getName(), getGender(), getAge(), getColor(),
            getComments(), getPhotoUrl(), isForSale(), getOwnerName(),
            getSaleInfo(), getHistory());
    }
}