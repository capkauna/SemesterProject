package Data;

import Data.AnimalDTO.Date;
import Data.AnimalDTO.Pet;

public class Booking
{
  private DateInterval dateInterval;
  private Pet pet;
  private Customer booker;
  private double pricePerDay;
  private double totalPrice;

  public Booking(DateInterval dateInterval, double pricePerDay,
      double totalPrice)
  {
    this.dateInterval = dateInterval;
    this.pricePerDay = pricePerDay;
    this.totalPrice = totalPrice;
  }

  public Booking(DateInterval dateInterval, Pet pet, Customer booker, double pricePerDay,
      double totalPrice)
  {
    this.dateInterval = dateInterval;
    this.pet = pet;
    this.booker = booker;
    this.pricePerDay = pricePerDay;
    this.totalPrice = totalPrice;
  }

  public Date getStartDate()
  {
    return dateInterval.getStartDate();
  }

  public Date getEndDate()
  {
    return dateInterval.getEndDate();
  }

  public double getPricePerDay()
  {
    return pricePerDay;
  }

  //  public Pet getPet() {
  //    return pet;
  //  }
  //
  //  public Customer getBooker() {
  //    return booker;
  //  }

  public void setStartDate(Date startDate)
  {
    dateInterval.setStartDate(startDate);
  }

  public void setEndDate(Date endDate)
  {
    dateInterval.setEndDate(endDate);
  }

  public void setPricePerDay(double pricePerDay)
  {
    this.pricePerDay = pricePerDay;
  }

  //  public void setPet(Pet pet) {
  //    this.pet = pet;
  //  }
  //
  //  public void setBooker(Customer booker) {
  //    this.booker = booker;
  //  }

  public int numberOfDays()
  {
    return dateInterval.numberOfDays();
  }

  public double totalPrice()
  {
    return numberOfDays() * pricePerDay;
  }

  public double getTotalPrice()
  {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice)
  {
    this.totalPrice = totalPrice;
  }

  @Override public String toString()
  {
    return "Main.Booking for " + pet + " by " + booker + ", Total Price: "
        + totalPrice();
  }

  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Booking booking = (Booking) obj;
    return Double.compare(booking.pricePerDay, pricePerDay) == 0
        && dateInterval.equals(booking.dateInterval) && pet.equals(booking.pet)
        && booker.equals(booking.booker);
  }
}










