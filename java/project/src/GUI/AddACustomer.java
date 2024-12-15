package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class AddACustomer {
    private final Button backButton;

    public AddACustomer(Pane addACustomerPane) {
        addACustomerPane.getChildren().clear();
        addACustomerPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        //name
        Label nameLabel = new Label("Name:");
        nameLabel.setLayoutX(20);
        nameLabel.setLayoutY(60);
        nameLabel.setStyle("-fx-font-size: 16px;");
        addACustomerPane.getChildren().add(nameLabel);

        TextField nameField = new TextField();
        nameField.setLayoutX(20);
        nameField.setLayoutY(90);
        nameField.setPrefWidth(380);
        addACustomerPane.getChildren().add(nameField);

        //Phone number
        Label nrLabel = new Label("Phone Nr.:");
        nrLabel.setLayoutX(20);
        nrLabel.setLayoutY(120);
        nrLabel.setStyle("-fx-font-size: 16px;");
        addACustomerPane.getChildren().add(nrLabel);

        TextField nrField = new TextField();
        nrField.setLayoutX(20);
        nrField.setLayoutY(150);
        nrField.setPrefWidth(380);
        addACustomerPane.getChildren().add(nrField);

        //adress
        Label adressLabel = new Label("Adress:");
        adressLabel.setLayoutX(20);
        adressLabel.setLayoutY(180);
        adressLabel.setStyle("-fx-font-size: 16px;");
        addACustomerPane.getChildren().add(adressLabel);

        TextField adressField = new TextField();
        adressField.setLayoutX(20);
        adressField.setLayoutY(210);
        adressField.setPrefWidth(380);
        addACustomerPane.getChildren().add(adressField);

        //e-mail
        Label emailLabel = new Label("E-mail:");
        emailLabel.setLayoutX(20);
        emailLabel.setLayoutY(240);
        emailLabel.setStyle("-fx-font-size: 16px;");
        addACustomerPane.getChildren().add(emailLabel);

        TextField emailField = new TextField();
        emailField.setLayoutX(20);
        emailField.setLayoutY(270);
        emailField.setPrefWidth(380);
        addACustomerPane.getChildren().add(emailField);

        // Output
        Label resultLabel = new Label();
        resultLabel.setLayoutX(150);
        resultLabel.setLayoutY(310);
        resultLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: red;");
        addACustomerPane.getChildren().add(resultLabel);

        Label resultLabel2 = new Label();
        resultLabel2.setLayoutX(120);
        resultLabel2.setLayoutY(310);
        resultLabel2.setStyle("-fx-font-size: 14px; -fx-text-fill: green;");
        addACustomerPane.getChildren().add(resultLabel2);

        // Submit
        Button submitButton = new Button("Submit");
        submitButton.setLayoutX(210);
        submitButton.setLayoutY(350);
        submitButton.setStyle("-fx-font-size: 16px; -fx-background-color: green; -fx-text-fill: white;");
        addACustomerPane.getChildren().add(submitButton);

        Button resetButton = new Button("Reset");
        resetButton.setLayoutX(140);
        resetButton.setLayoutY(350);
        resetButton.setStyle("-fx-font-size: 16px; -fx-background-color: red; -fx-text-fill: white;");
        addACustomerPane.getChildren().add(resetButton);

        // Reset
        resetButton.setOnAction(e -> {
            resultLabel.setText("");
            resultLabel2.setText("");
            nameLabel.setText("");
            nrLabel.setText("");
            adressLabel.setText("");
            emailLabel.setText("");
        });

        // Submit
        submitButton.setOnAction(e -> {
            String nameText = nameField.getText();
            String nrText = nrField.getText();
            String adressText = adressField.getText();
            String emailText = emailField.getText();


                if (nameText == null || nameText.trim().isEmpty()) {
                    resultLabel.setText("Please enter a name.");
                }
                else if (nrText == null || nrText.trim().isEmpty()) {
                    resultLabel.setText("Please enter a phone number.");
                }
                else if (adressText == null || adressText.trim().isEmpty()) {
                    resultLabel.setText("Enter an adress.");
                }
                else if (emailText == null || emailText.trim().isEmpty()) {
                    resultLabel.setText("Enter a color.");
                }
                else {
                    try {
                        double nr = Double.parseDouble(nrField.getText().trim());
                        if (nr <= 0) {
                            resultLabel.setText("Phone number must be a positive number.");
                        } else if (nr > 999999999) {
                            resultLabel.setText("Phone number can't be that long :)");
                        }
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Phone number can't contain letters.");
                    }
                }
            });
        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);
        addACustomerPane.getChildren().add(backButton);
    }
    public Button getBackButton() {
        return backButton;
    }
}
