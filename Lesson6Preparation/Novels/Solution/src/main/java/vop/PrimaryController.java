package vop;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    private Label funLabel;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private RadioButton radio100;
    @FXML
    private ToggleGroup radioGroup;
    @FXML
    private RadioButton radio200;
    @FXML
    private RadioButton radio400;

    private String text;
    private Thread thread;
    private long waitTime;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        waitTime = 200;
    }

    @FXML
    private void startHandler(ActionEvent event) {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {

                        if (funLabel.getText().trim().length() == 0) {
                            text = "Programming is fun";
                        } else {
                            text = "";
                        }
                        System.out.println("Flash: " + text);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                funLabel.setText(text);
                            }
                        });

                        Thread.sleep(waitTime);

                    } catch (InterruptedException ex) {
                        return;
                    }
                }
            }

        });
        thread.setDaemon(true);
        thread.start();

    }

    @FXML
    private void stopHandler(ActionEvent event) {
        thread.interrupt();
    }

    @FXML
    private void radioHandler(ActionEvent event) {
        if (event.getSource() == radio100) {
            waitTime = 100;
        }
        if (event.getSource() == radio200) {
            waitTime = 200;
        }
        if (event.getSource() == radio400) {
            waitTime = 400;
        }
    }
}
