import java.util.*;
/*
ДЗ2 Задача 1.
Условие:
Создайте массив с 10-ю переменными типа int. Используя оператор "for" найдите и выведите на экран наименьшее
и наибольшее значение в массиве.
min value =  "значение которое у вас получилось".
max value =  "значение которое у вас получилось".
Далее замените наименьшее значение на 0, а наибольшее значение на 99 и выведите получившийся массив на экран в виде:
[23, 0, 34, 99, 43534].
 */
public class HW2Task1 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;


        // Array initialization by random integer  (from 0 to 1000)
        for (int i = 0; i < array.length; i++) {

             array[i] = random.nextInt(1000);
            System.out.println("array[" + i + "] = " + array[i]);
        }


        //Searching for min and max values in array
        for(int i = 0;  i < array.length; i++){
            if (array[i] < min) {min = array[i];}
            if (array[i] > max) {max = array[i];}
           }


        //Printing min and max values
        System.out.println("min value = " + min);
        System.out.println("max value = " + max);


        // Substituting min value for 0, max value for 99 and printing as in example
        System.out.print("[");
        for (int i = 0; i < array.length; i++){
            if (array [i] == min) {array[i] = 0;}
            if (array [i] == max) {array[i] = 99;}
            if (i == 0 ) {System.out.print(array[i]);}
            else {System.out.print(", " + array[i]);}
        }
        System.out.println("].");
    }

}
