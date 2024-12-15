import Main.*;

import java.util.ArrayList;
import java.util.List;



public class Customer {
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
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", booking=" + booking +
                ", bookings=" + bookings +
                ", pets=" + pets +
                '}';
    }


}

