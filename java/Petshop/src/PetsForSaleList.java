import java.util.ArrayList;
import java.util.List;

public class PetsForSaleList {
    private List<Pet> petsForSale = new ArrayList<>();

    public void addPetForSale(Pet pet) {
        petsForSale.add(pet);
    }

    public void sellPet(Pet pet, Date saleDate, SalesList salesList) {
        if (petsForSale.contains(pet)) {
            petsForSale.remove(pet); // Remove the pet from the list of pets for sale
            Sale sale = new Sale(saleDate, pet.getPrice(), pet); // Create a sale
            salesList.addSale(sale); // Add the sale to the sales list
            System.out.println("Pet sold: " + pet);
        } else {
            System.out.println("Pet not available for sale.");
        }
    }

    public List<Pet> getPetsForSale() {
        return petsForSale;
    }

    @Override
    public String toString() {
        return "PetsForSaleList{" + "petsForSale=" + petsForSale + '}';
    }
}