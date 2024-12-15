package GUI.Petshop;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class PetsForSaleView
{
    private final Button backButton;
    // A ListView to display pet names

    public PetsForSaleView(Pane sellAPetPane) {
        sellAPetPane.getChildren().clear();
        sellAPetPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));


        // Create and style ListView for customers


        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);
        sellAPetPane.getChildren().add(backButton);
    }
    public Button getBackButton() {
        return backButton;
    }
}

