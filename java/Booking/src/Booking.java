import java.util.Date;

public class Booking {
    private double pricePerDay;

    public Booking(Date startDate, Date endDate, Pet pet, double pricePerDay){
        this.pricePerDay = pricePerDay;
    }

    public Booking()
    {

    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
