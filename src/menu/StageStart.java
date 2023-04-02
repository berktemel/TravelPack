package menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import journal.JournalScene;


import java.awt.*;
import java.io.IOException;


public class StageStart extends Application {

    final static Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = (int) screenResolution.getWidth();
    public static final int HEIGHT= (int) screenResolution.getHeight();

    //Each scene is created as a variable and these variables will be used when switching scenes
    public static Stage profileStage = new Stage();

    public static Parent profileRoot;
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../profile/Profile.fxml"));
            profileStage.setTitle("Profile");
            //Scene profileScene = new Scene(root, WIDTH * 3 / 5, HEIGHT * 3 / 5);
            profileStage.setScene(new Scene(root, WIDTH * 3 / 5, HEIGHT * 3 / 5));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Stage mainStage = new Stage();
    public static MainScene mainScene = new MainScene(new StackPane());
    public static EmergencyScene emergencyScene = new EmergencyScene(new StackPane());
    public static SignUpScene signUpScene;

    static {
        try {
            signUpScene = new SignUpScene(new StackPane());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static LogInScene logInScene = new LogInScene(new GridPane());
    public static ForgotPasswordScene forgotPasswordScene = new ForgotPasswordScene(new GridPane());
    public static JournalScene journalScene = new JournalScene(new BorderPane());


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        mainStage = stage;
        mainStage.setScene(logInScene);
        mainStage.setTitle("Travel Pack");
        mainStage.show();
    }

}