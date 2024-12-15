package Data;

public class PetshopTest {
    public static void main(String[] args) {
        CustomerListContainer customerList = new CustomerListContainer();
        PetListContainer petList = new PetListContainer();
        PetsForSaleList petsForSaleList = new PetsForSaleList();
        SalesList salesList = new SalesList();

        // Add customer
        Customer customer = new Customer("John Doe", "123456789", "john@example.com", "123 Elm Street");
        customerList.addCustomer(customer);

        // Add pets
        Pet pet = new Cat("Fluffy", "Female", 2.5, "White", "A fluffy white cat", null, true, "John Doe", "Siamese", "Fish");
        petList.addPet(pet);
        petsForSaleList.addPetForSale(pet); // Add to pets for sale list

        // Display pets for sale
        System.out.println("Pets for Pets.Sale: " + petsForSaleList);

        // Sell a pet
        Date saleDate = new Date(13, 12, 2024);
        petsForSaleList.sellPet(pet, saleDate, 100.0, salesList, customer);

        // Display sales and remaining pets for sale
        System.out.println("Sales: " + salesList);
        System.out.println("Remaining Pets for Pets.Sale: " + petsForSaleList);
    }
}