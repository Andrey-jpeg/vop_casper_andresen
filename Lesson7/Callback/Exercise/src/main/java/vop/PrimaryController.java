package vop;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;
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

    private Thread facade;


        @Override
    public void initialize(URL url, ResourceBundle rb) {
        startButton.setDisable(false);
        stopButton.setDisable(true);
    }

    @FXML
    private void buttonAction(ActionEvent event) {
        if (event.getSource() == startButton) {
            try{
                facade = new FacadeWithCallback(this, this.getClass().getResource("").toURI().getRawPath());
                facade.start();
                startButton.setDisable(true);
                stopButton.setDisable(false);
            } catch (URISyntaxException e) {
                e.printStackTrace();
                System.exit(0);
            }
            // Initialize the facade and start it.
            // handle access to the buttons
        } else {
            // Stop the facade
            facade.interrupt();
            startButton.setDisable(false);
            stopButton.setDisable(true);
        }
    }

    @Override
    public void updateMessage(String message) {
        // This is the implementation of the CallBack. Remember it is called from a Thread!
        textArea.appendText(message);
        if (!facade.isAlive()) {
            stopButton.fire();
        }
    }

    @Override
    public void updateImages(File i1, File i2) {
        die1view.setImage(new Image(i1.toURI().toString()));
        die2view.setImage(new Image(i2.toURI().toString()));
    }
}