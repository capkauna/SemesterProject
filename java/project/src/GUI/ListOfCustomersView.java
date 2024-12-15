package GUI;

import Data.Customer;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import Data.*;

import java.io.IOException;

public class ListOfCustomersView
{
    private final Button backButton;
    private final ListView<String> customerListView; // A ListView to display customer names
    private CustomerListContainer listContainer = null;

    public ListOfCustomersView(Pane listOfCustomersPane) {
        // Clear and set background
        listOfCustomersPane.getChildren().clear();
        listOfCustomersPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        // Create and style ListView for customers
        customerListView = new ListView<>();
        customerListView.setPrefWidth(400);
        customerListView.setPrefHeight(300);
        customerListView.setStyle("-fx-font-size: 16px;");

        // Create and style back button
        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);

        // Add components to the pane
        VBox vbox = new VBox(10, customerListView, backButton);
        vbox.setPadding(new Insets(20));
        listOfCustomersPane.getChildren().add(vbox);
    }

    public Button getBackButton() {
        return backButton;
    }

    public void refresh() {
        // Load customers from file
        try {
            listContainer = new CustomerListContainer(FileHelper.loadFromFile("customers.dat"));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing customer data found.");
        }

        customerListView.getItems().clear();
        for (Customer customer : listContainer.getAllCustomers()) {
            customerListView.getItems().add(customer.getName());
        }
    }

    public ListView<String> getCustomerListView() {
        return customerListView;
    }
}
