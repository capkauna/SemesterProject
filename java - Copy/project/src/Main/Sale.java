package Main;

public class Sale {
    private Pet pet;
    private Customer buyer;
    private Date saleDate;
    private double price;
    private double finalPrice;
    private boolean isSold;

    //sold pet constructor for SalesList use only
    public Sale(Pet pet, Customer buyer, Date saleDate, double price, double finalPrice) {
        if (saleDate == null)
        {
            throw new IllegalArgumentException("Please add date.");
        }
        validatePrice(price);
        validatePrice(finalPrice);
        this.pet = pet;
        this.buyer = buyer;
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

    public Pet getPet() {return pet; }
    public Customer getBuyer() {return buyer; }
    public double getPrice() {
        return price;
    }
    public void setPet(Pet pet) {this.pet = pet; }
    public void setBuyer(Customer buyer) {this.buyer = buyer; }
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
        return "Sale{" + "pet=" + pet.getName() + ", buyer=" + buyer.getName() +" saleDate: " + saleDate + " price: " + price + ", finalPrice=" + finalPrice + '}';}
        else{
            return "Price: " + price + ", for sale.";
        }
    }

}