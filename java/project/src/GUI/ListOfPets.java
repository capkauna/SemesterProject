import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ListOfPets {
    private final Button backButton;

    public ListOfPets(Pane listOfPetsPane) {
        listOfPetsPane.getChildren().clear();
        listOfPetsPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));



        backButton = new Button("Return");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: white;");
        backButton.setPrefWidth(420);
        listOfPetsPane.getChildren().add(backButton);
    }
    public Button getBackButton() {
        return backButton;
    }
}
