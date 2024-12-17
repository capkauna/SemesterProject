package GUI.Pets;

import Data.*;
import Data.Gender;
import Data.AnimalDTO.Pet;
import Data.AnimalDTO.PetFactory;
import Data.Species;
import GUI.FileHelper;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;

public class AddAPetView
{
  private final String fileName = "pets.dat";
  private final Button backButton;

  // Fields as properties
  private TextField nameField;
  private Label nameLabel;
  private TextField priceField;
  private Label priceLabel;
  private ComboBox<String> petComboBox;
  private ComboBox<String> genderComboBox;
  private ComboBox<String> stateComboBox;
  private TextField ageField;
  private TextField colorField;
  private TextField commentsField;
  private Label ageLabel;
  private Label colorLabel;
  private Label commentsLabel;
  private Label errorLabel;
  private Label successLabel;

  private final String textFont = "-fx-font-size: 16px;";

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

    petComboBox = createComboBox(addAPetPane, "Species:", 20, 100,
        Species.getSpeciesDisplayNamesList());
    genderComboBox = createComboBox(addAPetPane, "Gender:", 20, 140,
        Gender.getGenderDisplayNamesList());
    stateComboBox = createComboBox(addAPetPane, "State:", 20, 180,
        PetState.getPetStateDisplayName());




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

    // Button Actions
    resetButton.setOnAction(e -> resetForm());
    submitButton.setOnAction(e -> handleSubmit());
    setupFormListeners();
  }

  private void setupFormListeners()
  {
    stateComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
      // Check if the new value equals "For Sale"
      if (PetState.FORSALE.toString().equals(newVal)) {
        priceField.setVisible(true);
        priceLabel.setVisible(true);// Show the price field when "For Sale" is selected
      } else {
        priceField.setVisible(false); // Hide the price field otherwise
        priceLabel.setVisible(false);
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
  private ComboBox<String> createComboBox(Pane pane, String labelText, int x,
      int y, String... items)
  {
    createLabel(pane, labelText, x, y, "-fx-font-size: 16px;");
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
    petComboBox.setValue(null);
    stateComboBox.setValue(null);
    genderComboBox.setValue(null);
    ageField.setText("");
    colorField.setText("");
    commentsField.setText("");
    priceField.setText("");
  }

  // Submit button action
  private void handleSubmit()
  {
    errorLabel.setText("");
    successLabel.setText("");

    String selectedSpecies = petComboBox.getValue();
    String selectedGender = genderComboBox.getValue();
    String selectedState = stateComboBox.getValue();

    if (selectedSpecies == null)
    {
      errorLabel.setText("Please select species.");
    }
    else if (selectedGender == null)
    {
      errorLabel.setText("Please select a gender.");
    }
    else if (nameField.getText() == null || nameField.getText().trim()
        .isEmpty())
    {
      errorLabel.setText("Please enter a name.");
    }
    else if (ageField.getText() == null || ageField.getText().trim().isEmpty())
    {
      errorLabel.setText("Enter an age.");
    }
    else if (colorField.getText() == null || colorField.getText().trim()
        .isEmpty())
    {
      errorLabel.setText("Enter a color.");
    }
    else if (selectedState == null)
    {
      errorLabel.setText("Please select a state.");
    } else if (selectedState.equals(PetState.FORSALE.toString()) && (priceField.getText() == null || priceField.getText().trim().isEmpty()))
    {
      errorLabel.setText("Please enter a price.");
    }
    else
    {
      try
      {
        double age = Double.parseDouble(ageField.getText().trim());
        double price = Double.parseDouble(priceField.getText().trim());
        if (age <= 0)
        {
          errorLabel.setText("Age must be a positive number.");
        }
        else if (age > 100)
        {
          errorLabel.setText("Age can't be higher than 100.");
        } else if (price <= 0)
        {
          errorLabel.setText("Price must be a positive number.");
        }
        else
        {
          boolean forSale;
          //TODO use strong types enums not check with strings
          forSale = selectedState.equals(PetState.FORSALE.toString());

          Gender gender = Gender.valueOf(selectedGender.toUpperCase());

          //TODO how to handle many instances
          Pet pet = PetFactory.createPet(
              Species.valueOf(selectedSpecies.toUpperCase()),
              nameField.getText(), gender, age, colorField.getText(),
              commentsField.getText(), "photo.url", forSale, "john");

          pet.setForSale(forSale, price);
          PetListContainer listContainer = new PetListContainer(
              FileHelper.loadFromFile(fileName));

          listContainer.addPet(pet);
          System.out.println(listContainer.getAllPets());
          FileHelper.saveToFile(fileName, listContainer.getAllPets());

          resetForm();
          errorLabel.setText("");
          successLabel.setText("Pet successfully added");
        }
      }
      catch (NumberFormatException ex)
      {
        errorLabel.setText("Age must be a number.");
      }
      catch (ClassNotFoundException | IOException ex)
      {
        errorLabel.setText("Error saving pet.");
      }
    }
  }

  public void refresh()
  {
    resetForm();
  }
}
