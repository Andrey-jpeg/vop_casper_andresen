package vop;

import java.util.Arrays;

public class CircularBuffer {

    private Integer[] buffer;
    private int size;
    int putIndex = 0;
    int getIndex = 0;

    public CircularBuffer(int size) {
        buffer = new Integer[size];
        this.size = size;
    }

    synchronized int get() {
        throw new UnsupportedOperationException("Implementer get() metoden");
    }

    synchronized void put(int n) {
        throw new UnsupportedOperationException("Implementer put() metoden");
    }


    public String toString() {
        return "Buff: " + Arrays.toString(buffer);
    }
}

