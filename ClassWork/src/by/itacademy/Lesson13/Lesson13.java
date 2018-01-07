package by.itacademy.Lesson13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Lesson13 {
    public static void main(String[] args) throws IOException {
      int[] array = {1, 2 , 3, 5, 1, 5, 2};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            }
            else {
                map.put(array[i], 1); }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
            System.out.println(entry.getKey());
        }


    }
}


