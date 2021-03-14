package vop;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {
    @FXML
    private ImageView spin1;
    @FXML
    private ImageView spin2;
    @FXML
    private ImageView spin3;
    @FXML
    private Button startSpinnersButton;

    @FXML
    private Button stopSpinButton_1;
    @FXML
    private Button stopSpinButton_2;
    @FXML
    private Button stopSpinButton_3;
    @FXML
    private Label winningLabel;

    public Image[] images;
    private Thread t1;
    private Thread t2;
    private Thread t3;
    private int spinsAlive;

    @FXML
    private void spinHandler(ActionEvent event) {
        if (event.getSource() == startSpinnersButton) {
            BanditRunnable b1 = new BanditRunnable(1, 100, spin1);
            t1 = new Thread(b1);
            t1.setDaemon(true);
            t1.start();
            stopSpinButton_1.setDisable(false);
            BanditRunnable b2 = new BanditRunnable(5, 140, spin2);
            t2 = new Thread(b2);
            t2.setDaemon(true);
            t2.start();
            stopSpinButton_2.setDisable(false);
            BanditRunnable b3 = new BanditRunnable(8, 120, spin3);
            t3 = new Thread(b3);
            t3.setDaemon(true);
            t3.start();
            stopSpinButton_3.setDisable(false);
            startSpinnersButton.setDisable(true);
            winningLabel.setText("Running");
        } else if (event.getSource() == stopSpinButton_1) {
            t1.interrupt();
            stopSpinButton_1.setDisable(true);
        } else if (event.getSource() == stopSpinButton_2) {
            t2.interrupt();
            stopSpinButton_2.setDisable(true);
        } else if (event.getSource() == stopSpinButton_3) {
            t3.interrupt();
            stopSpinButton_3.setDisable(true);
        }
    }

    private synchronized void aliveCount(boolean up) {
        if (up) {
            spinsAlive++;
        } else {
            spinsAlive--;
        }

        System.out.println("Alive: " + spinsAlive);
        if (spinsAlive == 0) {
            startSpinnersButton.setDisable(false);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (spin1.getImage() == spin2.getImage() && spin1.getImage() == spin3.getImage()) {
                        winningLabel.setText("All 3 equals! Congratulations");
                    } else if (spin1.getImage() == spin2.getImage()
                            || spin1.getImage() == spin3.getImage()
                            || spin2.getImage() == spin3.getImage()) {
                        winningLabel.setText("2 equals! Congratulations");
                    } else {
                        winningLabel.setText("You are a LOSER!");

                    }
                }
            });
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        images = new Image[10];
        String pre = "fruits";
        String post = ".png";
        for (int i = 0; i < images.length; i++) {
            String filename = pre  + i + post;
            String file = null;
            try {
                file = getClass().getResource(filename).toURI().toString();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            images[i] = new Image(file);
        }
        spin1.setImage(images[1]);
        spin2.setImage(images[5]);
        spin3.setImage(images[8]);
    }

    public class BanditRunnable implements Runnable {

        private int i;
        private long sleepTime;
        private boolean running;
        private ImageView iw;

        public BanditRunnable(int i, long sleepTime, ImageView iw) {
            this.i = i;
            this.sleepTime = sleepTime;
            this.iw = iw;
        }

        @Override
        public void run() {
            running = true;
            aliveCount(true);
            System.out.println("Thread started: " + Thread.currentThread());

            while (running) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        iw.setImage(images[i]);
                        i = (i + 1) % images.length;
                    }
                });
                synchronized (this) {
                    try {
                        //Thread.sleep(sleepTime);
                        wait(sleepTime);
                    } catch (InterruptedException ex) {
                        System.out.println("Interrupted: " + Thread.currentThread());
                        running = false;
                        aliveCount(false);
                    }
                }
            }
        }
    }
}
