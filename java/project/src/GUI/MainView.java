package GUI;

import GUI.Customers.AddACustomerView;
import GUI.Customers.ListOfCustomersView;
import GUI.Kennel.AddBookingView;
import GUI.Kennel.ViewBookingView;
import GUI.Pets.AddAPetView;
import GUI.Pets.ListOfPetsView;
import GUI.Petshop.PetsForSaleView;
import GUI.Petshop.SellAPetView;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class MainView extends Application {
    public void start(Stage primaryStage) {
        Pane mainPane = new Pane();
        mainPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Button button1 = new Button("Kennel");
        Button button2 = new Button("Pet Shop");
        Button button3 = new Button("Pets");
        Button button4 = new Button("Customers");

        button1.setStyle("-fx-font-size: 25px; -fx-background-color: white");
        button2.setStyle("-fx-font-size: 25px; -fx-background-color: white");
        button3.setStyle("-fx-font-size: 25px; -fx-background-color: white");
        button4.setStyle("-fx-font-size: 25px; -fx-background-color: white");

        button1.setPrefSize(200, 200);
        button1.setLayoutX(150);
        button1.setLayoutY(30);

        button2.setPrefSize(200, 200);
        button2.setLayoutX(390);
        button2.setLayoutY(30);

        button3.setPrefSize(200, 200);
        button3.setLayoutX(150);
        button3.setLayoutY(260);

        button4.setPrefSize(200, 200);
        button4.setLayoutX(390);
        button4.setLayoutY(260);

        mainPane.getChildren().addAll(button1, button2, button3, button4);
        Scene mainScene = new Scene(mainPane, 720, 500);

        //Kennel
        Pane kennelPane = new Pane();
        kennelPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button kennelButton1 = new Button("Add Booking");
        Button kennelButton2 = new Button("List of Bookings");
        Button kennelBackButton = new Button("Back to Main Page");

        kennelButton1.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        kennelButton2.setStyle("-fx-font-size: 20px; -fx-background-color: white");

        kennelButton1.setPrefSize(200, 200);
        kennelButton1.setLayoutX(140);
        kennelButton1.setLayoutY(150);

        kennelButton2.setPrefSize(200, 200);
        kennelButton2.setLayoutX(380);
        kennelButton2.setLayoutY(150);

        kennelBackButton.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        kennelBackButton.setAlignment(Pos.TOP_CENTER);
        kennelBackButton.setPrefWidth(720);
        kennelPane.getChildren().addAll(kennelButton1, kennelButton2, kennelBackButton);
        Scene kennelScene = new Scene(kennelPane, 720, 500);

        Pane kennel1Pane = new Pane();
        Scene kennel1Scene = new Scene(kennel1Pane, 720, 500);
        Pane kennel2Pane = new Pane();
        Scene kennel2Scene = new Scene(kennel2Pane, 720, 500);

        //Add Booking (Kennel)
        AddBookingView addBookingView = new AddBookingView(kennel1Pane);
        addBookingView.getBackButton().setOnAction(e -> {primaryStage.setScene(kennelScene);});

        //View Bookings (Kennel)
        ViewBookingView viewBookingView = new ViewBookingView(kennel2Pane);
        viewBookingView.getBackButton().setOnAction(e -> {primaryStage.setScene(kennelScene);});

        //Petshop
        Pane petshopPane = new Pane();
        petshopPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button petshopButton1 = new Button("Sell a pet");
        Button petshopButton2 = new Button("Pets for sale");
        Button petshopBackButton = new Button("Back to Main Page");

        petshopButton1.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        petshopButton2.setStyle("-fx-font-size: 20px; -fx-background-color: white");

        petshopButton1.setPrefSize(200, 200);
        petshopButton1.setLayoutX(140);
        petshopButton1.setLayoutY(150);

        petshopButton2.setPrefSize(200, 200);
        petshopButton2.setLayoutX(380);
        petshopButton2.setLayoutY(150);

        petshopBackButton.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        petshopBackButton.setAlignment(Pos.TOP_CENTER);
        petshopBackButton.setPrefWidth(720);
        petshopPane.getChildren().addAll(petshopButton1, petshopButton2, petshopBackButton);
        Scene petshopScene = new Scene(petshopPane, 720, 500);

        Pane petshop1Pane = new Pane();
        Scene petshop1Scene = new Scene(petshop1Pane, 720, 500);
        Pane petshop2Pane = new Pane();
        Scene petshop2Scene = new Scene(petshop2Pane, 720, 500);

        //Sell a pet
        SellAPetView sellAPetView = new SellAPetView(petshop1Pane);
        sellAPetView.getBackButton().setOnAction(e -> {primaryStage.setScene(petshopScene);});

        //List of pets for sale
        PetsForSaleView petsForSaleView = new PetsForSaleView(petshop2Pane);
        petsForSaleView.getBackButton().setOnAction(e -> {primaryStage.setScene(petshopScene);});

        //Pets
        Pane petsPane = new Pane();
        petsPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button petsButton1 = new Button("Add a pet");
        Button petsButton2 = new Button("List of pets");
        Button petsBackButton = new Button("Back to Main Page");

        petsButton1.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        petsButton2.setStyle("-fx-font-size: 20px; -fx-background-color: white");

        petsButton1.setPrefSize(200, 200);
        petsButton1.setLayoutX(140);
        petsButton1.setLayoutY(150);

        petsButton2.setPrefSize(200, 200);
        petsButton2.setLayoutX(380);
        petsButton2.setLayoutY(150);

        petsBackButton.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        petsBackButton.setAlignment(Pos.TOP_CENTER);
        petsBackButton.setPrefWidth(720);
        petsPane.getChildren().addAll(petsButton1, petsButton2, petsBackButton);
        Scene petsScene = new Scene(petsPane, 720, 500);

        Pane pets1Pane = new Pane();
        Scene pets1Scene = new Scene(pets1Pane, 720, 500);
        Pane pets2Pane = new Pane();
        Scene pets2Scene = new Scene(pets2Pane, 720, 500);

        //Add a pet
        AddAPetView addAPetView = new AddAPetView(pets1Pane);
        addAPetView.getBackButton().setOnAction(e -> {primaryStage.setScene(petsScene);
            addAPetView.refresh();
        });

        //List of pets
        ListOfPetsView listOfPetsView = new ListOfPetsView(pets2Pane);
        listOfPetsView.getBackButton().setOnAction(e -> {primaryStage.setScene(petsScene);
            listOfPetsView.refresh();
        });

        //Customers
        Pane customersPane = new Pane();
        customersPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button customersButton1 = new Button("Add a customer");
        Button customersButton2 = new Button("List of customers");
        Button customersBackButton = new Button("Back to Main Page");

        customersButton1.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        customersButton2.setStyle("-fx-font-size: 20px; -fx-background-color: white");

        customersButton1.setPrefSize(200, 200);
        customersButton1.setLayoutX(140);
        customersButton1.setLayoutY(150);

        customersButton2.setPrefSize(200, 200);
        customersButton2.setLayoutX(380);
        customersButton2.setLayoutY(150);

        customersBackButton.setStyle("-fx-font-size: 20px; -fx-background-color: white");
        customersBackButton.setAlignment(Pos.TOP_CENTER);
        customersBackButton.setPrefWidth(720);

        customersPane.getChildren().addAll(customersButton1, customersButton2, customersBackButton);
        Scene customersScene = new Scene(customersPane, 720, 500);

        Pane customers1Pane = new Pane();
        Scene customers1Scene = new Scene(customers1Pane, 720, 500);
        Pane customers2Pane = new Pane();
        Scene customers2Scene = new Scene(customers2Pane, 720, 500);

        //Add a customer
        AddACustomerView addACustomer = new AddACustomerView(customers1Pane);
        addACustomer.getBackButton().setOnAction(e -> {primaryStage.setScene(customersScene);});

        //List of customers
        ListOfCustomersView listOfCustomersView = new ListOfCustomersView(customers2Pane);
        listOfCustomersView.getBackButton().setOnAction(e -> {primaryStage.setScene(customersScene);});

        button1.setOnAction(e -> {primaryStage.setScene(kennelScene);primaryStage.setTitle("Kennel Management");});
        button2.setOnAction(e -> {primaryStage.setScene(petshopScene);primaryStage.setTitle("Petshop Management");});
        button3.setOnAction(e -> {primaryStage.setScene(petsScene);primaryStage.setTitle("Pets Management");});
        button4.setOnAction(e -> {primaryStage.setScene(customersScene);primaryStage.setTitle("Customers Management");});

        //Petshop
        petshopButton1.setOnAction(e -> {primaryStage.setScene(petshop1Scene);
            sellAPetView.refresh();
        });
        petshopButton2.setOnAction(e -> {primaryStage.setScene(petshop2Scene);
            petsForSaleView.refresh();
        });

        //Pets
        petsButton1.setOnAction(e -> {primaryStage.setScene(pets1Scene);
            addAPetView.refresh();
        });
        petsButton2.setOnAction(e -> {primaryStage.setScene(pets2Scene);
            listOfPetsView.refresh();
        });

        //kennel
        kennelButton1.setOnAction(e -> {primaryStage.setScene(kennel1Scene);});
        kennelButton2.setOnAction(e -> {primaryStage.setScene(kennel2Scene);});

        //customers
        customersButton1.setOnAction(e -> {primaryStage.setScene(customers1Scene);});
        customersButton2.setOnAction(e -> {primaryStage.setScene(customers2Scene);
            listOfCustomersView.refresh();
        });

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