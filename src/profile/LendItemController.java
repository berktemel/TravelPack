package profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.*;

import java.net.URL;
import java.util.*;


public class LendItemController extends LendingItemResultController implements Initializable{
    public DatePicker startDatePicker;
    public DatePicker endDatePicker;

    public ChoiceBox<String> selectPlaceChoiceBox= new ChoiceBox<>();

    public TextField nameTextField;
    public TextField surnameTextField;
    public TextField emailTextField;
    public TextField phoneTextField;
    public TextField itemDescriptionTextField;

    public CheckBox permissionCheckBox;

    String[] lendingPlaces= {"Select a Place", "Pera Hotel", "Hilton Hotel", "Blue Ray Hotel", "Radisson Hotel"};
    String[] dataLendingItem= new String[7];

    @Override
    public void initialize (URL url, ResourceBundle rb) {
     selectPlaceChoiceBox.getItems().addAll(lendingPlaces);
    }

    public void pickStartDate(ActionEvent event) {
        dataLendingItem[3]="Staring from: "+ startDatePicker.getValue().toString()+ " - ";
    }
    public void pickEndDate(ActionEvent event) {
        dataLendingItem[4]= "Ending in: "+ endDatePicker.getValue().toString();
    }
    public void pickLendingPlace(ActionEvent event) {
        dataLendingItem[2]=selectPlaceChoiceBox.getValue();
    }

    public void reserveLendingItem(ActionEvent event) throws Exception{
        dataLendingItem[0]=nameTextField.getText()+ " " + surnameTextField.getText();
        dataLendingItem[1]= "Item: "+ itemDescriptionTextField.getText();
        dataLendingItem[5]= "Contact info: " + emailTextField.getText()+ " / "+ phoneTextField.getText();
        Random rd= new Random();
        if(rd.nextBoolean()) {dataLendingItem[6]="LENDING VERFIFIED";}
        else {dataLendingItem[6]= "NO PLACE FOR THE ITEM";}

        if(permissionCheckBox.isSelected()){
            FXMLLoader loader= new FXMLLoader(getClass().getResource("LendingItemResult.fxml"));
            Parent root= loader.load();

            LendingItemResultController resultScene= loader.getController();
            resultScene.setData(dataLendingItem);

            Stage resultWindow= new Stage();
            Scene lendItemScene= new Scene( root );

            resultWindow.setScene(lendItemScene);
            resultWindow.show();
        }
        else {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("LendingItemResult.fxml"));
            Parent root= loader.load();

            LendingItemResultController resultScene= loader.getController();
            resultScene.setNotSelected("You did not select to agree the condition.");

            Stage resultWindow= new Stage();
            Scene lendItemScene= new Scene( root );

            resultWindow.setScene(lendItemScene);
            resultWindow.show();
        }
    }
}
