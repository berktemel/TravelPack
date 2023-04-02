package profile;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;

public class ProfileEditController extends Controller {
     public TextField textFieldNameSurname;
     public TextField textFieldAge;
     public TextField textFieldCountry;
     public TextField textFieldCountryNumber;
     public TextField textFieldHobbies;
     public TextField textFieldChat;
     public Label editProfileLabel;
     public Button buttonSave;

    Stage stage;
    Scene scene;
    Parent root;

     public void saveProfileInfo(ActionEvent e) throws IOException {

         String[] input= new String[6];

         input[0]= textFieldNameSurname.getText();
         input[1]= "Age: "+ textFieldAge.getText();
         input[2]= "Country: "+ textFieldCountry.getText();
         input[3]= "Number Of Countries: "+ textFieldCountryNumber.getText();
         input[4]= "Hobbies: "+ textFieldHobbies.getText();
         input[5]= "Discord ID Number: "+ textFieldChat.getText();

         FXMLLoader loader= new FXMLLoader(getClass().getResource("Profile.fxml"));
         root= loader.load();

         Controller saveController= loader.getController();
         saveController.displayEditedProfile(input);

         //root= FXMLLoader.load(getClass().getResource("Profile.fxml"));
         stage= (Stage) ((Node) e.getSource()).getScene().getWindow();
         scene= new Scene( root);
         stage.setScene(scene);
         stage.show();
          }

     }

