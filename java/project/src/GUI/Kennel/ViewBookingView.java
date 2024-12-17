package GUI.Kennel;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class ViewBookingView
{

    private final Button backButton; // Back button reference

    public ViewBookingView(Pane viewBookingPane) {
        // Clear existing children to repurpose the Pane
        viewBookingPane.getChildren().clear();
        viewBookingPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));


        // Back Button
        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);
        viewBookingPane.getChildren().add(backButton);
    }
    public Button getBackButton() {
        return backButton;
    }
}