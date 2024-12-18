package GUI.Kennel;

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

public class AddBookingView {
    private final String petFileName = "pets.dat";
    private final String customerFileName = "customers.dat";
    private final String bookingFileName = "bookings.dat";
    private Button backButton;
    private ComboBox<String> customerComboBox;
    private ComboBox<String> petComboBox;
    private DatePicker startDatePicker;
    private DatePicker endDatePicker;
    private TextField pricePerDayField;
    private Label resultLabel;
    private Label resultLabel2;
    private List<Customer> customers;
    private List<Pet> pets;

    public AddBookingView(Pane addBookingPane) {
        addBookingPane.getChildren().clear();
        addBookingPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        setupButtons(addBookingPane);  // Back button at the top
        setupCustomerSection(addBookingPane);
        setupPetSection(addBookingPane);
        setupStartDateSection(addBookingPane);
        setupEndDateSection(addBookingPane);
        setupPricePerDaySection(addBookingPane);
        setupOutputSection(addBookingPane);
    }

    private void setupButtons(Pane pane) {
        // Back Button
        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);
        backButton.setLayoutX(10);
        backButton.setLayoutY(10);
        pane.getChildren().add(backButton);

        // Reset Button
        Button resetButton = new Button("Reset");
        resetButton.setLayoutX(140);
        resetButton.setLayoutY(380);
        resetButton.setStyle("-fx-font-size: 16px; -fx-background-color: red; -fx-text-fill: white;");
        pane.getChildren().add(resetButton);

        // Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setLayoutX(210);
        submitButton.setLayoutY(380);
        submitButton.setStyle("-fx-font-size: 16px; -fx-background-color: green; -fx-text-fill: white;");
        pane.getChildren().add(submitButton);

        // Button Actions
        resetButton.setOnAction(e -> resetFields());
        submitButton.setOnAction(e -> handleSubmit());
        backButton.setOnAction(e -> {
            System.out.println("Navigating back to the previous view.");
            pane.getChildren().clear(); // Clears current pane
        });
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
        petLabel.setLayoutY(130);
        petLabel.setStyle("-fx-font-size: 16px;");
        pane.getChildren().add(petLabel);

        petComboBox = new ComboBox<>();
        petComboBox.setEditable(false);
        petComboBox.setLayoutX(20);
        petComboBox.setLayoutY(160);
        petComboBox.setPrefWidth(380);
        pane.getChildren().add(petComboBox);

        loadPetsAndPopulateComboBox();
    }

    private void setupStartDateSection(Pane pane) {
        Label startDateLabel = new Label("Start day of the booking:");
        startDateLabel.setLayoutX(20);
        startDateLabel.setLayoutY(200);
        startDateLabel.setStyle("-fx-font-size: 16px;");
        pane.getChildren().add(startDateLabel);

        startDatePicker = new DatePicker();
        startDatePicker.setLayoutX(240);
        startDatePicker.setLayoutY(195);
        startDatePicker.setPrefWidth(160);
        pane.getChildren().add(startDatePicker);
    }

    private void setupEndDateSection(Pane pane) {
        Label endDateLabel = new Label("End date of the booking:");
        endDateLabel.setLayoutX(20);
        endDateLabel.setLayoutY(240);
        endDateLabel.setStyle("-fx-font-size: 16px;");
        pane.getChildren().add(endDateLabel);

        endDatePicker = new DatePicker();
        endDatePicker.setLayoutX(240);
        endDatePicker.setLayoutY(235);
        endDatePicker.setPrefWidth(160);
        pane.getChildren().add(endDatePicker);
    }

    private void setupPricePerDaySection(Pane pane) {
        Label pricePerDayLabel = new Label("Set a Price per day (DKK):");
        pricePerDayLabel.setLayoutX(20);
        pricePerDayLabel.setLayoutY(280);
        pricePerDayLabel.setStyle("-fx-font-size: 16px;");
        pane.getChildren().add(pricePerDayLabel);

        pricePerDayField = new TextField();
        pricePerDayField.setLayoutX(240);
        pricePerDayField.setLayoutY(275);
        pricePerDayField.setPrefWidth(160);
        pane.getChildren().add(pricePerDayField);
    }

    private void setupOutputSection(Pane pane) {
        resultLabel = new Label();
        resultLabel.setLayoutX(20);
        resultLabel.setLayoutY(340);
        resultLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: red;");
        pane.getChildren().add(resultLabel);

        resultLabel2 = new Label();
        resultLabel2.setLayoutX(20);
        resultLabel2.setLayoutY(340);
        resultLabel2.setStyle("-fx-font-size: 14px; -fx-text-fill: green;");
        pane.getChildren().add(resultLabel2);
    }

    private void resetFields() {
        customerComboBox.setValue(null);
        petComboBox.setValue(null);
        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
        pricePerDayField.setText("");
        resultLabel.setText("");
        resultLabel2.setText("");
    }

    private void handleSubmit() {
        String selectedCustomer = customerComboBox.getValue();
        String selectedPet = petComboBox.getValue();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        String pricePerDayText = pricePerDayField.getText();

        resultLabel.setText(""); // Clear previous errors
        resultLabel2.setText("");

        if (selectedCustomer == null || selectedPet == null || startDate == null || endDate == null || pricePerDayText.trim().isEmpty()) {
            resultLabel.setText("All fields must be filled in!");
            return;
        }

        try {
            double price = Double.parseDouble(pricePerDayText.trim());
            resultLabel2.setText("Booking successfully recorded!");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Price must be a valid number.");
        }
    }

    private void loadPetsAndPopulateComboBox() {
        try {
            PetListContainer listContainer = new PetListContainer(FileHelper.loadFromFile(petFileName));
            pets = listContainer.getPetsForSale();
            petComboBox.getItems().clear();
            for (Pet pet : pets) {
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
            for (Customer customer : customers) {
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
