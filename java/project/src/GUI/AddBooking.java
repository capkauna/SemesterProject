package GUI;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import java.time.LocalDate;

public class AddBooking {
    private final Button backButton; // Back button reference

    public AddBooking(Pane bookingPane) {
        bookingPane.getChildren().clear();
        bookingPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        // Customer
        Label bookingLabel1 = new Label("Choose a Customer:");
        bookingLabel1.setLayoutX(20);
        bookingLabel1.setLayoutY(60);
        bookingLabel1.setStyle("-fx-font-size: 16px;");
        bookingPane.getChildren().add(bookingLabel1);

        ComboBox<String> customerComboBox = new ComboBox<>();
        customerComboBox.setEditable(true);
        customerComboBox.setLayoutX(20);
        customerComboBox.setLayoutY(90);
        customerComboBox.setPrefWidth(380);

        customerComboBox.getItems().addAll("1", "2", "3", "4");
        bookingPane.getChildren().add(customerComboBox);

        // Pet
        Label bookingLabel2 = new Label("Choose a Pet:");
        bookingLabel2.setLayoutX(20);
        bookingLabel2.setLayoutY(120);
        bookingLabel2.setStyle("-fx-font-size: 16px;");
        bookingPane.getChildren().add(bookingLabel2);

        ComboBox<String> petComboBox = new ComboBox<>();
        petComboBox.setEditable(true);
        petComboBox.setLayoutX(20);
        petComboBox.setLayoutY(150);
        petComboBox.setPrefWidth(380);

        petComboBox.getItems().addAll("1", "2", "3", "4");
        bookingPane.getChildren().add(petComboBox);

        // Start Date End Date
        Label startDateLabel = new Label("Start Date:");
        startDateLabel.setLayoutX(20);
        startDateLabel.setLayoutY(190);
        startDateLabel.setStyle("-fx-font-size: 16px;");
        bookingPane.getChildren().add(startDateLabel);

        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setLayoutX(100);
        startDatePicker.setLayoutY(190);
        bookingPane.getChildren().add(startDatePicker);

        Label endDateLabel = new Label("End Date:");
        endDateLabel.setLayoutX(20);
        endDateLabel.setLayoutY(230);
        endDateLabel.setStyle("-fx-font-size: 16px;");
        bookingPane.getChildren().add(endDateLabel);

        DatePicker endDatePicker = new DatePicker();
        endDatePicker.setLayoutX(100);
        endDatePicker.setLayoutY(230);
        bookingPane.getChildren().add(endDatePicker);

        //Output
        Label resultLabel = new Label();
        resultLabel.setLayoutX(150);
        resultLabel.setLayoutY(310);
        resultLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: red;");
        bookingPane.getChildren().add(resultLabel);

        Label resultLabel2 = new Label();
        resultLabel2.setLayoutX(120);
        resultLabel2.setLayoutY(310);
        resultLabel2.setStyle("-fx-font-size: 14px; -fx-text-fill: green;");
        bookingPane.getChildren().add(resultLabel2);

        // Price
        Label priceLabel = new Label("Set a price per day (DK):");
        priceLabel.setLayoutX(20);
        priceLabel.setLayoutY(270);
        priceLabel.setStyle("-fx-font-size: 16px;");
        bookingPane.getChildren().add(priceLabel);

        TextField priceField = new TextField();
        priceField.setLayoutX(200);
        priceField.setLayoutY(270);
        priceField.setPrefWidth(100);
        bookingPane.getChildren().add(priceField);

        // Submit
        Button submitButton = new Button("Submit");
        submitButton.setLayoutX(210);
        submitButton.setLayoutY(350);
        submitButton.setStyle("-fx-font-size: 16px; -fx-background-color: green; -fx-text-fill: white;");
        bookingPane.getChildren().add(submitButton);

        //Reset
        Button resetButton = new Button("Reset");
        resetButton.setLayoutX(140);
        resetButton.setLayoutY(350);
        resetButton.setStyle("-fx-font-size: 16px; -fx-background-color: red; -fx-text-fill: white;");
        bookingPane.getChildren().add(resetButton);

        resetButton.setOnAction(e -> {
            customerComboBox.setValue(null);
            petComboBox.setValue(null);
            startDatePicker.setValue(null);
            endDatePicker.setValue(null);
            resultLabel.setText("");
            resultLabel2.setText("");
            priceField.setText("");
        });

        submitButton.setOnAction(e -> {
            String selectedCustomer = customerComboBox.getValue();
            String selectedPet = petComboBox.getValue();
            LocalDate startDate = startDatePicker.getValue();
            LocalDate endDate = endDatePicker.getValue();

                if (selectedCustomer == null) {
                    resultLabel.setText("Please select a customer.");
                } else if (selectedPet == null) {
                    resultLabel.setText("Please select a pet.");
                } else if (startDate == null || endDate == null) {
                    resultLabel.setText("Please select both start and end dates.");
                } else if (endDate.isBefore(startDate)) {
                    resultLabel.setText("End date cannot be before start date.");
                } else if (priceField.getText() == null || priceField.getText().trim().isEmpty()) {
                    resultLabel.setText("Please set a price per day.");
                } else {
                    try {
                        double price = Double.parseDouble(priceField.getText().trim());
                        if (price <= 0) {
                            resultLabel.setText("Price must be a positive number.");
                        } else if (price > 100) {
                            resultLabel.setText("Price can't be higher than 100.");
                        }
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Price must be a number.");
                    }
                }
            });
        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);
        bookingPane.getChildren().add(backButton);
    }
    public Button getBackButton() {
        return backButton;
    }
}
