package vop;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    private Label funLabel;
    private String text;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        thread.setDaemon(true);
        thread.start();

    }

    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
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

                    Thread.sleep(200);
                }
            } catch (InterruptedException ex) {
            }

        }

    });
}
