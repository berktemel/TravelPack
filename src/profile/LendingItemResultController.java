package profile;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class LendingItemResultController {
    public Label name_surnameLabel;
    public Label itemLabel;
    public Label placeLabel;
    public Label startingDateLabel;
    public Label endingDateLabel;
    public Label contactInfoLabel;

    public Button buttonResult;

    public void setData( String[] input) {
        name_surnameLabel.setText(input[0]);
        itemLabel.setText(input[1]);
        placeLabel.setText(input[2]);
        startingDateLabel.setText(input[3]);
        endingDateLabel.setText(input[4]);
        contactInfoLabel.setText(input[5]);
        buttonResult.setText(input[6]);
    }
    public void setNotSelected (String input) {
        placeLabel.setText(input);
    }
    public void closeWindow (ActionEvent e) {
        // get a handle to the stage
        Stage stage = (Stage) buttonResult.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
