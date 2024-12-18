package Data;

import Data.AnimalDTO.Pet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Customer implements Serializable
{
    private int id; // good idea for getting the customer even if same name
    private String name;
    private String phoneNo;
    private String address;
    private String email;
    private Booking booking;
    private List<Booking> bookings; // Changed to a list
    private ArrayList <Pet> pets;


    public Customer(String name, String phoneNo, String address, String email) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
        this.email = email;
        this.bookings = new ArrayList<>();
        this.pets = new ArrayList<>();
    }

    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }

    public String getPhoneNo() {

        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {

        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }




    public void addBooking(Booking booking) {
        if (booking != null) {
            bookings.add(booking);
        }
    }


    public List<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    //pets list related methods
    public List<Pet> getPets() {
        return pets;
    }
    public void addPet(Pet pets) {
        pets.setOwnerName(this.name);
        this.pets.add(pets);
    }



    @Override public boolean equals(Object obj)
    {
        return super.equals(obj);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name)
            .append(", Phone No: ").append(phoneNo)
            .append(", Address: ").append(address)
            .append(", Email: ").append(email)
            .append(", Booking: ").append(booking)
            .append(", Bookings: ").append(bookings)
            .append(", Pets: ").append(pets);

        return sb.toString();
    }


}

