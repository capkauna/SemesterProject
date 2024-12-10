public class Customer {
    private String name;
    private String phoneNo;
    private String address;
    private String email;
    private Booking booking;
    private Pet pets;

    public Customer(String name, String phoneNo, String address, String email, Booking booking, Pet pets) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
        this.email = email;
        this.booking = booking;
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
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Pet getPets() {
        return pets;
    }

    public void setPets(Pet pets) {
        this.pets = pets;
    }
}
