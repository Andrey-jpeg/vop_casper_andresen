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
            System.out.println("*** Buffer empty ****");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        int value = buffer[getIndex];
        buffer[getIndex] = null;
        System.out.println(Thread.currentThread().getName()+"\tGot: " + getIndex + ": " + value);
        getIndex = (getIndex+1) % size;
        notifyAll();
        return value;
    }

    synchronized void put(int n) {
        while (buffer[putIndex] != null) {
            System.out.println("*** Buffer full ****");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        buffer[putIndex] = n;
        System.out.println(Thread.currentThread().getName()+" Put: " + putIndex+ ": " +n);
        putIndex = (putIndex+1) %size;
        notifyAll();
    }


    public String toString() {
        return "Buff: " + Arrays.toString(buffer);
    }
}

