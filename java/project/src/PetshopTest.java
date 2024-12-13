import Pets.Date;
import Pets.Pet;

public class PetshopTest {
    public static void main(String[] args) {
        CustomerList customerList = new CustomerList();
        PetList petList = new PetList();
        PetsForSaleList petsForSaleList = new PetsForSaleList();
        SalesList salesList = new SalesList();

        // Add customer
        Customer customer = new Customer("John Doe", "123456789", "john@example.com", "123 Elm Street");
        customerList.addCustomer(customer);

        // Add pets
        Pet pet = new Cat("Buddy", "Male", 2, "Brown", "Friendly dog", 500.0, "photo.jpg", "breed", "breeder");
        petList.addPet(pet);
        petsForSaleList.addPetForSale(pet); // Add to pets for sale list

        // Display pets for sale
        System.out.println("Pets for Pets.Sale: " + petsForSaleList);

        // Sell a pet
        Date saleDate = new Date(13, 12, 2024);
        petsForSaleList.sellPet(pet, saleDate, salesList);

        // Display sales and remaining pets for sale
        System.out.println("Sales: " + salesList);
        System.out.println("Remaining Pets for Pets.Sale: " + petsForSaleList);
    }
}