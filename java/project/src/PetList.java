import Pets.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PetList {

    private List<Pet> petList = new ArrayList<>();

    public void addPet(Pet pet) {
        petList.add(pet);
    }
    public boolean removePet(Pet pet) {
        return petList.remove(pet);
    }

    public Pet getPet(int index) {
        if (index <0 || index >= petList.size())
        {
            throw new IndexOutOfBoundsException("Index " + index + " is invalid.");
        }
        return petList.get(index);
    }

    public List<Pet> getAllPets() {
        return new ArrayList<>(petList); //returning a copy to avoid accidental modification
    }
    public List<Pet> findPetsByName(String name) {
        List<Pet> result = new ArrayList<>();
        for (Pet pet : petList) {
            if (pet.getName() != null && pet.getName().equalsIgnoreCase(name)) {
                result.add(pet);
            }
        }
        return result;
    }


//figured the list would be more useful if it had major information listed only
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pet List:\n");
        for (int i = 0; i < petList.size(); i++) {
            Pet pet = petList.get(i);
            String petType = pet.getClass().getSimpleName();
            String ownerOrSale = pet.getOwnerName() != null ? pet.getOwnerName() : "FOR SALE";

            sb.append(i).append(". ") //list will start from 0 for user-friendly index-finding purposes and less coding
                .append(pet.getName()).append(", ")
                .append(petType).append(", ")
                .append(pet.getGender()).append(", ")
                .append(ownerOrSale)
                .append("\n");
        }
        return sb.toString();
    }

    @Override public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass())
            return false;
        PetList petList1 = (PetList) o;
        return Objects.equals(petList, petList1.petList);
    }

    @Override public int hashCode()
    {
        return Objects.hashCode(petList);
    }
}

