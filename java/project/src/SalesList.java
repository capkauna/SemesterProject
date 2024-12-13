import java.util.ArrayList;
import java.util.List;
import Pets.*;

public class SalesList {

    // Inner class to encapsulate a sale with pet and buyer details, for storage purposes
    public static class SaleRecord {
        private Pet pet;
        private String buyerName;
        private Sale sale;

        public SaleRecord(Pet pet, String buyerName, Sale sale) {
            this.pet = pet;
            this.buyerName = buyerName;
            this.sale = sale;
        }

        public Pet getPet() {
            return pet;
        }

        public String getBuyerName() {
            return buyerName;
        }

        public Sale getSale() {
            return sale;
        }

        @Override
        public String toString() {
            return "SaleRecord{" +
                "pet=" + pet.getName() +
                ", buyerName='" + buyerName + '\'' +
                ", sale=" + sale +
                '}';
        }
    }

    private List<SaleRecord> sales = new ArrayList<>();

    // Add a completed sale
    public void addSale(Pet pet, String buyerName, Date saleDate, double price, double finalPrice) {
        if (pet == null || buyerName == null || saleDate == null) {
            throw new IllegalArgumentException("Pet, buyer name, and sale date must not be null.");
        }

        Sale sale = new Sale(saleDate, price, finalPrice);
        SaleRecord saleRecord = new SaleRecord(pet, buyerName, sale);
        sales.add(saleRecord);

        // Update pet's sale information and owner
        pet.markAsSold(saleDate, finalPrice);
        pet.setOwnerName(buyerName);
        pet.addToHistory("Sold to " + buyerName + " on " + saleDate + " for $" + finalPrice);
    }

    // Get all sales
    public List<SaleRecord> getAllSales() {
        return new ArrayList<>(sales); // Return a copy to avoid accidental modification
    }

    // Find sales by buyer name
    public List<SaleRecord> findSalesByBuyer(String buyerName) {
        List<SaleRecord> result = new ArrayList<>();
        for (SaleRecord record : sales) {
            if (record.getBuyerName().equalsIgnoreCase(buyerName)) {
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
                .append("Buyer: ").append(record.getBuyerName()).append(", ")
                .append("Sale Details: ").append(record.getSale()).append("\n");
        }
        return sb.toString();
    }
}
