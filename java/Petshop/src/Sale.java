public class Sale {
    private Date saleDate;
    private double finalPrice;
    private Pet pet;

    public Sale(Date saleDate, double finalPrice, Pet pet) {
        this.saleDate = saleDate;
        this.finalPrice = finalPrice;
        this.pet = pet;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Sale{saleDate=" + saleDate + ", finalPrice=" + finalPrice + ", pet=" + pet + '}';
    }
}