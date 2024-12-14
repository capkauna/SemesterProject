import java.util.ArrayList;
import java.util.List;
import Main.*;

public class SalesList {


    private List<Sale> sales = new ArrayList<>();

    public Sale getSale(int index) {
        if (index < 0 || index >= sales.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return sales.get(index);
    }

    // Add a completed sale
    public void addSale(Pet pet, Customer buyer, Date saleDate, double price, double finalPrice, Sale sale) {
        if (pet == null || buyer == null || saleDate == null) {
            throw new IllegalArgumentException("Pet, buyer name, and sale date must not be null.");
        }

        Sale saleInfo = new Sale(pet, buyer, saleDate, price, finalPrice);
        sales.add(sale);

        // Update pet's sale information and owner
        pet.markAsSold(saleDate, finalPrice);
        pet.setOwnerName(buyer.getName());
        pet.addToHistory("Sold to " + buyer.getName() + " on " + saleDate + " for $" + finalPrice);
    }

    // Get all sales
    public List<Sale> getAllSales() {
        return new ArrayList<>(sales); // Return a copy to avoid accidental modification
    }

    // Find sales by buyer name
    public List<Sale> findSalesByBuyer(String buyerName) {
        List<Sale> result = new ArrayList<>();
        for (Sale record : sales) {
            if (record.getBuyer().getName().equalsIgnoreCase(buyerName)) {
                result.add(record);
            }
        }
        return result;
    }

    // Find sales by pet name
    public List<Sale> findSalesByPetName(String petName) {
        List<Sale> result = new ArrayList<>();
        for (Sale record : sales) {
            if (record.getPet().getName().equalsIgnoreCase(petName)) {
                result.add(record);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "SalesList{" +
                "sales=" + sales +
                '}';
    }


}
