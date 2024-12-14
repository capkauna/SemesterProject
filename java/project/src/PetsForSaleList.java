import Main.*;
import java.util.ArrayList;
import java.util.List;

public class PetsForSaleList {
    private List<Pet> petsForSale = new ArrayList<>();


    public void addPetForSale(Pet pet) {
        if (pet.isForSale()) {
            petsForSale.add(pet);
        } else {
            System.out.println("Pet is not marked for sale and cannot be added to the for-sale list.");
        }
    }

    // Sell a pet
    public void sellPet(Pet pet, Customer buyer, Date saleDate, Sale sale, SalesList sales, double price, double finalPrice) {
        if (petsForSale.contains(pet)) {
            // Mark the pet as sold
            try {
                // Remove the pet from the for-sale list
                petsForSale.remove(pet);

                // Add the sale to the SalesList
                sales.addSale(pet, buyer, saleDate, price, finalPrice, sale);

                System.out.println("Pet sold: " + pet);
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("Error selling pet: " + e.getMessage());
            }
        } else {
            System.out.println("Pet is not available in the for-sale list.");
        }
    }

    // Get all pets currently for sale
    public List<Pet> getPetsForSale() {
        return petsForSale;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pets For Sale:\n");
        for (int i = 0; i < petsForSale.size(); i++) {
            sb.append(i + 1).append(". ").append(petsForSale.get(i)).append("\n");
        }
        return sb.toString();
    }
}
