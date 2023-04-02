package menu;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainScene extends Scene {

    //properties
    StackPane root;
    HBox buttonsUp = new HBox(5);
    VBox rightSide = new VBox();
    VBox mapPlace;

    //test start
    boolean state_corona;
    boolean state_friends;
    boolean state_activities;
    boolean state_challenges;
    WebEngine mainEngine;
    //test end

    LeftMenu leftMenu = new LeftMenu();

    final Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
    public final int WIDTH = (int) screenResolution.getWidth();
    public final int HEIGHT= (int) screenResolution.getHeight();

    //Elements resize according to screen resolution
    final int buttonWidth = 200 * WIDTH / 1920;
    final int topBoxWidth = 290 * WIDTH / 1920;
    final int topBoxHeight = 80 * HEIGHT / 1010;
    final int rightButtonWidth = 230 * WIDTH / 1920;
    final int rightButtonHeight = 40 * HEIGHT / 1010;
    final int rightLabelHeight = 30 * HEIGHT / 1010;
    final int iconSize = 60 * HEIGHT / 1010;

    //constructor
    public MainScene(StackPane aRoot) {
        super(aRoot);

        StageStart.mainStage.setWidth(WIDTH);
        StageStart.mainStage.setHeight(HEIGHT);

        this.root = aRoot;
        root.getChildren().add(leftMenu.getButtonsOnLeft());
        buttonsOnTop();
        try {
            showMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
        rightSideBar();
    }

    //methods

    /**
     * Buttons located on top side are created and arranged
     */
    private void buttonsOnTop() {
        //Overlay to put checkboxes in rectangles
        HBox overlay = new HBox(5);
        TextField tf1 = new TextField();
        tf1.setPrefSize(topBoxWidth,topBoxHeight);
        tf1.setDisable(true);
        TextField tf2 = new TextField();
        tf2.setPrefSize(topBoxWidth,topBoxHeight);
        tf2.setDisable(true);
        TextField tf3 = new TextField();
        tf3.setPrefSize(topBoxWidth,topBoxHeight);
        tf3.setDisable(true);
        TextField tf4 = new TextField();
        tf4.setPrefSize(topBoxWidth,topBoxHeight);
        tf4.setDisable(true);
        TextField tf5 = new TextField();
        tf5.setPrefSize(topBoxWidth,topBoxHeight);
        tf5.setDisable(true);
        overlay.getChildren().addAll(tf1, tf2, tf3, tf4, tf5);

        //Getting the date as day and month
        //Getting the time as hour and minute
        //This part is inspired by stackoverflow
        Label dateAndTimeLabel = new Label();
        dateAndTimeLabel.setPrefSize(topBoxWidth,topBoxHeight);
        dateAndTimeLabel.setFont(new Font(25));

        final DateFormat format = DateFormat.getInstance();
        final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),
                (EventHandler<ActionEvent>) event -> {
                    final Calendar calendar = Calendar.getInstance();
                    dateAndTimeLabel.setText(format.format(calendar.getTime()));
                }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();


        //Checkboxes for map filters
        //Activity Radar
        CheckBox activityRadar = new CheckBox("Activity Radar");
        arrangeCheckBox(activityRadar);
        activityRadar.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                mainEngine.executeScript("toggleActivityRadar()");
            }
        });


        //View Challenges
        CheckBox viewChallenge = new CheckBox("View Challenges");
        arrangeCheckBox(viewChallenge);
        viewChallenge.setOnAction(new EventHandler<ActionEvent>() {
               @Override public void handle(ActionEvent e) {
                   mainEngine.executeScript("toggleChallenges()");
               }
           });

        //Friend Radar
        CheckBox friendRadar = new CheckBox("Friend Radar");
        arrangeCheckBox(friendRadar);
        friendRadar.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
               mainEngine.executeScript("toggleFriends()");
            }
        });


        //Corona Radar
        CheckBox coronaRadar = new CheckBox("Corona Radar");
        arrangeCheckBox(coronaRadar);
        coronaRadar.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                mainEngine.executeScript("toggleCoronaStats()");
            }
        });

        //add all buttons to top bar
        buttonsUp.getChildren().addAll(dateAndTimeLabel, activityRadar, viewChallenge, friendRadar, coronaRadar);
        buttonsUp.setTranslateX(buttonWidth + 10);
        overlay.setTranslateX(buttonWidth + 5);

        root.getChildren().add(overlay);
        root.getChildren().add(buttonsUp);
        StackPane.setAlignment(buttonsUp, Pos.TOP_CENTER);
    }

    /**
     * arranges checkboxes size, font, alignment
     * @param checkBox is the checkbox to be arranged
     */
    private void arrangeCheckBox(CheckBox checkBox) {
        checkBox.setPrefSize(topBoxWidth,topBoxHeight);
        checkBox.setFont(new Font(21));
        checkBox.setAlignment(Pos.CENTER);
    }

    /**
     * Buttons and labels on the right are created
     */
    private void rightSideBar() {
        //Activities and their buttons
        Label activityLabel = new Label("Activities");
        activityLabel.setPrefSize(rightButtonWidth,topBoxHeight);
        activityLabel.setFont(new Font(25));
        activityLabel.setAlignment(Pos.CENTER);

        Button concerts = new Button("Concerts");
        concerts.setPrefSize(rightButtonWidth, rightButtonHeight);
        concerts.setOnAction(e -> mainEngine.executeScript("toggleConcerts()"));
        concerts.setAlignment(Pos.CENTER);

        Button sports = new Button("Sports");
        sports.setPrefSize(rightButtonWidth, rightButtonHeight);
        sports.setOnAction(e -> mainEngine.executeScript("toggleSports()"));
        sports.setAlignment(Pos.CENTER);

        Button festivals = new Button("Festivals");
        festivals.setPrefSize(rightButtonWidth, rightButtonHeight);
        festivals.setOnAction(e -> mainEngine.executeScript("toggleFestivals()"));
        festivals.setAlignment(Pos.CENTER);

        Button theatre = new Button("Theatre");
        theatre.setPrefSize(rightButtonWidth, rightButtonHeight);
        theatre.setOnAction(e -> mainEngine.executeScript("toggleTheatre()"));
        theatre.setAlignment(Pos.CENTER);

        Button otherActivities = new Button("Other");
        otherActivities.setPrefSize(rightButtonWidth, rightButtonHeight);
        otherActivities.setOnAction(e -> mainEngine.executeScript("toggleActivityOther()"));
        otherActivities.setAlignment(Pos.CENTER);

        //blank space between activities and transportation
        TextField emptyField = new TextField();
        emptyField.setDisable(true);
        emptyField.setPrefSize(rightButtonWidth, topBoxHeight);
/*
        //Transportation part
        Label transportation = new Label("Transportation");
        transportation.setPrefSize(rightButtonWidth,topBoxHeight);
        transportation.setFont(new Font(25));
        transportation.setAlignment(Pos.CENTER);
        Font labelFont = new Font(20);

        //Bike
        Label bike = new Label("Bike time");
        bike.setPrefSize(rightButtonWidth, rightLabelHeight);
        bike.setFont(labelFont);
        ImageView bikeImageView = createIcon("bikeicon.png");

        //Subway
        Label subway = new Label("Subway time");
        subway.setPrefSize(rightButtonWidth,rightLabelHeight);
        subway.setFont(labelFont);
        ImageView subwayImageView = createIcon("subwayicon.png");

        //Car
        Label car = new Label("Car time");
        car.setPrefSize(rightButtonWidth,rightLabelHeight);
        car.setFont(labelFont);
        ImageView carImageView = createIcon("caricon.png");

        //Bus
        Label bus = new Label("Bus time");
        bus.setPrefSize(rightButtonWidth,rightLabelHeight);
        bus.setFont(labelFont);
        ImageView busImageView = createIcon("busicon.png");
*/
        rightSide.setStyle("-fx-background-color: #f4f4f4; ");
        rightSide.setTranslateX(rightButtonWidth + 5 * topBoxWidth);
        rightSide.getChildren().addAll(activityLabel, concerts, sports, festivals, theatre, otherActivities);
        root.getChildren().add(rightSide);
    }

    /**
     * icon for vehicles are prepared
     * @param file is the path to icons
     * @return a view of icon
     */
    private ImageView createIcon(String file) {
        Image image = new Image(String.valueOf(getClass().getResource(file)));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(iconSize);
        imageView.setFitHeight(iconSize);
        return imageView;
    }

    /**
     * this method enables the map to be shown in the middle of scene
     */
    public void showMap() throws IOException {
        Parent rootParent = FXMLLoader.load(getClass().getResource("samplemain.fxml"));
        URL urlHello = getClass().getResource("Map.html");
        WebView webView = new WebView();
        mainEngine = webView.getEngine();
        mainEngine.load(urlHello.toExternalForm());
        mainEngine.reload();


        mapPlace = new VBox(webView);
        mapPlace.setPrefSize(800, 930);
        mapPlace.setTranslateX(rightButtonWidth);
        mapPlace.setTranslateY(topBoxHeight + 50);


        root.getChildren().add(mapPlace);
    }

    public Object setLocationJSTest(String x, String y){
        System.out.println(x + " " + y);
        System.out.println(mainEngine.executeScript("setLocationJSTest(" + x + "," + y + ")"));
        System.out.println(mainEngine.executeScript("completeChallenge()"));
        return (mainEngine.executeScript("completeChallenge()"));
    }
}
