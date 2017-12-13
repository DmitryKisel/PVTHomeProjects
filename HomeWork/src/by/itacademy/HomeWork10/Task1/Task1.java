package by.itacademy.HomeWork10.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task1 {
    public static String createCase = "Y";

    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> animals = new ArrayList<>();

        do {
            String animal = null;

            BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input new animal");
            animal = rdr.readLine();
            animals.add(animal);

            System.out.println("Would you like to add new animal? If you do not - press \"N\" button and Enter, if you don't  - press anny button and Enter");


            String str = rdr.readLine();
            if (str.toLowerCase().equals("n")) {
                createCase = "N";
            } else {
                createCase = "Y";
            }

        } while (createCase != "N");

        for (String animal : animals) {

            animal = animal.replace("a", "");
            System.out.println(animal);
        }

        Set<String> testSet = new HashSet<>();
        testSet.addAll(animals);
        animals.clear();
        animals.addAll(testSet);

        System.out.println("List without repeats");

        for (String animal : animals) {
              System.out.println(animal);
        }


    }
}