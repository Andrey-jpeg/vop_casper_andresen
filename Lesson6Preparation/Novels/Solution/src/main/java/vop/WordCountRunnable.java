package vop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class WordCountRunnable implements Runnable {

    private String filename;

    /**
     * Constructs a WordCountRunnable object with a file name.
     *
     * @param aFilename the file name that needs to count word
     */
    public WordCountRunnable(String aFilename) {
        filename = aFilename;
    }


    public void run() {
        int count = 0;
        String file = "";
        try {
            file = getClass().getResource(filename).toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try (Scanner in = new Scanner(new FileInputStream(file))) {

            while (in.hasNext()) {
                in.next();
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(filename + " not found!");

        }
        System.out.println(filename + ": " + count);
    }
}
