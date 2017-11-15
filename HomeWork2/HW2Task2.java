import java.io.*;
import java.util.*;

public class HW2Task2 {
    /*
    ДЗ2 Задача 2.
    Условие: 2. Создайте массив с 10-ю переменными типа float. Далее найдите дубликаты и выведите их количество.
    Пример: есть массив {2, 3, 5, 7, 6, 5, 7, 3, 7, 20} - в данном массиве цифра 3 и 7 повторяются.
    В результате выполнения программы на экран должно вывести:
    [3] - повторений 2
    [7] - повторений 3

     */
    public static void main(String[] args) throws IOException {


       // creating  array for initial data and map for counting duplicated elements
        float[] array = new float[10];
        Map<Float, Integer> map = new HashMap<>();

        // Inputting elements of array
        for (int i = 0; i < array.length; i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            array [i] = Float.parseFloat(reader.readLine());
        }

        //Searching for duplicated elements anf putting them in to map

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                map.put(array[i], map.get(array[i])+1);
            }
            else {map.put(array[i], 1);}
        }


        // Printing duplicated elements
        for(Map.Entry <Float, Integer>  d : map.entrySet()) {
            if (d.getValue() > 1)
                System.out.println("[" + d.getKey() + "] - повторений " + d.getValue());
        }
    }
}
