package by.itAcademy.finalProject.domain.methods;

import by.itAcademy.finalProject.domain.entity.Employee;
import by.itAcademy.finalProject.domain.InputDataException;
import by.itAcademy.finalProject.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchByExperiance extends Search {
    @Override
    public void searchTool(List<Employee> list) throws IOException {
        do {
            System.out.println("Введите требуемое значение опыта работы ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                String str = reader.readLine();
                Pattern p = Pattern.compile("\\d+");
                Matcher m = p.matcher(str);

                if (!m.matches()) {
                    throw new InputDataException();
                } else {
                    int countName = 0;
                    int minValue = Integer.parseInt(str);
                    for (Employee person : list) {
                        if (person.getYearEperience() >= minValue) {
                            Employee.printEmployee(person);
                            countName++;
                        }
                    }
                    if (countName == 0) {
                        Main.printSearchFail();
                        break;
                    }
                    break;
                }
            } catch (InputDataException e) {
                System.out.println("Неверный ввод значения ");
            }
        } while (true);
    }
}
