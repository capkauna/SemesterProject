package Main;
import java.util.Objects;

public class Sale {
    private Date saleDate;
    private double price;
    private double finalPrice;
    private boolean isSold;

    //sold pet constructor for Main.SalesList use only
    public Sale(Date saleDate,double price, double finalPrice) {
        if (saleDate == null)
        {
            throw new IllegalArgumentException("Please add date.");
        }
        validatePrice(price);
        validatePrice(finalPrice);
        this.saleDate = saleDate;
        this.price = price;
        this.finalPrice = finalPrice;
        this.isSold = true; //mark as sold for clear separation
    }


    //pet waiting to be sold
    public Sale(double price) {
        validatePrice(price);
        this.price = price;
        this.isSold = false;
    }

    //general validation method
    private void validatePrice(double price){
        if(price <=0)
        {
            throw new IllegalArgumentException("Price invalid");
        }
    }

    //set the sale complete and save the data
    public void markAsSold(Date saleDate, double finalPrice)
    {
        if(saleDate == null)
        {
            throw new IllegalArgumentException("Please add a date.");
        }
        validatePrice(finalPrice);
        this.saleDate = saleDate;
        this.finalPrice = finalPrice;
        this.isSold = true;
    }

    public Date getSaleDate() {
        if (!isSold)
        {
            throw new IllegalStateException("No sale data found.");
        }
        return saleDate;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getFinalPrice() {
        if (!isSold)
        {
            throw new IllegalStateException("Final price not found.");
        }
        return finalPrice;}

    public boolean isSold()
    {
        return isSold;
    }


/* to avoid bypassing markAsSold, these should not be used
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    public void setFinalPrice(double finalPrice) {
        validatePrice(finalPrice);
        this.finalPrice = finalPrice;
    }
 */

    @Override
    public String toString() {
        if (isSold){
        return "Sale{saleDate=" + saleDate + ", price: " + price + ", finalPrice=" + finalPrice + '}';}
        else{
            return "Price: " + price + ", for sale.";
        }
    }

    @Override public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass())
            return false;
        Sale sale = (Sale) o;
        return Double.compare(getPrice(), sale.getPrice()) == 0
            && Double.compare(getFinalPrice(), sale.getFinalPrice()) == 0
            && isSold() == sale.isSold() && Objects.equals(getSaleDate(),
            sale.getSaleDate());
    }

    @Override public int hashCode()
    {
        return Objects.hash(getSaleDate(), getPrice(), getFinalPrice(),
            isSold());
    }
}