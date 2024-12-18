package Data;

import Data.AnimalDTO.Date;
import Data.AnimalDTO.Pet;

import java.awt.print.Book;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookingsList {

    // Inner class to encapsulate a boooking with pet and booker details, for storage purposes
    public static class BookingRecord implements Serializable
    {
        private Pet pet;
        private Customer booker;
        private Booking booking;

        public BookingRecord(Pet pet, Customer booker, Booking booking) {
            this.pet = pet;
            this.booker = booker;
            this.booking = booking;
        }

        public Pet getPet() {
            return pet;
        }

        public Customer getBooker() {
            return booker;
        }

        public Booking getBooking() {
            return booking;
        }

        @Override
        public String toString() {
            return "BookingRecord{" +
                    "pet=" + pet.getName() +
                    ", bookerName='" + booker + '\'' +
                    ", booking=" + booking +
                    '}';
        }
    }

    private List<BookingRecord> bookings = new ArrayList<>();

    // Add a completed booking
    public void addBooking(Pet pet, Customer bookerName, DateInterval dateInterval, double pricePerDay, double totalPrice) {
        if (pet == null || bookerName == null || dateInterval == null) {
            throw new IllegalArgumentException("Pet, buyer name, and date Interval must not be null.");
        }

        Booking booking = new Booking(dateInterval, pricePerDay, totalPrice);
        BookingRecord bookingRecord = new BookingRecord(pet, bookerName, booking);
        bookings.add(bookingRecord);

    }

    // Get all sales
    public ArrayList<BookingRecord> getAllBookings() {
        return new ArrayList<BookingRecord>(bookings); // Return a copy to avoid accidental modification
    }

    // Find sales by buyer name
    public List<BookingRecord> findBookingByBooker(String bookerName) {
        List<BookingRecord> result = new ArrayList<>();
        for (BookingRecord record : bookings) {
            if (record.getBooker().getName().equalsIgnoreCase(bookerName)) {
                result.add(record);
            }
        }
        return result;
    }

    // Find sales by pet name
    public List<BookingRecord> findBookingByPetName(String petName) {
        List<BookingRecord> result = new ArrayList<>();
        for (BookingRecord record : bookings) {
            if (record.getPet().getName().equalsIgnoreCase(petName)) {
                result.add(record);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Sales List:\n");
        for (int i = 0; i < bookings.size(); i++) {
            BookingRecord record = bookings.get(i);
            sb.append(i + 1).append(") ")
                    .append("Pet: ").append(record.getPet().getName()).append(", ")
                    .append("Buyer: ").append(record.getBooker()).append(", ")
                    .append("Sale Details: ").append(record.getBooking()).append("\n");
        }
        return sb.toString();
    }

    @Override public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass())
            return false;
        BookingsList bookingsList = (BookingsList) o;
        return Objects.equals(bookings, bookingsList.bookings);
    }

    @Override public int hashCode()
    {
        return Objects.hashCode(bookings);
    }
}
