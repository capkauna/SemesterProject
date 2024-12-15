package Data;

public class Booking {
  private DateInterval dateInterval;
  private Pet pet;
  private Customer customer; 
  private double pricePerDay;
  
  public Booking(Date startDate , Date endDate, Pet pet, Customer customer, double pricePerDay) {
    this.dateInterval = new DateInterval(startDate,endDate);
    this.pet = pet;
    this.customer = customer;
    this.pricePerDay = pricePerDay;
  }

  public Date getStartDate() {
    return dateInterval.getStartDate();
  }

  public Date getEndDate() {
    return dateInterval.getEndDate();
  }

  public double getPricePerDay() {
    return pricePerDay;
  }

  public Pet getPet() {
    return pet;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setStartDate(Date startDate) {
    dateInterval.setStartDate(startDate);
  }

  public void setEndDate(Date endDate) {
    dateInterval.setEndDate(endDate);
  }

  public void setPricePerDay(double pricePerDay) {
    this.pricePerDay = pricePerDay;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public int numberOfDays() {
    return dateInterval.numberOfDays();
  }

  public double totalPrice() {
    return numberOfDays() * pricePerDay;
  }

  @Override
  public String toString() {
    return "Main.Booking for " + pet + " by " + customer + ", Total Price: " + totalPrice();
  }
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Booking booking = (Booking) obj;
    return Double.compare(booking.pricePerDay, pricePerDay) == 0 &&
      dateInterval.equals(booking.dateInterval) &&
        pet.equals(booking.pet) &&
        customer.equals(booking.customer);
  }
}










