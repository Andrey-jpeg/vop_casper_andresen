package vop;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    private Label funLabel;
    private String text;
    private Thread thread;

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    private RadioButton ms1;

    @FXML
    private ToggleGroup threadSleep;

    @FXML
    private RadioButton ms2;

    @FXML
    private RadioButton ms3;

    @FXML
    void startAnimation(MouseEvent event) {
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

                        if (threadSleep.getSelectedToggle() == ms1) {
                            Thread.sleep(100);
                        } else if (threadSleep.getSelectedToggle() == ms2) {
                            Thread.sleep(200);
                        } else if (threadSleep.getSelectedToggle() == ms3) {
                            Thread.sleep(400);
                        }

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
    void stopAnimation(MouseEvent event) {
        thread.interrupt();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
