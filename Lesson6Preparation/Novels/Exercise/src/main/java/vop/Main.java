package vop;

public class Main {
    public static void main(String[] args) {
        String[] fileNames = {"alice30.txt", "boscombe.txt", "snow-white.txt"};
        for (String fileName : fileNames) {
            Runnable wcr = new WordCountRunnable(fileName);
            // Start a Thread for the Runnable here:
        }
    }
}
