package menu;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

import java.awt.*;


public class EmergencyScene extends Scene {

    //properties
    final Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
    public final int WIDTH = (int) screenResolution.getWidth();
    public final int HEIGHT= (int) screenResolution.getHeight();

    StackPane emergencyPane;
    HBox backgrounds = new HBox();
    HBox departmentButtons = new HBox();
    LeftMenu leftMenu = new LeftMenu();

    final int iconSize = 300;
    final int leftButtonWidth = leftMenu.getButtonWidth();
    final int widthSize = (WIDTH - leftButtonWidth) / 3;
    final String HEALTH = "112";
    final String POLICE = "155";
    final String FIREFIGHTER = "110";

    //constructor
    public EmergencyScene(StackPane root) {
        super(root);

        StageStart.mainStage.setWidth(WIDTH);
        StageStart.mainStage.setHeight(HEIGHT);
        StageStart.mainStage.setFullScreen(true);

        emergencyPane = root;
        emergencyPane.getChildren().add(leftMenu.getButtonsOnLeft());
        departmentButtons.setTranslateX(leftButtonWidth);

        backgrounds.setTranslateX(leftButtonWidth);
        departmentButtons.setTranslateX(leftButtonWidth);
        createButtons(HEALTH, "healthicon.png");
        createButtons(POLICE, "policeicon.png");
        createButtons(FIREFIGHTER, "fireicon.png");

        emergencyPane.getChildren().addAll(backgrounds, departmentButtons);
    }

    //methods

    /**
     * this method creates button and arranges its properties
     * @param department is the emergency authorities department
     * @param file is the path to icon of department
     */
    private void createButtons(String department, String file) {
        TextField background = new TextField();
        background.setDisable(true);
        background.setPrefSize(widthSize, HEIGHT);
        backgrounds.getChildren().add(background);

        Button departmentButton = new Button();
        departmentButton.setFont(new Font(140));
        departmentButton.setText(department);
        departmentButton.setGraphic(createIcon(file));
        departmentButton.setPrefSize(widthSize, HEIGHT);
        departmentButton.setContentDisplay(ContentDisplay.TOP);
        departmentButtons.getChildren().add(departmentButton);

        if (department.equals(HEALTH)) {
            departmentButton.setStyle("-fx-background-color: #ffffff; ");
            //departmentButton.setOnAction(e -> );
        } else if (department.equals(POLICE)) {
            departmentButton.setStyle("-fx-background-color: #1F54C6; ");
            //departmentButton.setOnAction(e -> );
        } else {
            departmentButton.setStyle("-fx-background-color: #ff0000; ");
            //departmentButton.setOnAction(e -> );
        }
    }

    /**
     * icon for departmant is prepared in this method
     * @param file is the path to icon
     * @return
     */
    private ImageView createIcon(String file) {
        javafx.scene.image.Image image = new Image(String.valueOf(getClass().getResource(file)));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(iconSize);
        imageView.setFitHeight(iconSize);
        return imageView;
    }

}
