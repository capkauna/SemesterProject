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

        setupCustomerSection(addBookingPane);
        setupPetSection(addBookingPane);
        setupStartDateSection(addBookingPane);
        setupEndDateSection(addBookingPane);
        setupPricePerDaySection(addBookingPane);
        setupOutputSection(addBookingPane);
        setupButtons(addBookingPane);
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

    private void setupStartDateSection(Pane pane) {
        Label startDateLabel = new Label("Date of Sale:");
        startDateLabel.setLayoutX(20);
        startDateLabel.setLayoutY(190);
        startDateLabel.setStyle("-fx-font-size: 16px;");
        pane.getChildren().add(startDateLabel);

        startDatePicker = new DatePicker();
        startDatePicker.setLayoutX(120);
        startDatePicker.setLayoutY(190);
        pane.getChildren().add(startDatePicker);
    }

    private void setupEndDateSection(Pane pane) {
        Label endDateLabel = new Label("Date of Sale:");
        endDateLabel.setLayoutX(20);
        endDateLabel.setLayoutY(190);
        endDateLabel.setStyle("-fx-font-size: 16px;");
        pane.getChildren().add(endDateLabel);

        endDatePicker = new DatePicker();
        endDatePicker.setLayoutX(120);
        endDatePicker.setLayoutY(190);
        pane.getChildren().add(endDatePicker);
    }

    private void setupPricePerDaySection(Pane pane) {
        Label pricePerDayLabel = new Label("Set a Price (DK):");
        pricePerDayLabel.setLayoutX(20);
        pricePerDayLabel.setLayoutY(230);
        pricePerDayLabel.setStyle("-fx-font-size: 16px;");
        pane.getChildren().add(pricePerDayLabel);

        pricePerDayField = new TextField();
        pricePerDayField.setLayoutX(140);
        pricePerDayField.setLayoutY(230);
        pricePerDayField.setPrefWidth(100);
        pane.getChildren().add(pricePerDayField);
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
        backButton.setPrefWidth(420);
        pane.getChildren().add(backButton);

        resetButton.setOnAction(e -> resetFields());
        submitButton.setOnAction(e -> handleSubmit());
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

        if (selectedCustomer == null || selectedCustomer.trim().isEmpty()) {
            resultLabel.setText("Please choose a customer.");
            return;
        }
        if (selectedPet == null || selectedPet.trim().isEmpty()) {
            resultLabel.setText("Please choose a pet.");
            return;
        }
        if (startDate == null) {
            resultLabel.setText("Please select a valid sale date.");
            return;
        }
        if (endDate == null) {
            resultLabel.setText("Please select a valid sale date.");
            return;
        }
        if (pricePerDayText == null || pricePerDayText.trim().isEmpty()) {
            resultLabel.setText("Please enter a price.");
            return;
        }

        try {
            double price = Double.parseDouble(pricePerDayText.trim());
            if (price <= 0) {
                resultLabel.setText("Price must be a positive number.");
                return;
            } else if (price > 10000) {
                resultLabel.setText("Price cannot exceed 10,000 DK.");
                return;
            }
            resultLabel2.setText("Sale successfully recorded.");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Price must be a number.");
        }

        try {
            Customer customerToSave = null;
            Pet petToSave = null;
            for (Customer customer : customers) {
                if (customer.getName().equals(selectedCustomer)) {
                    customerToSave = customer;
                    break;
                }
            }
            for (Pet pet : pets) {
                if (pet.getName().equals(selectedPet)) {
                    petToSave = pet;
                    break;
                }
            }

            Date startDateToSave = new Date(startDate.getDayOfMonth(), startDate.getMonthValue(), startDate.getYear());
            Date endDateToSave = new Date(endDate.getDayOfMonth(), endDate.getMonthValue(), endDate.getYear());
            BookingsList booking  = new BookingsList();
            booking.addBooking(petToSave, customerToSave, dateInterval, Double.parseDouble(pricePerDayText), totalPrice);
            FileHelper.saveToFile(bookingFileName, booking.getAllBookings());


            //TODO make sure file works with serializable
            System.out.println("Booking recorded: " + booking.getAllBookings().get(booking.getAllBookings().size() - 1));
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
