package Data;

import Data.AnimalDTO.Date;
import Data.AnimalDTO.Pet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SalesList {

    // Inner class to encapsulate a sale with pet and buyer details, for storage purposes
    public static class SaleRecord implements Serializable
    {
        private Pet pet;
        private Customer buyer;
        private Sale sale;

        public SaleRecord(Pet pet, Customer buyer, Sale sale) {
            this.pet = pet;
            this.buyer = buyer;
            this.sale = sale;
        }

        public Pet getPet() {
            return pet;
        }

        public Customer getBuyer() {
            return buyer;
        }

        public Sale getSale() {
            return sale;
        }

        @Override
        public String toString() {
            return "SaleRecord{" +
                "pet=" + pet.getName() +
                ", buyerName='" + buyer + '\'' +
                ", sale=" + sale +
                '}';
        }
    }

    private List<SaleRecord> sales = new ArrayList<>();

    // Add a completed sale
    public void addSale(Pet pet, Customer buyerName, Date saleDate, double price, double finalPrice) {
        if (pet == null || buyerName == null || saleDate == null) {
            throw new IllegalArgumentException("Pet, buyer name, and sale date must not be null.");
        }

        Sale sale = new Sale(saleDate, price, finalPrice);
        SaleRecord saleRecord = new SaleRecord(pet, buyerName, sale);
        sales.add(saleRecord);

        // Update pet's sale information and owner
        pet.markAsSold(saleDate, finalPrice);
        pet.setOwnerName(buyerName.getName());
        pet.addToHistory("Sold to " + buyerName.getName() + " on " + saleDate + " for $" + finalPrice);
    }

    // Get all sales
    public ArrayList<SaleRecord> getAllSales() {
        return new ArrayList<SaleRecord>(sales); // Return a copy to avoid accidental modification
    }

    // Find sales by buyer name
    public List<SaleRecord> findSalesByBuyer(String buyerName) {
        List<SaleRecord> result = new ArrayList<>();
        for (SaleRecord record : sales) {
            if (record.getBuyer().getName().equalsIgnoreCase(buyerName)) {
                result.add(record);
            }
        }
        return result;
    }

    // Find sales by pet name
    public List<SaleRecord> findSalesByPetName(String petName) {
        List<SaleRecord> result = new ArrayList<>();
        for (SaleRecord record : sales) {
            if (record.getPet().getName().equalsIgnoreCase(petName)) {
                result.add(record);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Sales List:\n");
        for (int i = 0; i < sales.size(); i++) {
            SaleRecord record = sales.get(i);
            sb.append(i + 1).append(") ")
                .append("Pet: ").append(record.getPet().getName()).append(", ")
                .append("Buyer: ").append(record.getBuyer()).append(", ")
                .append("Sale Details: ").append(record.getSale()).append("\n");
        }
        return sb.toString();
    }

    @Override public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass())
            return false;
        SalesList salesList = (SalesList) o;
        return Objects.equals(sales, salesList.sales);
    }

    @Override public int hashCode()
    {
        return Objects.hashCode(sales);
    }
}
