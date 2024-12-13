import Pets.*;

import java.util.ArrayList;
import java.util.List;

public class PetsForSaleList {
    private List<Pet> petsForSale = new ArrayList<>();

    public void addPetForSale(Pet pet) {
        petsForSale.add(pet);
    }

    public void sellPet(Pet pet, Date saleDate, double price, double finalPrice, SalesList salesList) {
        if (petsForSale.contains(pet)) {
            petsForSale.remove(pet); // Remove the pet from the list of pets for sale
            Sale sale = new Sale(saleDate, price, finalPrice); // Create a sale
            salesList.addSale(sale); // Add the sale to the sales list
            System.out.println("Pets.Pet sold: " + pet);
        } else {
            System.out.println("Pets.Pet not available for sale.");
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