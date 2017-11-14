import java.util.*;
import java.io.*;
public class HW2Task3 {
        /*
    ДЗ2 Задача 3.
    Условие: Напишите программу, которая печатает массив, затем инвертирует
    (то есть меняет местами первый элемент с последним, второй — с предпоследним и т.д.), и вновь печатает.

     */
    public static void main(String[] args) throws IOException{
        // Inputting array dimension
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int dimension = Integer.parseInt(reader.readLine());

        Random random = new Random();
        int[] array = new int[dimension];


        // Array initialization by random integer  (from 0 to 1000) and printing
        System.out.println("Original variant");
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
            System.out.println("array[" + i + "] = " + array[i]);
        }


        // Reversing array elements and printing
        int tmp;
        System.out.println("Reverse variant");
        for (int i = 0; i < array.length/2; i++) {
            tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }


        // Printing new array
        for(int i = 0; i < array.length; i++){
            System.out.println("array[" + i + "] = " + array[i]);
        }
    }
}
