package GUI.Petshop;

import Data.AnimalDTO.Pet;
import Data.PetListContainer;
import Helpers.FileHelper;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;

public class PetsForSaleView {
    private final Button backButton;
    private final ListView<String> petForSaleListView;
    private PetListContainer listContainer = null;
    private final String fileName = "pets.dat";

    public PetsForSaleView(Pane listOfPetsPane) {
        // Clear and set background
        listOfPetsPane.getChildren().clear();
        listOfPetsPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        // Initialize ListView for pets
        petForSaleListView = new ListView<>();
        petForSaleListView.setPrefWidth(400);
        petForSaleListView.setPrefHeight(300);
        petForSaleListView.setStyle("-fx-font-size: 16px;");

        // Initialize back button
        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);


        // Add components to the pane
        VBox vbox = new VBox(10, petForSaleListView, backButton);
        vbox.setPadding(new Insets(20));
        listOfPetsPane.getChildren().add(vbox);

        // Load initial pet data
        refresh();

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

        petForSaleListView.getItems().clear();
        for (Pet pet : listContainer.getPetsForSale()) {
            petForSaleListView.getItems().add(pet.getName());
        }
    }
}
