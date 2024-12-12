import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;



public abstract class Customer extends {
    private String name;
    private String phoneNo;
    private String address;
    private String email;
    private Booking booking;
    private List<Booking> bookings; // Changed to a list
    private Pet pets;


    public Customer(String name, String phoneNo, String address, String email, Booking booking, Pet pets) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
        this.email = email;
        this.bookings = new ArrayList<>(); // Initialize the list
        this.pets = pets;
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

    public Booking getBooking() {
        Booking booking = null;
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    // Add a new booking
    public void addBooking(Booking booking) {
        if (booking != null) {
            bookings.add(booking);
        }
    }

    // Get all bookings
    public List<Booking> getBookings() {
        return new ArrayList<>(bookings); // Return a copy to avoid modification
    }

    public Pet getPets() {
        return pets;
    }

    public void setPets(Pet pets) {
        this.pets = pets;
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
            ", bookings=" + bookings +
            ", pets=" + pets +
            '}';
    }
}
}
