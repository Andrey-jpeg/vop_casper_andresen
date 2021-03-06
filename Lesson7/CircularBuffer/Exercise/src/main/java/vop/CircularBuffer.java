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
        while (buffer[getIndex] == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int currentValue = buffer[getIndex];
        System.out.println("got : " + currentValue);
        buffer[getIndex] = null;
        getIndex = (getIndex + 1) % size; //when array has no more spaces it wraps around.
        notify();
        return currentValue;
    }

    synchronized void put(int n) {
        while (buffer[putIndex] != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Put " + n);
        buffer[putIndex] = n;
        putIndex = (putIndex + 1) % size; //when array has no more spaces it wraps around.
        notify();
    }


    public String toString() {
        return "Buff: " + Arrays.toString(buffer);
    }
}

