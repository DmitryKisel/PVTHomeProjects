package by.itacademy.HomeWork8.Task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.itacademy.HomeWork8.Task4.Main.*;

public class SearchName extends Search {


    @java.lang.Override
    public  void searchTool(List<Employee> list) throws IOException {
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            String pattern = "[а-яА-Я, ]+";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(str);
            if (!m.matches()) {
                printError(); menuCase = 1;
                break;
            } else {
                int countName = 0;
                for (Employee person : list) {
                    if (person.getFullName().toLowerCase().contains(str.toLowerCase())) {
                        printEmployee(person);
                        countName++;
                    }
                }
                if (countName == 0) {
                    printFail();
                    menuCase = 99;
                    break;
                }
                menuCase = 99;
                break;
            }

        } while (menuCase == 1);
    }


}

