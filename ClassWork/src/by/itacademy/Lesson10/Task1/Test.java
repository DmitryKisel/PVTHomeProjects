package by.itacademy.Lesson10.Task1;

import by.itacademy.Lesson9.Task2.Student;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Student> testSet = new HashSet<>();

        testSet.add(new Student("AAA", 25));
        testSet.add(new Student("BBB", 35));
        testSet.add(new Student("AAA", 25));


        // Map - формально не относится к колекциям, т.к. это интерфейс, в отличие от Set  и List

        Map<String, String> testMap = new HashMap<>();

        testMap.put("RU", "Value");
        testMap.put("BY", "Value");
        testMap.put("EN", "Value");
        testMap.put("FR", "Value");
        testMap.put("IN", "Value");

        System.out.println("VALUE = " + testMap.get("RU"));





    }
}
