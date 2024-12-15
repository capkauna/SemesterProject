package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.time.LocalDate;

public class SellAPetView
{
    private final Button backButton;

    public SellAPetView(Pane sellAPetPane) {
        sellAPetPane.getChildren().clear();
        sellAPetPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        // Main.Customer
        Label customerLabel = new Label("Choose a Customer:");
        customerLabel.setLayoutX(20);
        customerLabel.setLayoutY(60);
        customerLabel.setStyle("-fx-font-size: 16px;");
        sellAPetPane.getChildren().add(customerLabel);

        ComboBox<String> customerComboBox = new ComboBox<>();
        customerComboBox.setEditable(true);
        customerComboBox.setLayoutX(20);
        customerComboBox.setLayoutY(90);
        customerComboBox.setPrefWidth(380);
        customerComboBox.getItems().addAll("John Doe", "Jane Smith", "Emily Brown", "Michael Johnson");
        sellAPetPane.getChildren().add(customerComboBox);

        // Pet
        Label petLabel = new Label("Choose a Pet:");
        petLabel.setLayoutX(20);
        petLabel.setLayoutY(120);
        petLabel.setStyle("-fx-font-size: 16px;");
        sellAPetPane.getChildren().add(petLabel);

        ComboBox<String> petComboBox = new ComboBox<>();
        petComboBox.setEditable(true);
        petComboBox.setLayoutX(20);
        petComboBox.setLayoutY(150);
        petComboBox.setPrefWidth(380);
        petComboBox.getItems().addAll("Buddy", "Mittens", "Charlie", "Max");
        sellAPetPane.getChildren().add(petComboBox);

        // Sale Date
        Label saleDateLabel = new Label("Date of Sale:");
        saleDateLabel.setLayoutX(20);
        saleDateLabel.setLayoutY(190);
        saleDateLabel.setStyle("-fx-font-size: 16px;");
        sellAPetPane.getChildren().add(saleDateLabel);

        DatePicker saleDatePicker = new DatePicker();
        saleDatePicker.setLayoutX(120);
        saleDatePicker.setLayoutY(190);
        sellAPetPane.getChildren().add(saleDatePicker);

        // Price
        Label priceLabel = new Label("Set a Price (DK):");
        priceLabel.setLayoutX(20);
        priceLabel.setLayoutY(230);
        priceLabel.setStyle("-fx-font-size: 16px;");
        sellAPetPane.getChildren().add(priceLabel);

        TextField priceField = new TextField();
        priceField.setLayoutX(140);
        priceField.setLayoutY(230);
        priceField.setPrefWidth(100);
        sellAPetPane.getChildren().add(priceField);

        // Output
        Label resultLabel = new Label();
        resultLabel.setLayoutX(150);
        resultLabel.setLayoutY(310);
        resultLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: red;");
        sellAPetPane.getChildren().add(resultLabel);

        Label resultLabel2 = new Label();
        resultLabel2.setLayoutX(120);
        resultLabel2.setLayoutY(310);
        resultLabel2.setStyle("-fx-font-size: 14px; -fx-text-fill: green;");
        sellAPetPane.getChildren().add(resultLabel2);

        // Submit
        Button submitButton = new Button("Submit");
        submitButton.setLayoutX(210);
        submitButton.setLayoutY(350);
        submitButton.setStyle("-fx-font-size: 16px; -fx-background-color: green; -fx-text-fill: white;");
        sellAPetPane.getChildren().add(submitButton);

        Button resetButton = new Button("Reset");
        resetButton.setLayoutX(140);
        resetButton.setLayoutY(350);
        resetButton.setStyle("-fx-font-size: 16px; -fx-background-color: red; -fx-text-fill: white;");
        sellAPetPane.getChildren().add(resetButton);

        // Reset
        resetButton.setOnAction(e -> {
            customerComboBox.setValue(null);
            petComboBox.setValue(null);
            saleDatePicker.setValue(null);
            priceField.setText("");
            resultLabel.setText("");
            resultLabel2.setText("");
        });

        // Submit
        submitButton.setOnAction(e -> {
            String selectedCustomer = customerComboBox.getValue();
            String selectedPet = petComboBox.getValue();
            LocalDate saleDate = saleDatePicker.getValue();
            String priceText = priceField.getText();

            if (selectedCustomer == null) {
                resultLabel.setText("Please choose a customer.");
            } else if (selectedPet == null) {
                resultLabel.setText("Please choose a pet.");
            } else if (saleDate == null) {
                resultLabel.setText("Please select a valid sale date.");
            } else if (priceText == null) {
                resultLabel.setText("Please enter a price.");
            } else {
                try {
                    double price = Double.parseDouble(priceText.trim());
                    if (price <= 0) {
                        resultLabel.setText("Price must be a positive number.");
                    } else if (price > 100) {
                        resultLabel.setText("Price cannot exceed 100.");
                    } else {
                        resultLabel.setText("");
                        resultLabel2.setText("Pet successfully added to Petshop");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Price must be a number.");
                }
            }
        });
        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);
        sellAPetPane.getChildren().add(backButton);
    }
    public Button getBackButton() {
        return backButton;
    }
}

