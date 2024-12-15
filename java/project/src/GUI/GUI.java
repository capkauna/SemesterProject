package GUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class GUI extends Application {
    public void start(Stage primaryStage) {
        Pane mainPane = new Pane();
        mainPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Button button1 = new Button("Kennel");
        Button button2 = new Button("Petshop");
        Button button3 = new Button("Pets");
        Button button4 = new Button("Customers");

        button1.setStyle("-fx-font-size: 25px; -fx-background-color: white");
        button2.setStyle("-fx-font-size: 25px; -fx-background-color: white");
        button3.setStyle("-fx-font-size: 25px; -fx-background-color: white");
        button4.setStyle("-fx-font-size: 25px; -fx-background-color: white");

        button1.setPrefSize(180, 180);
        button1.setLayoutX(20);
        button1.setLayoutY(20);

        button2.setPrefSize(180, 180);
        button2.setLayoutX(220);
        button2.setLayoutY(20);

        button3.setPrefSize(180, 180);
        button3.setLayoutX(20);
        button3.setLayoutY(220);

        button4.setPrefSize(180, 180);
        button4.setLayoutX(220);
        button4.setLayoutY(220);

        mainPane.getChildren().addAll(button1, button2, button3, button4);
        Scene mainScene = new Scene(mainPane, 420, 420);

        //Kennel
        Pane kennelPane = new Pane();
        kennelPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button kennelButton1 = new Button("Add Booking");
        Button kennelButton2 = new Button("View Bookings");
        Button kennelBackButton = new Button("Back to Main Page");

        kennelButton1.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        kennelButton2.setStyle("-fx-font-size: 20px; -fx-background-color: white");

        kennelButton1.setPrefSize(180, 180);
        kennelButton1.setLayoutX(20);
        kennelButton1.setLayoutY(100);

        kennelButton2.setPrefSize(180, 180);
        kennelButton2.setLayoutX(220);
        kennelButton2.setLayoutY(100);

        kennelBackButton.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        kennelBackButton.setAlignment(Pos.TOP_CENTER);
        kennelBackButton.setPrefWidth(420);
        kennelPane.getChildren().addAll(kennelButton1, kennelButton2, kennelBackButton);
        Scene kennelScene = new Scene(kennelPane, 420, 420);

        Pane kennel1Pane = new Pane();
        Scene kennel1Scene = new Scene(kennel1Pane, 420, 420);
        Pane kennel2Pane = new Pane();
        Scene kennel2Scene = new Scene(kennel2Pane, 420, 420);

        //Add Booking (Kennel)
        AddBooking addBooking = new AddBooking(kennel1Pane);
        addBooking.getBackButton().setOnAction(e -> {primaryStage.setScene(kennelScene);});

        //View Bookings (Kennel)
        ViewBooking viewBooking = new ViewBooking(kennel2Pane);
        viewBooking.getBackButton().setOnAction(e -> {primaryStage.setScene(kennelScene);});

        //Petshop
        Pane petshopPane = new Pane();
        petshopPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button petshopButton1 = new Button("Sell a pet");
        Button petshopButton2 = new Button("Pets for sale");
        Button petshopBackButton = new Button("Back to Main Page");

        petshopButton1.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        petshopButton2.setStyle("-fx-font-size: 20px; -fx-background-color: white");

        petshopButton1.setPrefSize(180, 180);
        petshopButton1.setLayoutX(20);
        petshopButton1.setLayoutY(100);

        petshopButton2.setPrefSize(180, 180);
        petshopButton2.setLayoutX(220);
        petshopButton2.setLayoutY(100);

        petshopBackButton.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        petshopBackButton.setAlignment(Pos.TOP_CENTER);
        petshopBackButton.setPrefWidth(420);
        petshopPane.getChildren().addAll(petshopButton1, petshopButton2, petshopBackButton);
        Scene petshopScene = new Scene(petshopPane, 420, 420);

        Pane petshop1Pane = new Pane();
        Scene petshop1Scene = new Scene(petshop1Pane, 420, 420);
        Pane petshop2Pane = new Pane();
        Scene petshop2Scene = new Scene(petshop2Pane, 420, 420);

        //Sell a pet
        SellAPet sellAPet = new SellAPet(petshop1Pane);
        sellAPet.getBackButton().setOnAction(e -> {primaryStage.setScene(petshopScene);});

        //List of pets for sale
        PetsForSale petsForSale = new PetsForSale(petshop2Pane);
        petsForSale.getBackButton().setOnAction(e -> {primaryStage.setScene(petshopScene);});

        //Pets
        Pane petsPane = new Pane();
        petsPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button petsButton1 = new Button("Add a pet");
        Button petsButton2 = new Button("List of pets");
        Button petsBackButton = new Button("Back to Main Page");

        petsButton1.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        petsButton2.setStyle("-fx-font-size: 20px; -fx-background-color: white");

        petsButton1.setPrefSize(180, 180);
        petsButton1.setLayoutX(20);
        petsButton1.setLayoutY(100);

        petsButton2.setPrefSize(180, 180);
        petsButton2.setLayoutX(220);
        petsButton2.setLayoutY(100);

        petsBackButton.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        petsBackButton.setAlignment(Pos.TOP_CENTER);
        petsBackButton.setPrefWidth(420);
        petsPane.getChildren().addAll(petsButton1, petsButton2, petsBackButton);
        Scene petsScene = new Scene(petsPane, 420, 420);

        Pane pets1Pane = new Pane();
        Scene pets1Scene = new Scene(pets1Pane, 420, 420);
        Pane pets2Pane = new Pane();
        Scene pets2Scene = new Scene(pets2Pane, 420, 420);

        //Add a pet
        AddAPet addAPet = new AddAPet(pets1Pane);
        addAPet.getBackButton().setOnAction(e -> {primaryStage.setScene(petsScene);});

        //List of pets
        ListOfPets listOfPets = new ListOfPets(pets2Pane);
        listOfPets.getBackButton().setOnAction(e -> {primaryStage.setScene(petsScene);});

        //Customers
        Pane customersPane = new Pane();
        customersPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button customersButton1 = new Button("Add a customer");
        Button customersButton2 = new Button("List of customers");
        Button customersBackButton = new Button("Back to Main Page");

        customersButton1.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        customersButton2.setStyle("-fx-font-size: 20px; -fx-background-color: white");

        customersButton1.setPrefSize(180, 180);
        customersButton1.setLayoutX(20);
        customersButton1.setLayoutY(100);

        customersButton2.setPrefSize(180, 180);
        customersButton2.setLayoutX(220);
        customersButton2.setLayoutY(100);

        customersBackButton.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        customersBackButton.setAlignment(Pos.TOP_CENTER);
        customersBackButton.setPrefWidth(420);

        customersPane.getChildren().addAll(customersButton1, customersButton2, customersBackButton);
        Scene customersScene = new Scene(customersPane, 420, 420);

        Pane customers1Pane = new Pane();
        Scene customers1Scene = new Scene(customers1Pane, 420, 420);
        Pane customers2Pane = new Pane();
        Scene customers2Scene = new Scene(customers2Pane, 420, 420);

        //Add a customer
        AddACustomer addACustomer = new AddACustomer(customers1Pane);
        addACustomer.getBackButton().setOnAction(e -> {primaryStage.setScene(customersScene);});

        //List of customers
        ListOfCustomers listOfCustomers = new ListOfCustomers(customers2Pane);
        listOfCustomers.getBackButton().setOnAction(e -> {primaryStage.setScene(customersScene);});

        button1.setOnAction(e -> {primaryStage.setScene(kennelScene);primaryStage.setTitle("Kennel Management");});
        button2.setOnAction(e -> {primaryStage.setScene(petshopScene);primaryStage.setTitle("Petshop Management");});
        button3.setOnAction(e -> {primaryStage.setScene(petsScene);primaryStage.setTitle("Pets Management");});
        button4.setOnAction(e -> {primaryStage.setScene(customersScene);primaryStage.setTitle("Customers Management");});

        //Petshop
        petshopButton1.setOnAction(e -> {primaryStage.setScene(petshop1Scene);});
        petshopButton2.setOnAction(e -> {primaryStage.setScene(petshop2Scene);});

        //Pets
        petsButton1.setOnAction(e -> {primaryStage.setScene(pets1Scene);});
        petsButton2.setOnAction(e -> {primaryStage.setScene(pets2Scene);});

        //kennel
        kennelButton1.setOnAction(e -> {primaryStage.setScene(kennel1Scene);});
        kennelButton2.setOnAction(e -> {primaryStage.setScene(kennel2Scene);});

        //customers
        customersButton1.setOnAction(e -> {primaryStage.setScene(customers1Scene);});
        customersButton2.setOnAction(e -> {primaryStage.setScene(customers2Scene);});

        kennelBackButton.setOnAction(e -> {primaryStage.setScene(mainScene);primaryStage.setTitle("");});
        petshopBackButton.setOnAction(e -> {primaryStage.setScene(mainScene);primaryStage.setTitle("");});
        petsBackButton.setOnAction(e -> {primaryStage.setScene(mainScene);primaryStage.setTitle("");});
        customersBackButton.setOnAction(e -> {primaryStage.setScene(mainScene);primaryStage.setTitle("");});

        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("pets.png")));
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}