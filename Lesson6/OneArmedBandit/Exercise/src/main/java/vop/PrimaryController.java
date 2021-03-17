package vop;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import java.net.URISyntaxException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PrimaryController {
    Image[] images;
    Thread t1;
    Thread t2;
    Thread t3;
    int spinsAlive;

    @FXML
    private ImageView imagesOne;

    @FXML
    private ImageView imagesTwo;

    @FXML
    private ImageView imagesThree;

    @FXML
    private Button stopOne;

    @FXML
    private Button stopTwo;

    @FXML
    private Button stopThree;

    @FXML
    private Button startButton;

    @FXML
    private Label gameLabel;

    @FXML
    void stopGame(ActionEvent event) {
        Object source = event.getSource();
        if (source == stopOne) {
            t1.interrupt();
            stopOne.setDisable(true);
        } else if (source == stopTwo) {
            t2.interrupt();
            stopTwo.setDisable(true);
        } else if (source == stopThree) {
            t3.interrupt();
            stopThree.setDisable(true);
        }
        if (stopOne.isDisabled() && stopTwo.isDisabled() && stopThree.isDisabled()){
            gameLabel.setText(":)");
            startButton.setDisable(false);
        }
    }

    @FXML
    void startGame(ActionEvent event) {
        stopOne.setDisable(false);
        stopTwo.setDisable(false);
        stopThree.setDisable(false);

        gameLabel.setText("Running...");

        t1 = new Thread(new BanditRunnable(1, 120, imagesOne));
        t1.setDaemon(true);
        t1.start();
        t2 = new Thread(new BanditRunnable(1, 100, imagesTwo));
        t2.setDaemon(true);
        t2.start();
        t3 = new Thread(new BanditRunnable(1, 140, imagesThree));
        t3.setDaemon(true);
        t3.start();

        startButton.setDisable(true);
    }


    private synchronized void aliveCount(boolean up) {
        if (up) {
            spinsAlive++;
        } else {
            spinsAlive--;
        }

        System.out.println("Alive: " + spinsAlive);
        if (spinsAlive == 0) {
            startButton.setDisable(false);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (imagesOne.getImage() == imagesTwo.getImage() && imagesOne.getImage() == imagesThree.getImage()) {
                        gameLabel.setText("All 3 equals! Congratulations");
                    } else if (imagesOne.getImage() == imagesTwo.getImage()
                            || imagesOne.getImage() == imagesThree.getImage()
                            || imagesTwo.getImage() == imagesThree.getImage()) {
                        gameLabel.setText("2 equals! Congratulations");
                    } else {
                        gameLabel.setText("You are a LOSER!");

                    }
                }
            });
        }
    }


    public void initialize() {
        stopOne.setDisable(true);
        stopTwo.setDisable(true);
        stopThree.setDisable(true);
        images = new Image[10];
        String pre = "fruits";
        String post = ".png";
        for (int i = 0; i < images.length; i++) {
            String fileName = pre  + i + post;
            String file = null;
            try {
                file = getClass().getResource(fileName).toURI().toString();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            images[i] = new Image(file);
        }
        imagesOne.setImage(images[1]);
        imagesTwo.setImage(images[4]);
        imagesThree.setImage(images[6]);
    }

    public void disable(Button btn){
        btn.setDisable(true);
    }

    public void enable(Button btn){
        btn.setDisable(false);
    }

    public class BanditRunnable implements Runnable{
        private int i; //Index of current picture
        private long sleepTime;
        private boolean running;
        private ImageView iw;

        public BanditRunnable(int i, long sleepTime, ImageView iw)   {
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
