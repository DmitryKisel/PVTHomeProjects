package by.itacademy.Lesson10.Task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task1 {

    public static void main(String[] args) {
        Set<String> testSet = new HashSet<>();

        testSet.add("AAA");
        testSet.add("BBB");
        testSet.add("AAA");

        for(String test: testSet){
            System.out.println("value = " + test);
        }

        // используется для хранения данных без дубликатов

        List<String> list = new ArrayList<>();

        list.add("AAA");
        list.add("BBB");
        list.add("AAA");

        // способ как убрать повторяющиеся элементы из листа
        testSet.addAll(list);
        list.clear();
        list.addAll(testSet);


    }
}
