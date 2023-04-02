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

public class LogInScene extends Scene{

    //properties
    GridPane gPane;
    Button logIn;
    Button resetMyPass;
    Button createAcc;
    Label logInLabel;
    TextField logInMail, logInPassword;

    public LogInScene(GridPane gridPane) {
        super(gridPane);

        StageStart.mainStage.setWidth(800);
        StageStart.mainStage.setHeight(800);

        gPane = gridPane;

        gPane.setAlignment(Pos.CENTER);
        gPane.setPadding( new Insets( 50,50,50,50));
        gPane.setHgap(0);
        gPane.setVgap(0);

        // pageLabel2 = new Label("Sign Up");
        // pageLabel2.setFont(Font.font("Calibre", FontWeight.BOLD, 28));
        // gPane2.add(pageLabel2, 20,20, 20, 20);
        // GridPane.setHalignment(pageLabel2, HPos.CENTER);
        // GridPane.setMargin(pageLabel2, new Insets(20, 20, 20, 20));


        //LOG IN PAGE
        logInLabel = new Label("Log In");
        logInLabel.setFont(Font.font("Calibre", FontWeight.BOLD, 28));
        logInLabel.setAlignment(Pos.CENTER);
        gPane.setConstraints(logInLabel, 0, 0);

        logInMail = new TextField();
        logInMail.setPromptText("Mail");
        logInMail.setPrefHeight(40);
        logInMail.setPrefWidth(40);
        gPane.setConstraints(logInMail, 0, 1);

        logInPassword = new TextField();
        logInPassword.setPromptText("Password");
        logInPassword.setPrefHeight(40);
        logInPassword.setPrefWidth(40);
        gPane.setConstraints(logInPassword, 0, 2);


        logIn = new Button();
        logIn.setText("Log In");
        gPane.setConstraints(logIn,0, 3 );
        logIn.setPrefHeight(30);
        logIn.setDefaultButton(true);   //????????
        logIn.setPrefWidth(100);
        GridPane.setHalignment(logIn, HPos.CENTER);
        GridPane.setMargin(logIn, new Insets(25, 50, 25, 50));

        resetMyPass = new Button();
        resetMyPass.setText("Reset my Password");
        gPane.setConstraints(resetMyPass,0, 4 );
        resetMyPass.setPrefHeight(35);
        resetMyPass.setDefaultButton(true);   //????????
        resetMyPass.setPrefWidth(150);
        GridPane.setHalignment(resetMyPass, HPos.CENTER);
        GridPane.setMargin(resetMyPass, new Insets(25, 50, 25, 50));

        createAcc = new Button();
        createAcc.setText("Create Account");
        gPane.setConstraints(createAcc,0, 5);
        createAcc.setPrefHeight(35);
        createAcc.setDefaultButton(true);   //????????
        createAcc.setPrefWidth(150);
        GridPane.setHalignment(createAcc, HPos.CENTER);
        GridPane.setMargin(createAcc, new Insets(25, 50, 25, 50));


        gPane.getChildren().addAll(logInLabel, logInMail, logInPassword, logIn, resetMyPass, createAcc );

        logIn.setOnAction(event -> {
            successfullLogIn(logInMail.getText(), logInPassword.getText());
            StageStart.mainStage.setFullScreen(true);
        });

        createAcc.setOnAction(event -> {
            goToCreateAcc();
        });

        resetMyPass.setOnAction(event -> StageStart.mainStage.setScene(StageStart.forgotPasswordScene));
    }


/*

*/public void successfullLogIn(String mail, String pass){
    User logInUser = new User("", "", mail, "", pass);
    //SignUpScene.userAList.add(logInUser);
    try{
        if( SignUpScene.isUserAndPassFound(SignUpScene.userAList, logInUser) ) {
            System.out.println("youre in");
            StageStart.mainStage.setScene(StageStart.mainScene);
        }
        else{
            System.out.println("Username or password is incorrect!");
        }
    }
    catch ( NullPointerException exc)
    {
        System.out.println("You can not leave blank fields!");
    }
    //TODO
}
    private void goToCreateAcc(){
        StageStart.mainStage.setScene(StageStart.signUpScene);
    }
}
