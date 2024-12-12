public class Booking {

    private double pricePerDay;

    public Booking(Date startDate, Date endDate, Pet pet, Customer customer, double pricePerDay){
        this.date=date;
        this.endDate=endDate;
        this.pet=pet;
        this.customer=customer;
        this.pricePerDay = pricePerDay;
    }

    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {
        return endDate;
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
        this.startDate=startDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate=endDate;
    }
    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay=pricePerDay
    }
    public void setPet(Pet pet) {
        this.pet=pet
    }
    public void setCustomer(Customer customer) {
        this.customer=customer;
    }
    public int numberOfDays() 
        long diffINMillies = Math.abs(endDate.getTime() - startDate.getTime());
        return (int)
        (diffInMillies / (1000 * 60 * 60 * 24)) ;
    
    public double totalPrice() {
        return numberOfDays() * pricePerDay
    }
    public String toString() {
        return "Booking{" + "startDate=" + startDate + ", endDate=" + endDate + ", pet=" + pet + ",customer=" + customer + ",pricePerDay=" + pricePerDay + '}';
   }
   public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
        Booking booking = (Booking)obj;
        return Double.compare(booking.pricePerDay, pricePerDay) == 0 && 
        Objects.equals(startDate,booking.startDate) &&
        Objects.equals(endDate,booking.endDate) && 
        Objects.equals(pet,booking.pet) &&
        Objects.equals(customer,booking.customer);}
  }



   

