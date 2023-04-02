package journal;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class addTrip implements EventHandler<ActionEvent>{

    static TextField trip;
    static TextField tripLocation;
    static Button addTrip = new Button("Add Trip to the List");

    public void display(String title){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        GridPane gridPane = new GridPane();

        BorderPane borderPane = new BorderPane();
        Text direction = new Text("Enter your thoughts about the trip!");
        HBox hBox = new HBox(10);
        borderPane.setTop(hBox);
        //addTrip = new Button("Add Trip");
        Button close = new Button("Close");
        close.setOnAction( e -> window.close());
        addTrip.setOnAction(this);

        tripLocation = new TextField();
        tripLocation.setPromptText("where was your trip to?");
        tripLocation.setPrefSize(200,50);
        trip = new TextField();
        trip.setPromptText(" write about your trip");
        trip.setPrefSize(500,150);

        hBox.getChildren().addAll(direction, addTrip, close, tripLocation);
        gridPane.getChildren().addAll(trip);
        borderPane.setCenter(gridPane);

        Scene scene = new Scene(borderPane, 600, 300);
        window.setScene(scene);
        window.showAndWait();
    }




    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == addTrip ){
            trip journal = new trip(tripLocation.getText(),trip.getText());
            Button newLocation = new Button(tripLocation.getText());
            newLocation.setPrefSize(150, 50);
            newLocation.setOnAction(this);
            JournalScene.leftMenu.getChildren().add(newLocation);
        }
        else if (actionEvent.getSource() instanceof Button)
        {
            Button b = (Button) actionEvent.getSource();
            JournalScene.borderPane.setCenter(addGridPane(b.getText()));
        }

    }


    public GridPane addGridPane( String cityName ) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        Text category = new Text("Trip to:");
        category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(category, 5, 0);

        Text tripTitle = new Text( cityName );
        tripTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(tripTitle, 6, 0);

        Text chartSubtitle = new Text(trip.getText());
        grid.add(chartSubtitle, 5,1);

        try {
            Image pictureIcon = new Image(getClass().getResourceAsStream(tripLocation.getText() + ".jpg"), 150, 150, false, false);
            ImageView picture = new ImageView(pictureIcon);
            grid.add(picture, 5, 6, 6, 5);
        }
        catch (Exception e){
            Image pictureIcon = new Image(getClass().getResourceAsStream("picture.png"), 150, 150, false, false);
            ImageView picture = new ImageView(pictureIcon);
            grid.add(picture, 5, 6, 6, 5);
        }

        return grid;
    }

}
