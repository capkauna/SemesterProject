package Data;

import java.util.ArrayList;
import java.util.List;

public class BookingListContainer
{
  private int occupiedCages;
  private final int capacity;
  private final List<Booking> allbookings;

  public BookingListContainer(int capacity) {
    this.capacity = capacity;
    this.occupiedCages = 0;
    this.allbookings = new ArrayList<>();
  }

  public int getOccupiedCages() {
    return occupiedCages;
  }

  // Get a booking by index
  public Booking getBooking(int index) {
    if (index >= 0 && index < allbookings.size()) {
      return allbookings.get(index);
    }
    return null;
  }

  // Add a booking
  public void addBooking(Booking booking) {
    if (occupiedCages < capacity) {
      allbookings.add(booking);
      occupiedCages++;
    } else {
      System.out.println("No available cages for booking.");
    }
  }

  public int availableCages() {
    return capacity - occupiedCages;
  }

  // Cancel a booking by index
  public void cancelBooking(int index) {
    if (index >= 0 && index < allbookings.size()) {
      allbookings.remove(index);
      occupiedCages--;
    } else {
      System.out.println("Invalid booking index.");
    }
  }

  // Get all bookings
  public ArrayList<Booking> getAllBookings() {
    return new ArrayList<>(allbookings);
  }

  // Equals method
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    BookingListContainer that = (BookingListContainer) obj;
    return capacity == that.capacity && allbookings.equals(that.allbookings);
  }

  // toString method
  @Override
  public String toString() {
    return "Main.BookingList[occupiedCages=" + occupiedCages + ", capacity=" + capacity + ", allBookings=" + allbookings + ']';
  }
}
