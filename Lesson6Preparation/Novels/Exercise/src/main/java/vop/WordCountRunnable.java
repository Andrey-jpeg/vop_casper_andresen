package vop;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class WordCountRunnable implements Runnable {
    private File fileName;
    private Thread t;

    public WordCountRunnable(String fileName) {
        this.fileName = new File(getClass().getResource(fileName).getFile());
    }

    @Override
    public void run() {
        try{
            Scanner scan = new Scanner(fileName, StandardCharsets.UTF_8);
            String[] items;
            String line;
            int wordCount = 0;
            while (scan.hasNextLine()) {
                line = scan.nextLine().trim();
                items = line.split("\\s");
                wordCount += items.length;
                }
            scan.close();
            System.out.println(fileName.toString() + '\t' + wordCount);
        } catch (IOException e){
            System.exit(0);
        }
    }
}
