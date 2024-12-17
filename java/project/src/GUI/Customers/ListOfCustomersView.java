package GUI.Customers;

import Data.Customer;
import GUI.FileHelper;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import Data.*;

import java.io.IOException;

public class ListOfCustomersView {
    private final Button backButton;
    private final Button deleteButton;
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

        // Create and style delete button
        deleteButton = new Button("Delete Selected");
        deleteButton.setStyle("-fx-font-size: 16px; -fx-background-color: red; -fx-text-fill: white;");
        deleteButton.setPrefWidth(200);
        deleteButton.setDisable(true); // Initially disable until a customer is selected

        // Add components to the pane
        VBox vbox = new VBox(10, customerListView, deleteButton, backButton);
        vbox.setPadding(new Insets(20));
        listOfCustomersPane.getChildren().add(vbox);

        // Load initial customers
        refresh();

        // Enable delete button when a selection is made
        customerListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            deleteButton.setDisable(newValue == null);
        });

        // Delete button action
        deleteButton.setOnAction(e -> deleteSelectedCustomer());
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
            listContainer = new CustomerListContainer(); // Create a new container if none exists
        }

        customerListView.getItems().clear();
        for (Customer customer : listContainer.getAllCustomers()) {
            customerListView.getItems().add(customer.getName());
        }
    }

    public ListView<String> getCustomerListView() {
        return customerListView;
    }

    private void deleteSelectedCustomer() {
        String selectedName = customerListView.getSelectionModel().getSelectedItem();

        if (selectedName != null) {
            // Find and remove the customer from the list container
            Customer toRemove = null;
            for (Customer customer : listContainer.getAllCustomers()) {
                if (customer.getName().equals(selectedName)) {
                    toRemove = customer;
                    break;
                }
            }

            if (toRemove != null) {
                listContainer.getAllCustomers().remove(toRemove);

                // Save the updated list to the file
                try {
                    FileHelper.saveToFile("customers.dat", listContainer.getAllCustomers());
                } catch (IOException e) {
                    System.out.println("Failed to save updated customer data.");
                }

                // Refresh the ListView
                refresh();
            }
        }
    }
}
