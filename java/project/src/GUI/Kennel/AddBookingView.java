package GUI.Kennel;

import Data.*;
import Data.AnimalDTO.*;
import Data.AnimalDTO.Pet;
import Data.Customer;
import Data.DateInterval;
import Data.BookingsList;
import Data.CustomerListContainer;
import Data.PetListContainer;
import Helpers.FileHelper;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

        // Main container
        VBox mainContainer = new VBox(20);
        mainContainer.setPadding(new Insets(20));
        mainContainer.setAlignment(Pos.TOP_CENTER);

        // Add sections
        mainContainer.getChildren().addAll(
                createCustomerSection(),
                createPetSection(),
                createDateSection(),
                createPriceSection(),
                createButtonsSection(),
                createOutputSection()
        );

        addBookingPane.getChildren().add(mainContainer);
    }

    private GridPane createCustomerSection() {
        GridPane customerSection = new GridPane();
        customerSection.setHgap(10);
        customerSection.setVgap(10);

        Label customerLabel = new Label("Choose a Customer:");
        customerLabel.setStyle("-fx-font-size: 16px;");
        customerComboBox = new ComboBox<>();
        customerComboBox.setEditable(false);
        customerComboBox.setPrefWidth(300);


        loadCustomersAndPopulateComboBox();

        customerSection.add(customerLabel, 0, 0);
        customerSection.add(customerComboBox, 1, 0);
        return customerSection;
    }

    private GridPane createPetSection() {
        GridPane petSection = new GridPane();
        petSection.setHgap(10);
        petSection.setVgap(10);

        Label petLabel = new Label("Choose a Pet:");
        petLabel.setStyle("-fx-font-size: 16px;");
        petComboBox = new ComboBox<>();
        petComboBox.setEditable(false);
        petComboBox.setPrefWidth(300);

        loadPetsAndPopulateComboBox();

        petSection.add(petLabel, 0, 0);
        petSection.add(petComboBox, 1, 0);
        return petSection;
    }

    private GridPane createDateSection() {
        GridPane dateSection = new GridPane();
        dateSection.setHgap(10);
        dateSection.setVgap(10);

        Label startDateLabel = new Label("Start Date:");
        startDateLabel.setStyle("-fx-font-size: 16px;");
        startDatePicker = new DatePicker();

        Label endDateLabel = new Label("End Date:");
        endDateLabel.setStyle("-fx-font-size: 16px;");
        endDatePicker = new DatePicker();

        dateSection.add(startDateLabel, 0, 0);
        dateSection.add(startDatePicker, 1, 0);
        dateSection.add(endDateLabel, 0, 1);
        dateSection.add(endDatePicker, 1, 1);
        return dateSection;
    }

    private GridPane createPriceSection() {
        GridPane priceSection = new GridPane();
        priceSection.setHgap(10);
        priceSection.setVgap(10);

        Label priceLabel = new Label("Price per Day (DKK):");
        priceLabel.setStyle("-fx-font-size: 16px;");
        pricePerDayField = new TextField();
        pricePerDayField.setPrefWidth(150);

        priceSection.add(priceLabel, 0, 0);
        priceSection.add(pricePerDayField, 1, 0);
        return priceSection;
    }

    private HBox createButtonsSection() {
        HBox buttonSection = new HBox(20);
        buttonSection.setAlignment(Pos.CENTER);

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-font-size: 16px; -fx-background-color: green; -fx-text-fill: white;");
        submitButton.setOnAction(e -> handleSubmit());

        Button resetButton = new Button("Reset");
        resetButton.setStyle("-fx-font-size: 16px; -fx-background-color: red; -fx-text-fill: white;");
        resetButton.setOnAction(e -> resetFields());

        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);

        buttonSection.getChildren().addAll(resetButton, submitButton, backButton);
        return buttonSection;
    }

    private VBox createOutputSection() {
        VBox outputSection = new VBox(5);
        outputSection.setAlignment(Pos.CENTER);

        resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: red;");

        resultLabel2 = new Label();
        resultLabel2.setStyle("-fx-font-size: 14px; -fx-text-fill: green;");

        outputSection.getChildren().addAll(resultLabel, resultLabel2);
        return outputSection;
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

        resultLabel.setText("");
        resultLabel2.setText("");

        if (selectedCustomer == null || selectedCustomer.trim().isEmpty()) {
            resultLabel.setText("Please choose a customer.");
            return;
        }
        if (selectedPet == null || selectedPet.trim().isEmpty()) {
            resultLabel.setText("Please choose a pet.");
            return;
        }
        if (startDate == null || endDate == null) {
            resultLabel.setText("Please select valid dates.");
            return;
        }
        if (pricePerDayText == null || pricePerDayText.trim().isEmpty()) {
            resultLabel.setText("Please enter a price.");
            return;
        }

        try {
            double price = Double.parseDouble(pricePerDayText.trim());
            if (price <= 0 || price > 10000) {
                resultLabel.setText("Price must be between 0 and 10,000 DK.");
                return;
            }

            Customer customerToSave = customers.stream()
                    .filter(c -> c.getName().equals(selectedCustomer))
                    .findFirst().orElse(null);
            Pet petToSave = pets.stream()
                    .filter(p -> p.getName().equals(selectedPet))
                    .findFirst().orElse(null);

            Date startDateToSave = new Date(startDate.getDayOfMonth(), startDate.getMonthValue(), startDate.getYear());
            Date endDateToSave = new Date(endDate.getDayOfMonth(), endDate.getMonthValue(), endDate.getYear());
            DateInterval dateIntervalToSave = new DateInterval(startDateToSave, endDateToSave);
            double totalPriceToSave = price * dateIntervalToSave.numberOfDays();

            BookingsList bookingList = new BookingsList();
            bookingList.addBooking(petToSave, customerToSave, dateIntervalToSave, price, totalPriceToSave);
            FileHelper.saveToFile(bookingFileName, bookingList.getAllBookings());

            resultLabel2.setText("Booking successfully recorded.");
        } catch (NumberFormatException e) {
            resultLabel.setText("Price must be a number.");
        } catch (IOException e) {
            resultLabel.setText("Error saving the booking. Please try again.");
        }
    }

    private void loadPetsAndPopulateComboBox() {
        try {
            PetListContainer listContainer = new PetListContainer(FileHelper.loadFromFile(petFileName));
            pets = listContainer.getPetsForSale();
            petComboBox.getItems().clear();
            pets.forEach(pet -> petComboBox.getItems().add(pet.getName()));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing pet data found.");
        }
    }

    private void loadCustomersAndPopulateComboBox() {
        try {
            CustomerListContainer listContainer = new CustomerListContainer(FileHelper.loadFromFile(customerFileName));
            customers = listContainer.getAllCustomers();
            customerComboBox.getItems().clear();
            customers.forEach(customer -> customerComboBox.getItems().add(customer.getName()));
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
