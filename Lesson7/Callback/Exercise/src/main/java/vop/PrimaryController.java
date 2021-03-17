package vop;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable, CallBackInterface {

    @FXML
    private TextArea textArea;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private ImageView die1view;
    @FXML
    private ImageView die2view;

    private FacadeWithCallback facade;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        startButton.setDisable(false);
        stopButton.setDisable(true);
    }

    @FXML
    private void buttonAction(ActionEvent event) {
        if (event.getSource() == startButton) {
            // Initialize the facade and start it.
            // handle access to the buttons
        } else {
            // Stop the facade
        }
    }

    @Override
    public void updateMessage(String message) {
        // This is the implementation of the CallBack. Remember it is called fro a Thread!
        // append the message to the textArea

    }

    @Override
    public void updateImages(File i1, File i2) {
        // change the pictures on the imageViews

    }


}