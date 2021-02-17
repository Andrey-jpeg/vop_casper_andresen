package vop;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class PrimaryController {

    @FXML
    private RadioButton circleButton;

    @FXML
    private RadioButton squareButton;

    @FXML
    private RadioButton rectangleButton;

    @FXML
    private RadioButton ellipseButton;

    @FXML
    private ToggleGroup shapeSelected;

    @FXML
    private Button getInfo;

    @FXML
    private TextField var1;

    @FXML
    private TextField var2;

    @FXML
    private TextArea textArea;

    ShapeFacade shapeFacade = ShapeFacade.getInstance();


    @FXML
    void hideVar2(MouseEvent event) throws IOException{
        var2.setVisible(false);
    }

    @FXML
    void showVar2(MouseEvent event) throws IOException{
        var2.setVisible(true);
    }


    @FXML
    void populateTextArea(MouseEvent event) throws IOException{
        double d1 = Double.parseDouble((var1.getText()));
        double d2 = Double.parseDouble((var2.getText()));

        textArea.setText(shapeFacade.getShapeInfo((ShapeFacade.SHAPES)shapeSelected.getSelectedToggle().getUserData(), d1, d2));
        textArea.getText();
    }


    @FXML
    void initialize(){
        circleButton.setUserData(ShapeFacade.SHAPES.CIRCLE);
        squareButton.setUserData(ShapeFacade.SHAPES.SQUARE);
        rectangleButton.setUserData(ShapeFacade.SHAPES.RECTANGLE);
        ellipseButton.setUserData(ShapeFacade.SHAPES.ELLIPSE);

    }
}
