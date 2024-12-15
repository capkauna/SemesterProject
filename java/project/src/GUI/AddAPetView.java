package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class AddAPetView
{
    private final Button backButton;

    public AddAPetView(Pane addAPetPane) {
        addAPetPane.getChildren().clear();
        addAPetPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        // Name
        Label nameLabel = new Label("Name:");
        nameLabel.setLayoutX(20);
        nameLabel.setLayoutY(60);
        nameLabel.setStyle("-fx-font-size: 16px;");
        addAPetPane.getChildren().add(nameLabel);

        TextField nameField = new TextField();
        nameField.setLayoutX(100);
        nameField.setLayoutY(60);
        nameField.setPrefWidth(220);
        addAPetPane.getChildren().add(nameField);

        // Species
        Label speciesLabel = new Label("Species:");
        speciesLabel.setLayoutX(20);
        speciesLabel.setLayoutY(100);
        speciesLabel.setStyle("-fx-font-size: 16px;");
        addAPetPane.getChildren().add(speciesLabel);

        ComboBox<String> petComboBox = new ComboBox<>();
        petComboBox.setEditable(true);
        petComboBox.setLayoutX(100);
        petComboBox.setLayoutY(100);
        petComboBox.setPrefWidth(220);

        petComboBox.getItems().addAll("cat", "dog", "fish", "bird", "rodents", "various");
        addAPetPane.getChildren().add(petComboBox);

        // Gender
        Label genderLabel = new Label("Gender:");
        genderLabel.setLayoutX(20);
        genderLabel.setLayoutY(140);
        genderLabel.setStyle("-fx-font-size: 16px;");
        addAPetPane.getChildren().add(genderLabel);

        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.setEditable(true);
        genderComboBox.setLayoutX(100);
        genderComboBox.setLayoutY(140);
        genderComboBox.setPrefWidth(220);

        genderComboBox.getItems().addAll("male", "female", "undefined");
        addAPetPane.getChildren().add(genderComboBox);

        // Age
        Label ageLabel = new Label("Age:");
        ageLabel.setLayoutX(20);
        ageLabel.setLayoutY(180);
        ageLabel.setStyle("-fx-font-size: 16px;");
        addAPetPane.getChildren().add(ageLabel);

        TextField ageField = new TextField();
        ageField.setLayoutX(100);
        ageField.setLayoutY(180);
        ageField.setPrefWidth(220);
        addAPetPane.getChildren().add(ageField);

        // Color
        Label colorLabel = new Label("Color:");
        colorLabel.setLayoutX(20);
        colorLabel.setLayoutY(220);
        colorLabel.setStyle("-fx-font-size: 16px;");
        addAPetPane.getChildren().add(colorLabel);

        TextField colorField = new TextField();
        colorField.setLayoutX(100);
        colorField.setLayoutY(220);
        colorField.setPrefWidth(220);
        addAPetPane.getChildren().add(colorField);

        // Comments
        Label commentsLabel = new Label("Comment:");
        commentsLabel.setLayoutX(20);
        commentsLabel.setLayoutY(260);
        commentsLabel.setStyle("-fx-font-size: 16px;");
        addAPetPane.getChildren().add(commentsLabel);

        TextField commentsField = new TextField();
        commentsField.setLayoutX(100);
        commentsField.setLayoutY(260);
        commentsField.setPrefWidth(220);
        addAPetPane.getChildren().add(commentsField);

        // Output
        Label resultLabel = new Label();
        resultLabel.setLayoutX(150);
        resultLabel.setLayoutY(310);
        resultLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: red;");
        addAPetPane.getChildren().add(resultLabel);

        Label resultLabel2 = new Label();
        resultLabel2.setLayoutX(120);
        resultLabel2.setLayoutY(310);
        resultLabel2.setStyle("-fx-font-size: 14px; -fx-text-fill: green;");
        addAPetPane.getChildren().add(resultLabel2);

        // Submit
        Button submitButton = new Button("Submit");
        submitButton.setLayoutX(210);
        submitButton.setLayoutY(350);
        submitButton.setStyle("-fx-font-size: 16px; -fx-background-color: green; -fx-text-fill: white;");
        addAPetPane.getChildren().add(submitButton);

        // Reset
        Button resetButton = new Button("Reset");
        resetButton.setLayoutX(140);
        resetButton.setLayoutY(350);
        resetButton.setStyle("-fx-font-size: 16px; -fx-background-color: red; -fx-text-fill: white;");
        addAPetPane.getChildren().add(resetButton);

        resetButton.setOnAction(e -> {
            resultLabel.setText("");
            resultLabel2.setText("");
            nameField.setText("");
            petComboBox.setValue(null);
            genderComboBox.setValue(null);
            ageField.setText("");
            colorField.setText("");
            commentsField.setText("");

        });
        submitButton.setOnAction(e -> {
            resultLabel.setText("");
            resultLabel2.setText("");
            String selectedPet = petComboBox.getValue();
            String selectedGender = genderComboBox.getValue();

            if (selectedPet == null) {
                resultLabel.setText("Please select species.");
            } else if (selectedGender == null) {
                resultLabel.setText("Please select a gender.");
            } else if (nameField.getText() == null || nameField.getText().trim().isEmpty()) {
                resultLabel.setText("Please enter a name.");
            } else if (ageField.getText() == null || ageField.getText().trim().isEmpty()) {
                resultLabel.setText("Enter an age.");
            } else if (colorField.getText() == null || colorField.getText().trim().isEmpty()) {
                resultLabel.setText("Enter a color.");
            } else {
                try {
                    double age = Double.parseDouble(ageField.getText().trim());
                    if (age <= 0) {
                        resultLabel.setText("Age must be a positive number.");
                    } else if (age > 100) {
                        resultLabel.setText("Age can't be higher than 100.");
                    } else {
                        resultLabel.setText("");
                        resultLabel2.setText("Pet successfully added");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Age must be a number.");
                }
            }
        });
        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);
        addAPetPane.getChildren().add(backButton);
    }
    public Button getBackButton() {
        return backButton;
    }
}
