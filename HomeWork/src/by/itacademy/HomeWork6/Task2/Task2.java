package by.itacademy.HomeWork6.Task2;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[] initialArray = new int[10];
        int[] destinationArray = new int[20];
        Random random = new Random();

        for(int i = 0; i < initialArray.length; i++){
            initialArray[i] = random.nextInt(100);
        }
        printArray(initialArray);
        int position = (destinationArray.length - initialArray.length)/2;
        System.arraycopy(initialArray, 0,destinationArray, position, 10 );
        printArray(destinationArray);

    }
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            if (i == 0) System.out.print("[" + array[i] + ",");
            else if (i == array.length-1) System.out.print(" " + array[i] + "]");
            else System.out.print(" " + array[i] + ",");


        }
        System.out.println();
    }
}