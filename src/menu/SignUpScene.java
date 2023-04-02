package menu;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import javafx.event.*;

import javax.swing.*;
import java.util.ArrayList;

public class SignUpScene extends Scene{
    GridPane gPane;
    StackPane mainPane = new StackPane();
    VBox vBox = new VBox(20);
    Label pageLabel;
    Button submitButton;
    Scene logInScene;
    ArrayList<User> userArrayList;
    Button signupToLogin;

    Label signUpLabel;


    public static ArrayList<User> userAList = new ArrayList<User>();
    final int fieldHeight = 60;
    final int fieldWidth = 200;

    public SignUpScene(StackPane root) throws Exception {
        super(root);

        TextField fieldName = new TextField();
        TextField fieldSurname = new TextField();
        TextField fieldPhone = new TextField();
        TextField fieldMail = new TextField();
        PasswordField fieldPassw = new PasswordField();
        PasswordField fieldPasswAgain = new PasswordField();
        StageStart.mainStage.setWidth(800);
        StageStart.mainStage.setHeight(800);

        User admin = new User("admin","admin","admin","admin","admin");
        userAList.add(admin);
        mainPane = root;

        // SIGN UP PAGE
        signUpLabel = new Label("SIGN UP");

        signupToLogin = new Button("Login Page");
        signupToLogin.setOnAction(e -> StageStart.mainStage.setScene(StageStart.logInScene));
        signupToLogin.setPrefSize(fieldWidth/2, fieldHeight/2);

        gPane = new GridPane();
        gPane.setAlignment(Pos.CENTER);
        gPane.setPadding( new Insets( 50,50,50,50));

        pageLabel = new Label("Sign Up");
        pageLabel.setFont(Font.font("Calibre", FontWeight.BOLD, 28));
        pageLabel.setAlignment(Pos.CENTER);

        arrangeTextField(fieldName, "Name : ", 0, 0);
        arrangeTextField(fieldSurname, "Surname : ", 1, 0);
        arrangeTextField(fieldMail, "Mail : ", 0, 1);
        arrangeTextField(fieldPhone, "Phone Number * : ", 1, 1);
        arrangePasswordField(fieldPassw, "Password : ", 0, 2);
        arrangePasswordField(fieldPasswAgain, "Password Again : ", 1, 2);
        Button getLocationButton = new Button("Get current location");
        getLocationButton.setPrefSize(fieldWidth, fieldHeight);
        GridPane.setConstraints(getLocationButton,0,3);



        submitButton = new Button("Submit");
        submitButton.setPrefSize(fieldWidth, fieldHeight);
        submitButton.setDefaultButton(true);   //????????

        gPane.getChildren().add(getLocationButton);

        vBox.setPrefSize(500,500);
        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(pageLabel, gPane, submitButton, signupToLogin);
        mainPane.getChildren().add(vBox);

        submitButton.setOnAction(event -> {
            System.out.println(fieldName.getText()+ fieldSurname.getText()+ fieldMail.getText()+ fieldPhone.getText()+ fieldPassw.getText());
            try{

                submittedSuccessfully(fieldName, fieldSurname, fieldMail, fieldPhone, fieldPassw, userAList);
            }catch ( NullPointerException e ){
                System.out.println("You can not leave any area blank!");
            }
        });
    }

    private void arrangeTextField(TextField tf, String text, int column, int row) {
        tf.setPromptText(text);
        tf.setPrefSize(fieldWidth, fieldHeight);
        gPane.setConstraints(tf, column, row);
        gPane.getChildren().add(tf);
    }

    private void arrangePasswordField(PasswordField pf, String text, int column, int row) {
        pf.setPromptText(text);
        pf.setPrefSize(fieldWidth, fieldHeight);
        gPane.setConstraints(pf, column, row);
        gPane.getChildren().add(pf);
    }
    private void submittedSuccessfully(TextField name, TextField surname, TextField mail,TextField phone, TextField pass1, ArrayList<User> userList){
        User newUser = new User(name.getText(), surname.getText(), mail.getText(), phone.getText(), pass1.getText());
        userList.add(newUser);

        System.out.println("Registration is completed successfully! You are now directing to log in page." + userList);
    }

    

    private void arrangePassword(TextField tf, String text, int column, int row) {
        tf = new PasswordField();
        tf.setPromptText(text);
        tf.setPrefSize(fieldWidth, fieldHeight);
        gPane.setConstraints(tf, column, row);
        gPane.getChildren().add(tf);
    }

    static boolean isUserAndPassFound(ArrayList<User> fullList, User userToLogIn){
        for (User user : fullList) {
            System.out.println(user.getMail().equals(userToLogIn.getMail()));
            System.out.println(user.getPassword().equals(userToLogIn.getPassword()));
            System.out.println(user.getMail());
            System.out.println(user.getMail());
            System.out.println((userToLogIn.getMail()));
            System.out.println((userToLogIn.getMail()));


            if (user.getMail().equals(userToLogIn.getMail()) && user.getPassword().equals(userToLogIn.getPassword())) {
                return true;
            }
        }
        return false;
    }

    private boolean isUserMailFound( ArrayList<User> fullList, User userToLogIn){
        for (User user : fullList) {
            if (user.getMail().equals(userToLogIn.getMail())) {
                return true;
            }
        }
        return false;
    }

    private void resetSuccessfully( TextField mail, ArrayList<User> listFull){

        User resetUser = new User("","",mail.getText(), "","");

        try{
            if(isUserMailFound(listFull, resetUser)){
                System.out.println("Successfully done! You are now directing to log in page.");
            }
            else{
                System.out.println("There is no such user with this mail address!");
            }
        }catch (NullPointerException exception){
            System.out.println("You can not leave this area blank!");
        }
    }

}

        //gPane.setVisible(true);     // I'M NOT SURE IF THIS STATEMENT IS TRUE, I'WILL CHECK IT LATER


    /* FROM HERE
    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            // when mouse is clicked it will submit data to database
            //TODO
        }
    };
    //Adding event Filter
    //Circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

    public void keyPressed( ActionEvent event1 )
    {
        if ( event1.getEventType() ==  )
    }

    /*
    EventHandler handler = new EventHandler(<InputEvent>() {
    public void handle(InputEvent event) {
        System.out.println("Handling event " + event.getEventType());
        event.consume();
    }

     */
    /*

    public boolean checkMailAndPhone()
    {
        /*
        boolean ok = true;

        if ( entered mail is in database )
        {
            System.out.println("This user is registered!");
            ok = false;
            return ok;
        }

        else if( entered phone is in database )
        {
            System.out.println("This user is registered!");
            ok = false;
            return ok;
        }
        return ok;

    }

     */

    /*
    public User createUser() // I AM NOT SURE IF IT SHOULD BE VOID OR TYPE USER
    {
        if ( checkMailAndPhone() == true )
        {
            // if other areas are entered correctly, then create a user, else, give warning
        }
        else
        {
            //give warning
        }
    }
    */ // TO HERE