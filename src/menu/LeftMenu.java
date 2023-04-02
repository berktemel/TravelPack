package menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.awt.*;

public class LeftMenu extends VBox{

    //properties
    Button EMERGENCY = new Button("Emergency");
    Button PROFILE = new Button("Profile");
    Button MAP = new Button("Map");
    Button EXIT = new Button("Exit");

    VBox buttonsOnLeft = new VBox();

    final Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
    public final int WIDTH = (int) screenResolution.getWidth();
    public final int HEIGHT= (int) screenResolution.getHeight();

    //buttons will resize according to computer's screen resolution
    final int leftButtonWidth = 200 * WIDTH / 1920;
    final int leftButtonHeight = 100 * HEIGHT / 1010;

    //constructor
    public LeftMenu() {
        //Emergency button
        EMERGENCY.setPrefSize(leftButtonWidth,leftButtonHeight);
        EMERGENCY.setOnAction(e -> {
            StageStart.mainStage.setScene(StageStart.emergencyScene);
            StageStart.mainStage.setFullScreen(true);
        });
        EMERGENCY.setStyle("-fx-background-color: #ff0000; ");

        //Profile button
        PROFILE.setPrefSize(leftButtonWidth,leftButtonHeight);
        PROFILE.setOnAction(e -> {
            StageStart.profileStage.setWidth(WIDTH);
            StageStart.profileStage.setHeight(HEIGHT);
            StageStart.profileStage.show();
        });

        //Map button
        MAP.setPrefSize(leftButtonWidth,leftButtonHeight);
        MAP.setOnAction(e -> {
            StageStart.mainStage.setScene(StageStart.mainScene);
            StageStart.mainStage.setFullScreen(true);
        });

        //Blank Label
        Label blankSpace = new Label();
        blankSpace.setPrefSize(leftButtonWidth, leftButtonHeight * 2);

        //Part for state of challenge
        Font font = new Font(22);
        Label test = new Label("Challenge State");
        test.setAlignment(Pos.CENTER);
        test.setFont(font);
        test.setPrefSize(leftButtonWidth, leftButtonHeight / 2);

        //TextArea for x coordinate
        TextArea input1 = new TextArea();
        input1.setFont(font);
        input1.setPromptText("Enter x coordinate");
        input1.setPrefSize(leftButtonWidth, leftButtonHeight);
        input1.setMaxSize(leftButtonWidth, leftButtonHeight);

        //TextArea for y coordinate
        TextArea input2 = new TextArea();
        input2.setFont(font);
        input2.setPromptText("Enter y coordinate");
        input2.setPrefSize(leftButtonWidth, leftButtonHeight);
        input2.setMaxSize(leftButtonWidth, leftButtonHeight);

        //Your location will be updated to coordinates in TextAreas
        Button GoButton = new Button("Go");
        GoButton.setPrefSize(leftButtonWidth, leftButtonHeight / 2);
        GoButton.setFont(font);
        GoButton.setOnAction(e -> test.setText(String.valueOf((StageStart.mainScene.setLocationJSTest(input1.getText(),input2.getText())))));

        //Blank Label
        Label blankSpace2 = new Label();
        blankSpace2.setPrefSize(leftButtonWidth, leftButtonHeight * 2);

        //Exit button to close program
        EXIT.setPrefSize(leftButtonWidth, leftButtonHeight / 2);
        EXIT.setOnAction(e -> closeApp());


        //Add menu buttons to left
        buttonsOnLeft.getChildren().addAll(EMERGENCY, MAP, PROFILE, blankSpace, test, input1, input2, GoButton, blankSpace2, EXIT);
    }

    /**
     * closing program properly
     */
    private void closeApp() {
        StageStart.mainStage.close();
    }

    /**
     * Get leftMenu to be used in other scenes
     * @return menu of buttons, labels etc.
     */
    public VBox getButtonsOnLeft() {
        return buttonsOnLeft;
    }

    /**
     * get button width
     * @return button's width
     */
    public int getButtonWidth() {
        return leftButtonWidth;
    }
}
