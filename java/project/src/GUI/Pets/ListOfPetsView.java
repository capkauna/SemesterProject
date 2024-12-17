package GUI.Pets;

import Data.AnimalDTO.Pet;
import Data.PetListContainer;
import Helpers.FileHelper;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;

public class ListOfPetsView {
    private final Button backButton;
    private final Button deleteButton;
    private final ListView<String> petListView;
    private PetListContainer listContainer = null;
    private final String fileName = "pets.dat";

    public ListOfPetsView(Pane listOfPetsPane) {
        // Clear and set background
        listOfPetsPane.getChildren().clear();
        listOfPetsPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        // Initialize ListView for pets
        petListView = new ListView<>();
        petListView.setPrefWidth(400);
        petListView.setPrefHeight(300);
        petListView.setStyle("-fx-font-size: 16px;");

        // Initialize back button
        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);

        // Initialize delete button
        deleteButton = new Button("Delete Selected");
        deleteButton.setStyle("-fx-font-size: 16px; -fx-background-color: red; -fx-text-fill: white;");
        deleteButton.setPrefWidth(200);
        deleteButton.setDisable(true); // Initially disable until a pet is selected

        // Add components to the pane
        VBox vbox = new VBox(10, petListView, deleteButton, backButton);
        vbox.setPadding(new Insets(20));
        listOfPetsPane.getChildren().add(vbox);

        // Load initial pet data
        refresh();

        // Enable delete button when a pet is selected
        petListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            deleteButton.setDisable(newValue == null);
        });

        // Delete button action
        deleteButton.setOnAction(e -> deleteSelectedPet());
    }

    public Button getBackButton() {
        return backButton;
    }

    public void refresh() {
        try {
            listContainer = new PetListContainer(FileHelper.loadFromFile(fileName));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing pet data found.");
            listContainer = new PetListContainer(); // Create a new container if none exists
        }

        petListView.getItems().clear();
        for (Pet pet : listContainer.getAllPets()) {
            petListView.getItems().add(pet.getName());
        }
    }

    private void deleteSelectedPet() {
        String selectedName = petListView.getSelectionModel().getSelectedItem();

        if (selectedName != null) {
            // Find and remove the pet from the list container
            Pet toRemove = null;
            for (Pet pet : listContainer.getAllPets()) {
                if (pet.getName().equals(selectedName)) {
                    toRemove = pet;
                    break;
                }
            }

            if (toRemove != null) {
                listContainer.getAllPets().remove(toRemove);

                //TODO FIX
                // Save the updated list to the file
                try {
                    FileHelper.saveToFile(fileName, listContainer.getAllPets());
                } catch (IOException e) {
                    System.out.println("Failed to save updated pet data.");
                }

                // Refresh the ListView
                refresh();
            }
        }
    }
}
