import  java.io.*;
import  java.util.*;
public class HW2Task5 {
    /*
    ДЗ2 Задача 5.
    Условие:Создайте массив типа int. Отсортируйте массив любым способом
    (по убыванию либо по возрастанию). Результат вывести на экран.
     */

    public static void main(String[] args) throws IOException {
        // Inputting array dimension
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int dimension = Integer.parseInt(reader.readLine());

        Random random = new Random();
        int[] array = new int[dimension];


        // Array initialization by random integer  (from 0 to 1000) and printing
        System.out.println("Original array:");
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
            System.out.println("array[" + i + "] = " + array[i]);
        }

        //Sorting by bubble method
        for (int i = array.length-1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if( array[j] > array[j+1] ) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        // Printing sorted array
        System.out.println("Array after sorting:");
        for(int i = 0; i < array.length; i++ )
        {
            System.out.println("array[" + i + "] = " + array[i]);
        }
    }
}
