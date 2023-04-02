package menu;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ForgotPasswordScene extends Scene{

    //properties
    GridPane gPane;
    Button fromResetToLogIn;
    Label resetPasswordLabel;
    TextField mailForResetPass;


    public ForgotPasswordScene(GridPane gridPane) {
        super(gridPane);

        StageStart.mainStage.setWidth(800);
        StageStart.mainStage.setHeight(800);

        gPane = gridPane;

        gPane.setAlignment(Pos.CENTER);
        gPane.setPadding( new Insets( 50,50,50,50));
        gPane.setHgap(0);
        gPane.setVgap(0);

        resetPasswordLabel = new Label("Reset My Password");
        resetPasswordLabel.setFont(Font.font("Calibre", FontWeight.BOLD, 28));
        resetPasswordLabel.setAlignment(Pos.CENTER);
        gPane.setConstraints(resetPasswordLabel, 0, 0);

        Label emptySpace = new Label();
        emptySpace.setPrefHeight(30);
        gPane.setConstraints(emptySpace, 0, 1);

        mailForResetPass = new TextField();
        mailForResetPass.setPromptText("Please enter your mail here");
        mailForResetPass.setPrefHeight(40);
        mailForResetPass.setPrefWidth(40);
        gPane.setConstraints(mailForResetPass, 0, 2);

        // add button to reset password page
        fromResetToLogIn = new Button("Done");
        gPane.setConstraints(fromResetToLogIn,0, 3);
        fromResetToLogIn.setPrefHeight(30);
        fromResetToLogIn.setDefaultButton(true);   //????????
        fromResetToLogIn.setPrefWidth(100);
        GridPane.setHalignment(fromResetToLogIn, HPos.CENTER);
        GridPane.setMargin(fromResetToLogIn, new Insets(25, 50, 25, 50));


        gPane.getChildren().addAll(resetPasswordLabel, emptySpace, mailForResetPass, fromResetToLogIn );

        fromResetToLogIn.setOnAction(event ->  {
            resetSuccessfully();
        });

    }

    private void resetSuccessfully(){
        System.out.println("Successfully done! You are now directing to log in page.");
        StageStart.mainStage.setScene(StageStart.logInScene);
    }

}
