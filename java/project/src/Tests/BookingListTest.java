package Tests;

import Data.*;
import Data.AnimalDTO.*;

public class BookingListTest {
    public static void main(String[] args) {
        // Test data setup

        Customer customer1 = new Customer("John Doe", "123456789", "Address 99, Horsens", "john@john.dk");
        Customer customer2 = new Customer("Jane Smith", "987654321", "Address 100, Horsens", "jane@jane.dk");

        Date startDate1 = new Date(2023 - 1900, 11, 1); // December 1, 2023
        Date endDate1 = new Date(2023 - 1900, 11, 5); // December 5, 2023

        Date startDate2 = new Date(2023 - 1900, 11, 10); // December 10, 2023
        Date endDate2 = new Date(2023 - 1900, 11, 15); // December 15, 2023

        Pet pet1 = new Dog("Rex", Gender.MALE, 5.0, "Brown", "Friendly", "photo.jpg", false, "John Doe", "Golden Retriever", "Breeder 1");
        Pet pet2 = new Cat("Whiskers", Gender.FEMALE, 3.0, "White", "Playful", "photo.jpg", false, "Jane Smith", "Siamese", "Breeder 2");

        Booking booking1 = new Booking(new DateInterval(startDate1, endDate1), pet1, customer1, 50.0, 200.0);
        Booking booking2 = new Booking(new DateInterval(startDate2, endDate2), pet2, customer2, 40.0, 400.0);

        // Create Main.BookingList
        BookingListContainer bookingList = new BookingListContainer(2);

        // Test: Add bookings
        System.out.println("Adding booking 1:");
        bookingList.addBooking(booking1);
        System.out.println("Occupied Cages: " + bookingList.getOccupiedCages());

        System.out.println("Adding booking 2:");
        bookingList.addBooking(booking2);
        System.out.println("Occupied Cages: " + bookingList.getOccupiedCages());


        // Test: Get booking
        System.out.println("\nGet booking at index 1:");
        System.out.println(bookingList.getBooking(1));

        // Test: Available cages
        System.out.println("\nAvailable cages:");
        System.out.println(bookingList.availableCages());

        // Test: Cancel a booking
        System.out.println("\nCancelling booking at index 0:");
        bookingList.cancelBooking(0);
        System.out.println("Occupied Cages: " + bookingList.getOccupiedCages());

        // Test: Get all bookings
        System.out.println("\nAll bookings:");
        for (Booking b : bookingList.getAllBookings()) {
            System.out.println(b);
        }

        // Test: toString method
        System.out.println("\nMain.BookingList toString:");
        System.out.println(bookingList);

        // Test: Equals method
        BookingListContainer bookingList2 = new BookingListContainer(2);
        bookingList2.addBooking(booking1);
        bookingList2.addBooking(booking2);
        System.out.println("\nMain.BookingList equals test:");
        System.out.println(bookingList.equals(bookingList2)); // Should be false due to cancellations
    }
}

