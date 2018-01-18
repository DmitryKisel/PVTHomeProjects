package by.itacademy.homeWork15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        MyThread myThread1 = new MyThread();
        myThread1.setName("myThread1");
        MyThread myThread2 = new MyThread();
        myThread2.setName("myThread2");

        myThread1.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread2.start();
    }

    public synchronized int print10(int count){
        System.out.printf("\n"+Thread.currentThread().getName());
        for (int j = 0; j < 10; j++) {
            System.out.printf(" "+count+" ");
            count++;
        }
        return count;
    }
}
