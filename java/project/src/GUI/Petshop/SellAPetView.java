package GUI.Petshop;

import Data.*;
import Data.AnimalDTO.Date;
import Data.AnimalDTO.Pet;
import Helpers.FileHelper;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class SellAPetView {
    private final String petFileName = "pets.dat";
    private final String customerFileName = "customers.dat";
    private final String saleFileName = "sales.dat";
    private Button backButton;
    private ComboBox<String> customerComboBox;
    private ComboBox<String> petComboBox;
    private DatePicker saleDatePicker;
    private TextField priceField;
    private Label resultLabel;
    private Label resultLabel2;
    private List<Customer> customers;
    private List<Pet> pets;

    public SellAPetView(Pane sellAPetPane) {
        sellAPetPane.getChildren().clear();
        sellAPetPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        setupCustomerSection(sellAPetPane);
        setupPetSection(sellAPetPane);
        setupSaleDateSection(sellAPetPane);
        setupPriceSection(sellAPetPane);
        setupOutputSection(sellAPetPane);
        setupButtons(sellAPetPane);
    }

    private void setupCustomerSection(Pane pane) {
        Label customerLabel = new Label("Choose a Customer:");
        customerLabel.setLayoutX(20);
        customerLabel.setLayoutY(60);
        customerLabel.setStyle("-fx-font-size: 16px;");
        pane.getChildren().add(customerLabel);

        customerComboBox = new ComboBox<>();
        customerComboBox.setEditable(false);
        customerComboBox.setLayoutX(20);
        customerComboBox.setLayoutY(90);
        customerComboBox.setPrefWidth(380);
        pane.getChildren().add(customerComboBox);


        loadCustomersAndPopulateComboBox();
    }

    private void setupPetSection(Pane pane) {
        Label petLabel = new Label("Choose a Pet:");
        petLabel.setLayoutX(20);
        petLabel.setLayoutY(120);
        petLabel.setStyle("-fx-font-size: 16px;");
        pane.getChildren().add(petLabel);

        petComboBox = new ComboBox<>();
        petComboBox.setEditable(false);
        petComboBox.setLayoutX(20);
        petComboBox.setLayoutY(150);
        petComboBox.setPrefWidth(380);
        pane.getChildren().add(petComboBox);

        loadPetsAndPopulateComboBox();
    }

    private void setupSaleDateSection(Pane pane) {
        Label saleDateLabel = new Label("Date of Sale:");
        saleDateLabel.setLayoutX(20);
        saleDateLabel.setLayoutY(190);
        saleDateLabel.setStyle("-fx-font-size: 16px;");
        pane.getChildren().add(saleDateLabel);

        saleDatePicker = new DatePicker();
        saleDatePicker.setLayoutX(120);
        saleDatePicker.setLayoutY(190);
        pane.getChildren().add(saleDatePicker);
    }

    private void setupPriceSection(Pane pane) {
        Label priceLabel = new Label("Set a Price (DK):");
        priceLabel.setLayoutX(20);
        priceLabel.setLayoutY(230);
        priceLabel.setStyle("-fx-font-size: 16px;");
        pane.getChildren().add(priceLabel);

        priceField = new TextField();
        priceField.setLayoutX(140);
        priceField.setLayoutY(230);
        priceField.setPrefWidth(100);
        pane.getChildren().add(priceField);
    }

    private void setupOutputSection(Pane pane) {
        resultLabel = new Label();
        resultLabel.setLayoutX(150);
        resultLabel.setLayoutY(310);
        resultLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: red;");
        pane.getChildren().add(resultLabel);

        resultLabel2 = new Label();
        resultLabel2.setLayoutX(120);
        resultLabel2.setLayoutY(310);
        resultLabel2.setStyle("-fx-font-size: 14px; -fx-text-fill: green;");
        pane.getChildren().add(resultLabel2);
    }

    private void setupButtons(Pane pane) {
        Button submitButton = new Button("Submit");
        submitButton.setLayoutX(210);
        submitButton.setLayoutY(350);
        submitButton.setStyle("-fx-font-size: 16px; -fx-background-color: green; -fx-text-fill: white;");
        pane.getChildren().add(submitButton);

        Button resetButton = new Button("Reset");
        resetButton.setLayoutX(140);
        resetButton.setLayoutY(350);
        resetButton.setStyle("-fx-font-size: 16px; -fx-background-color: red; -fx-text-fill: white;");
        pane.getChildren().add(resetButton);

        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(720);
        pane.getChildren().add(backButton);

        resetButton.setOnAction(e -> resetFields());
        submitButton.setOnAction(e -> handleSubmit());
    }

    private void resetFields() {
        customerComboBox.setValue(null);
        petComboBox.setValue(null);
        saleDatePicker.setValue(null);
        priceField.setText("");
        resultLabel.setText("");
        resultLabel2.setText("");
    }

    private void handleSubmit() {
        // Get selected values from combo boxes
        String selectedCustomer = customerComboBox.getValue(); // O(1)
        String selectedPet = petComboBox.getValue(); // O(1)
        LocalDate saleDate = saleDatePicker.getValue(); // O(1)
        String priceText = priceField.getText(); // O(1)


        resultLabel.setText(""); // Clear previous errors
        resultLabel2.setText(""); // O(1)

        // Check if selected customer is valid
        if (selectedCustomer == null || selectedCustomer.trim().isEmpty()) { // O(1)
            resultLabel.setText("Please choose a customer."); // O(1)
            return; // O(1)
        }
        // Check if selected pet is valid
        if (selectedPet == null || selectedPet.trim().isEmpty()) {
            resultLabel.setText("Please choose a pet.");
            return;
        }
        // Check if sale date is valid
        if (saleDate == null) {
            resultLabel.setText("Please select a valid sale date.");
            return;
        }
        // Check if price is valid
        if (priceText == null || priceText.trim().isEmpty()) {
            resultLabel.setText("Please enter a price.");
            return;
        }

        try {
            // Parse the price
            double price = Double.parseDouble(priceText.trim());
            if (price <= 0) {
                resultLabel.setText("Price must be a positive number.");
                return;
            } else if (price > 10000) {
                resultLabel.setText("Price cannot exceed 10,000 DK.");
                return;
            }
            // Success message
            resultLabel2.setText("Sale successfully recorded.");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Price must be a number.");
        }

        try {
            Customer customerToSave = null;
            Pet petToSave = null;

            // Loop through customers to find the selected customer
            for (Customer customer : customers) { // O(n)
                if (customer.getName().equals(selectedCustomer)) { // O(1) per iteration
                    customerToSave = customer; // O(1)
                    break; // O(1)
                }
            }
            // Loop through pets to find the selected pet
            for (Pet pet : pets) {  // O(m)
                if (pet.getName().equals(selectedPet)) { // O(1) per iteration
                    petToSave = pet; // O(1)
                    break; // O(1)
                }

                // Time Complexity Analysis:
                // Base case: There is no recursion in this method, so we can't use the Master Theorem.
                // Time complexity of each code segment:
                // Most of the checks and assignments (e.g., String selectedCustomer = customerComboBox.getValue()) are O(1).
                // We used loops that iterate through customers and pets in parts:
                // Loop through customers: O(n), where n is the number of customers.
                // Loop through pets: O(m), where m is the number of pets.
                // Time complexity formula:
                // T(n, m) = O(n) + O(m) + O(1) (for constant operations)
                // Dominating term: The loops through customers and pets are the dominating terms, so the overall time complexity is O(n + m).
                // Explanation: We used method's complexity is dominated by the linear search through both customers and pets.
                // If these collections are large, it could impact performance.
                // About Big-O notation: Overall time complexity: O(n + m), where n is the number of customers and m is the number of pets.
                // The time complexity analysis is based on the need to loop through collections (customers and pets) to find matching entries.
                // The most costly operations are these linear searches.

            }

            Date saleDateToSave = new Date(saleDate.getDayOfMonth(), saleDate.getMonthValue(), saleDate.getYear());
            SalesList sale  = new SalesList();
            //TODO Use the correct priceText for original sale vs offer price
            sale.addSale(petToSave, customerToSave, saleDateToSave, Double.parseDouble(priceText), Double.parseDouble(priceText));
            FileHelper.saveToFile(saleFileName, sale.getAllSales());

            //TODO remove pet from list of pets when a sale is succesfull
            //TODO make sure file works with serializable
            System.out.println("Sale recorded: " + sale.getAllSales().get(sale.getAllSales().size() - 1));
        } catch (IOException e) {
            //TODO show label
        }
    }

    private void loadPetsAndPopulateComboBox() {
        try {
            PetListContainer listContainer = new PetListContainer(FileHelper.loadFromFile(petFileName));
            pets = listContainer.getPetsForSale();
            petComboBox.getItems().clear();
            for (Pet pet : listContainer.getPetsForSale()) {
                petComboBox.getItems().add(pet.getName());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing pet data found.");
        }
    }

    private void loadCustomersAndPopulateComboBox() {
        try {
            CustomerListContainer listContainer = new CustomerListContainer(FileHelper.loadFromFile(customerFileName));
            customers = listContainer.getAllCustomers();
            customerComboBox.getItems().clear();
            for (Customer customer : listContainer.getAllCustomers()) {
                customerComboBox.getItems().add(customer.getName());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing customer data found.");
        }
    }

    public Button getBackButton() {
        return backButton;
    }

    public void refresh() {
        loadCustomersAndPopulateComboBox();
        loadPetsAndPopulateComboBox();
    }
}
