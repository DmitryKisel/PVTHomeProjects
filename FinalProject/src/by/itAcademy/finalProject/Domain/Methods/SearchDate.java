package by.itAcademy.finalProject.domain.methods;

import by.itAcademy.finalProject.domain.entity.Employee;
import by.itAcademy.finalProject.domain.InputDataException;
import by.itAcademy.finalProject.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class SearchDate extends Search {
    /**
     * This  method is extended from abstract method searchTool from abstract class Search and does searching by date of
     * birth in the incoming List<Employee> list
     * @param list
     * @throws IOException
     * @throws NumberFormatException
     */
    @Override
    public void searchTool(List<Employee> list) throws IOException, NumberFormatException {
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try{
                String str = reader.readLine();

                final String pattern = "^(((0[1-9]|[12]\\d|3[01])\\.(0[13578]|1[02])\\.((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]"
                        + "\\d|30)\\.(0[13456789]|1[012])\\.((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\.02\\.((19|[2-9]\\d)"
                        + "\\d{2}))|(29\\.02\\.((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$";

                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(str);

                if (!m.matches()) {

                    throw new InputDataException();

                } else {
                    int countName = 0;
                    for (Employee person : list) {

                        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                        String birthDate = sdf.format(person.getDateOfBirth());
                        if (str.equals(birthDate)) {
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
            }catch (InputDataException e){
                System.out.println("Неверный ввод даты ");
            }
        } while (true);
    }
}
