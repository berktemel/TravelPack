package journal;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import menu.*;

import java.awt.*;
import java.io.IOException;


public class JournalScene extends Scene implements EventHandler<ActionEvent> {

    Stage window;
    Label aboutMe;
    Button trip1;
    Button trip2;
    Button trip3;
    Button backToProfile;
    Button mail;
    Scene scene1, scene2;
    public static BorderPane borderPane;
    StackPane layout;
    static VBox leftMenu = new VBox(10);
    Parent root;

    {
        try {
            root = FXMLLoader.load(getClass().getResource("../profile/Profile.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    final Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
    public final int WIDTH = (int) screenResolution.getWidth();
    public final int HEIGHT= (int) screenResolution.getHeight();

    public JournalScene(BorderPane bPane) {
        super(bPane);
        borderPane = bPane;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);


        trip1 = new Button("Ankara");
        trip1.setOnAction(this);
        trip1.setPrefSize(150,50);

        trip2 = new Button("Istanbul");
        trip2.setOnAction(this);
        trip2.setPrefSize(150,50);

        trip3 = new Button("Paris");
        trip3.setOnAction(this);
        trip3.setPrefSize(150,50);

        Label blankSpace = new Label();
        blankSpace.setPrefSize(150,600);

        backToProfile = new Button("Back to Profile");
        backToProfile.setPrefSize(150,50);
        backToProfile.setOnAction(e -> StageStart.profileStage.setScene(new Scene(root, WIDTH * 3 / 5, HEIGHT * 3 / 5)));


        Image mailIcon = new Image(getClass().getResourceAsStream("mail.png"), 50, 50, false , false);
        mail = new Button("Send mail", new ImageView(mailIcon));

        Image profileIcon = new Image(getClass().getResourceAsStream("profile.jpg"),50, 50, false , false);

        ImageView aboutMe = new ImageView(profileIcon);
        Text me = new Text( "About Me");
        me.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        Text about = new Text("Name: " + "\n"  + "Surname: "  );
        VBox rightMenu = new VBox(20);
        rightMenu.getChildren().addAll(aboutMe, me, about, mail, blankSpace,backToProfile);


        leftMenu.getChildren().addAll(trip1,trip2,trip3);

        borderPane.setLeft(leftMenu);
        borderPane.setRight(rightMenu);
        borderPane.setTop(addHBox());

        StageStart.profileStage.setWidth(WIDTH);
        StageStart.profileStage.setHeight(HEIGHT);

    }

    @Override
    public void handle(ActionEvent actionEvent) {

         if (actionEvent.getSource() instanceof Button)
         {
             Button b = (Button) actionEvent.getSource();
             borderPane.setCenter(addGridPane(b.getText()));
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

        Text chartSubtitle = new Text("Nice trip");
        grid.add(chartSubtitle, 5,1);

        String fileName = cityName + ".jpg";
        System.out.println(fileName);
        Image pictureIcon = new Image(String.valueOf(getClass().getResource( fileName)), 640,480,false,false);
        ImageView picture = new ImageView(pictureIcon);
        grid.add(picture, 5, 6, 6, 5);


        return grid;
    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button addTrip2 = new Button("Add Trip");
        addTrip2.setPrefSize(100, 20);
        addTrip2.setOnAction(e -> new addTrip().display("Add Trip"));

        Button addPhotos = new Button("Add photos");
        addPhotos.setPrefSize(100, 20);
        hbox.getChildren().addAll(addTrip2, addPhotos);

        return hbox;
    }


}
