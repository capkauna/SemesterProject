package GUI;

import Data.Pet;
import Data.PetListContainer;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;

public class ListOfPetsView
{
    private final Button backButton;
    private final ListView<String> petListView;
    private PetListContainer listContainer = null;
    private final String fileName = "pet.dat";

    public ListOfPetsView(Pane listOfPetsPane) {
        listOfPetsPane.getChildren().clear();
        listOfPetsPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));


        // Create and style ListView for customers
        petListView = new ListView<>();
        petListView.setPrefWidth(400);
        petListView.setPrefHeight(300);
        petListView.setStyle("-fx-font-size: 16px;");

        // Create and style back button
        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);
        listOfPetsPane.getChildren().add(backButton);

        // Add components to the pane
        VBox vbox = new VBox(10, petListView, backButton);
        vbox.setPadding(new Insets(20));
        listOfPetsPane.getChildren().add(vbox);
    }
    public Button getBackButton() {
        return backButton;
    }

    public void refresh()
    {
        try {
            listContainer = new PetListContainer(FileHelper.loadFromFile(fileName));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing pet data found.");
        }

        // TODO check for null on petListView for first refresh
        petListView.getItems().clear();
        for (Pet pet : listContainer.getAllPets()) {
            petListView.getItems().add(pet.getName());
        }
    }
}
