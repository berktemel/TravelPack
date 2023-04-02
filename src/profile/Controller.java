package profile;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.event.ActionEvent;
import menu.*;

public class Controller  {
    public Button buttonEdit;
    public Button buttonTravel;
    public Button buttonItem;
    public Button buttonOperator;
    public Button buttonSignOut;

    public Label nameSurnameLabel;
    public Label ageLabel;
    public Label countryLabel;
    public Label countryNumberLabel;
    public Label hobbiesLabel;
    public Label discordChatLabel;

    public void editProfile(ActionEvent event) throws Exception{
        Parent editProfileScene= FXMLLoader.load(getClass().getResource("ProfileEdit.fxml"));
        Scene editProfile= new Scene( editProfileScene );

        Stage editWindow= (Stage) ((Node) event.getSource()).getScene().getWindow();
        editWindow.setScene(editProfile);
        editWindow.show();

    }

    public void goToTravelJournal(){
        StageStart.profileStage.setScene(StageStart.journalScene);
    }

    public void lendItem (ActionEvent event) throws Exception{
        Parent lendItem= FXMLLoader.load(getClass().getResource("LendItem.fxml"));
        Scene lendItemScene= new Scene( lendItem );

        Stage editWindow= (Stage) ((Node) event.getSource()).getScene().getWindow();
        editWindow.setScene(lendItemScene);
        editWindow.show();

    }

    public void switchOperator() {

    }

    public void signOut() {

    }

    public void displayEditedProfile (String[] input) {
        nameSurnameLabel.setText(input[0]);
        ageLabel.setText(input[1]);
        countryLabel.setText(input[2]);
        countryNumberLabel.setText(input[3]);
        hobbiesLabel.setText(input[4]);
        discordChatLabel.setText(input[5]);
    }
}
