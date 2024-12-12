import java.util.ArrayList;
import java.util.List;

public class PetList {
    private List<Pet> petList = new ArrayList<>();

    public void addPet(Pet pet) {
        petList.add(pet);
    }

    public Pet getPet(int index) {
        return petList.get(index);
    }

    public List<Pet> getAllPets() {
        return petList;
    }

    @Override
    public String toString() {
        return "PetList{" + "allPets=" + petList + '}';
    }
}

