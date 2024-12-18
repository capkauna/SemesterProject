package GUI.Pets;

import Data.*;
import Data.Gender;
import Data.AnimalDTO.Pet;
import Data.AnimalDTO.PetFactory;
import Data.Species;
import Helpers.FileHelper;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddAPetView
{
  private final String fileName = "pets.dat";
  private final Button backButton;

  // Fields as properties
  private TextField nameField;
  private Label nameLabel;
  private TextField priceField;
  private Label priceLabel;
  private ComboBox<String> speciesComboBox;
  private ComboBox<String> genderComboBox;
  private ComboBox<String> stateComboBox;
  private ComboBox<String> customerComboBox;
  private TextField ageField;
  private TextField colorField;
  private TextField commentsField;
  private Label ageLabel;
  private Label colorLabel;
  private Label commentsLabel;
  private Label errorLabel;
  private Label successLabel;
  private Label customerLabel;
  private Label speciesLabel;
  private Label genderLabel;
  private Label stateLabel;
  private final String textFont = "-fx-font-size: 16px;";
  private ArrayList<Customer> customers;
  private String customerFileName = "customers.dat";

  public AddAPetView(Pane addAPetPane)
  {
    addAPetPane.getChildren().clear();
    addAPetPane.setBackground(new Background(
        new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

    BorderPane borderPane = new BorderPane();

    // Initialize fields
    nameField = createTextField(addAPetPane, "Name:", 20, 60);
    nameLabel = createLabel(addAPetPane, "Name:", 20, 60,
        textFont);

    speciesComboBox = createComboBox(addAPetPane, 20, 100,
        Species.getSpeciesDisplayNamesList());
    speciesLabel = createLabel(addAPetPane, "Species:", 20, 100,
        textFont);


    genderComboBox = createComboBox(addAPetPane, 20, 140,
        Gender.getGenderDisplayNamesList());
    genderLabel = createLabel(addAPetPane, "Gender:", 20, 140,
        textFont);


    stateComboBox = createComboBox(addAPetPane, 20, 180,
        PetState.getPetStateDisplayName());
    stateLabel = createLabel(addAPetPane, "State:", 20, 180, textFont);



    ageField = createTextField(addAPetPane, "Age:", 20, 220);
    ageLabel = createLabel(addAPetPane, "Age:", 20, 220,
        textFont);
    colorField = createTextField(addAPetPane, "Color:", 20, 260);
    colorLabel = createLabel(addAPetPane, "Color:", 20, 260,
        textFont);
    commentsField = createTextField(addAPetPane, "Comment:", 20, 300);
    commentsLabel = createLabel(addAPetPane, "Comment:", 20, 300,
        textFont);


    errorLabel = createLabel(addAPetPane, "", 150, 390,
        "-fx-font-size: 14px; -fx-text-fill: red;");
    successLabel = createLabel(addAPetPane, "", 120, 390,
        "-fx-font-size: 14px; -fx-text-fill: green;");


    // Buttons
    Button submitButton = createButton(addAPetPane, "Submit", 210, 430,
        "-fx-font-size: 16px; -fx-background-color: green; -fx-text-fill: white;");
    Button resetButton = createButton(addAPetPane, "Reset", 140, 430,
        "-fx-font-size: 16px; -fx-background-color: red; -fx-text-fill: white;");
    backButton = createButton(addAPetPane, "Return", 0, 0,
        "-fx-font-size: 20px; -fx-background-color: white;");
    backButton.setPrefWidth(720);


    //conditional forms views

    priceField = createTextField(addAPetPane, "Price:", 20, 340);
    priceLabel = createLabel(addAPetPane, "Price:", 20, 340,
        textFont);
    priceField.setVisible(false);
    priceLabel.setVisible(false);

    customerLabel = createLabel(addAPetPane, "Customer:", 20, 340,
        textFont);
    customerComboBox = createComboBox(addAPetPane, 20, 340);
    customerComboBox.setVisible(false);
    customerLabel.setVisible(false);

    // Button Actions
    resetButton.setOnAction(e -> resetForm());
    submitButton.setOnAction(e -> handleSubmit());
    setupFormListeners();
  }

  private List<String> getCustomers()
  {
    //TODO use file
    List<String> customers = new ArrayList<>();
    customers.add("John");
    customers.add("Jane");
    return customers;
  }

  private void setupFormListeners()
  {
    stateComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
      // Check if the new value equals "For Sale"
      if (PetState.FORSALE.toString().equals(newVal)) {
        priceField.setVisible(true);
        priceLabel.setVisible(true);// Show the price field when "For Sale" is selected
        customerComboBox.setVisible(false);
        customerLabel.setVisible(false);
      } else {
        priceField.setVisible(false); // Hide the price field otherwise
        priceLabel.setVisible(false);
        customerLabel.setVisible(true);
        customerComboBox.setVisible(true);
      }
    });
  }

  public Button getBackButton()
  {
    return backButton;
  }

  // Method to create a label
  private Label createLabel(Pane pane, String text, int x, int y, String style)
  {
    Label label = new Label(text);
    label.setLayoutX(x);
    label.setLayoutY(y);
    label.setStyle(style);
    pane.getChildren().add(label);
    return label;
  }

  // Method to create a text field
  private TextField createTextField(Pane pane, String labelText, int x, int y)
  {
    TextField textField = new TextField();
    textField.setLayoutX(100);
    textField.setLayoutY(y);
    textField.setPrefWidth(220);
    pane.getChildren().add(textField);
    return textField;
  }

  // Method to create a combo box
  private ComboBox<String> createComboBox(Pane pane, int x,
      int y, String... items)
  {
    ComboBox<String> comboBox = new ComboBox<>();
    comboBox.setEditable(true);
    comboBox.setLayoutX(100);
    comboBox.setLayoutY(y);
    comboBox.setEditable(false);
    comboBox.setPrefWidth(220);
    comboBox.getItems().addAll(items);
    pane.getChildren().add(comboBox);
    return comboBox;
  }

  // Method to create a button
  private Button createButton(Pane pane, String text, int x, int y,
      String style)
  {
    Button button = new Button(text);
    button.setLayoutX(x);
    button.setLayoutY(y);
    button.setStyle(style);
    pane.getChildren().add(button);
    return button;
  }

  // Reset form method
  private void resetForm()
  {
    errorLabel.setText("");
    successLabel.setText("");
    nameField.setText("");
    speciesComboBox.setValue(null);
    stateComboBox.setValue(null);
    genderComboBox.setValue(null);
    ageField.setText("");
    colorField.setText("");
    commentsField.setText("");
    priceField.setText("");
    priceLabel.setVisible(false);
    priceField.setVisible(false);
    customerComboBox.setVisible(false);
    customerLabel.setVisible(false);
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

  // Submit button action
  private void handleSubmit() {
    resetLabels();
    if (!isValidInput()) {
      return;
    }

    try {
      createAndStorePet();
    } catch (NumberFormatException ex) {
      errorLabel.setText("Please enter valid numbers for age and price.");
    } catch (Exception ex) {
      errorLabel.setText("Error processing the form: " + ex.getMessage());
    }
  }

  private void resetLabels() {
    errorLabel.setText("");
    successLabel.setText("");
  }

  private boolean isValidInput() {
    String selectedSpecies = speciesComboBox.getValue();
    if (selectedSpecies == null) {
      errorLabel.setText("Please select a species.");
      return false;
    }

    String selectedGender = genderComboBox.getValue();
    if (selectedGender == null) {
      errorLabel.setText("Please select a gender.");
      return false;
    }

    if (isFieldEmpty(nameField)) {
      errorLabel.setText("Please enter a name.");
      return false;
    }

    if (isFieldEmpty(ageField)) {
      errorLabel.setText("Please enter an age.");
      return false;
    }

    if (isFieldEmpty(colorField)) {
      errorLabel.setText("Please enter a color.");
      return false;
    }

    String selectedState = stateComboBox.getValue();
    if (selectedState == null) {
      errorLabel.setText("Please select a state.");
      return false;
    }

    if (selectedState.equals(PetState.FORSALE.toString()) && isFieldEmpty(priceField)) {
      errorLabel.setText("Please enter a price.");
      return false;
    }

    if (selectedState.equals(PetState.OWNED.toString()) && (customerComboBox.getValue() == null)) {
      errorLabel.setText("Please select a customer.");
      return false;
    }

    return true;
  }

  private boolean isFieldEmpty(TextField field) {
    return field.getText() == null || field.getText().trim().isEmpty();
  }

  private void createAndStorePet() throws NumberFormatException, ClassNotFoundException, IOException {
    double age = Double.parseDouble(ageField.getText().trim());
    double price;

    if(stateComboBox.getValue().equals(PetState.FORSALE.toString()))
    {
      price = Double.parseDouble(priceField.getText().trim());
    } else {
      price = 0;
    }

    if (!isValidAgeAndPrice(age, price)) {
      return;
    }

    String selectedState = stateComboBox.getValue();
    boolean forSale = selectedState.equals(PetState.FORSALE.toString());
    Gender gender = Gender.valueOf(genderComboBox.getValue().toUpperCase());

    Pet pet = PetFactory.createPet(
        Species.valueOf(speciesComboBox.getValue().toUpperCase()),
        nameField.getText(), gender, age, colorField.getText(),
        commentsField.getText(), "photo.url", forSale, "john");

    pet.setForSale(forSale, price);
    if(!forSale) {
      pet.setOwnerName(customerComboBox.getValue());
      CustomerListContainer customerListContainer = new CustomerListContainer(FileHelper.loadFromFile(customerFileName));
      customerListContainer.getCustomer(customerComboBox.getValue());
      FileHelper.saveToFile(customerFileName, customerListContainer.getAllCustomers());

    }

    PetListContainer petListContainer = new PetListContainer(FileHelper.loadFromFile(fileName));
    petListContainer.addPet(pet);


    FileHelper.saveToFile(fileName, petListContainer.getAllPets());

    System.out.println(petListContainer.getAllPets());
    resetForm();
    successLabel.setText("Pet successfully added");
  }

  private boolean isValidAgeAndPrice(double age, double price) {
    if (age <= 0) {
      errorLabel.setText("Age must be a positive number.");
      return false;
    } else if (age > 100) {
      errorLabel.setText("Age can't be higher than 100.");
      return false;
    } else if (price <= 0 && stateComboBox.getValue().equals(PetState.FORSALE.toString())) {
      errorLabel.setText("Price must be a positive number.");
      return false;
    }
    return true;
  }




  public void refresh()
  {
    resetForm();
    loadCustomersAndPopulateComboBox();
  }
}
