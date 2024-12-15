package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ListOfCustomers {
    private final Button backButton;

    public ListOfCustomers(Pane listOfCustomersPane) {
        listOfCustomersPane.getChildren().clear();
        listOfCustomersPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));



        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);
        listOfCustomersPane.getChildren().add(backButton);
    }
    public Button getBackButton() {
        return backButton;
    }
}
