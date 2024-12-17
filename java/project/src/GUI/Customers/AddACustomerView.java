package GUI.Customers;

import Data.Customer;
import Data.CustomerListContainer;
import Helpers.FileHelper;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;

public class AddACustomerView {
  private final String fileName = "customers.dat";
  private final Button backButton;

  // Fields as properties
  private TextField nameField;
  private TextField phoneField;
  private TextField addressField;
  private TextField emailField;
  private Label errorLabel;
  private Label successLabel;

  public AddACustomerView(Pane addACustomerPane) {
    addACustomerPane.getChildren().clear();
    addACustomerPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

    // Initialize fields
    nameField = createTextField(addACustomerPane, "Name:", 20, 60);
    phoneField = createTextField(addACustomerPane, "Phone Nr.:", 20, 120);
    addressField = createTextField(addACustomerPane, "Address:", 20, 180);
    emailField = createTextField(addACustomerPane, "E-mail:", 20, 240);
    errorLabel = createLabel(addACustomerPane, "", 150, 310, "-fx-font-size: 14px; -fx-text-fill: red;");
    successLabel = createLabel(addACustomerPane, "", 120, 310, "-fx-font-size: 14px; -fx-text-fill: green;");

    // Buttons
    Button submitButton = createButton(addACustomerPane, "Submit", 210, 350, "-fx-font-size: 16px; -fx-background-color: green; -fx-text-fill: white;");
    Button resetButton = createButton(addACustomerPane, "Reset", 140, 350, "-fx-font-size: 16px; -fx-background-color: red; -fx-text-fill: white;");
    backButton = createButton(addACustomerPane, "Return", 0, 0, "-fx-font-size: 20px; -fx-background-color: white;");
    backButton.setPrefWidth(420);

    // Button Actions
    resetButton.setOnAction(e -> resetForm());
    submitButton.setOnAction(e -> handleSubmit());
  }

  public Button getBackButton() {
    return backButton;
  }

  // Method to create a label
  private Label createLabel(Pane pane, String text, int x, int y, String style) {
    Label label = new Label(text);
    label.setLayoutX(x);
    label.setLayoutY(y);
    label.setStyle(style);
    pane.getChildren().add(label);
    return label;
  }

  // Method to create a text field
  private TextField createTextField(Pane pane, String labelText, int x, int y) {
    createLabel(pane, labelText, x, y, "-fx-font-size: 16px;");
    TextField textField = new TextField();
    textField.setLayoutX(20);
    textField.setLayoutY(y + 30);
    textField.setPrefWidth(380);
    pane.getChildren().add(textField);
    return textField;
  }

  // Method to create a button
  private Button createButton(Pane pane, String text, int x, int y, String style) {
    Button button = new Button(text);
    button.setLayoutX(x);
    button.setLayoutY(y);
    button.setStyle(style);
    pane.getChildren().add(button);
    return button;
  }

  // Reset form method
  private void resetForm() {
    errorLabel.setText("");
    successLabel.setText("");
    nameField.setText("");
    phoneField.setText("");
    addressField.setText("");
    emailField.setText("");
  }

  // Submit button action
  private void handleSubmit() {
    errorLabel.setText("");
    successLabel.setText("");

    String name = nameField.getText();
    String phone = phoneField.getText();
    String address = addressField.getText();
    String email = emailField.getText();

    if (name == null || name.trim().isEmpty()) {
      errorLabel.setText("Please enter a name.");
    } else if (phone == null || phone.trim().isEmpty()) {
      errorLabel.setText("Please enter a phone number.");
    } else if (address == null || address.trim().isEmpty()) {
      errorLabel.setText("Enter an address.");
    } else if (email == null || email.trim().isEmpty()) {
      errorLabel.setText("Enter an email.");
    } else {
      try {
        Customer newCustomer = new Customer(name, phone, address, email);
        CustomerListContainer listContainer = new CustomerListContainer(
            FileHelper.loadFromFile(fileName));

        listContainer.addCustomer(newCustomer);
        FileHelper.saveToFile(fileName, listContainer.getAllCustomers());

        resetForm();
        successLabel.setText("Customer added successfully!");
      } catch (IOException ex) {
        errorLabel.setText("Failed to save customer.");
      } catch (ClassNotFoundException ex) {
        errorLabel.setText("Unexpected error occurred.");
      }
    }
  }
}
