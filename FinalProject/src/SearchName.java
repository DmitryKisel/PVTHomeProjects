import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class SearchName extends Search {


    /**
     * This  method is extended from abstract method searchTool from abstract class Search and does searching by name
     * in the incoming List<Employee> list
     * @param list
     * @throws IOException
     */
    @java.lang.Override
    public  void searchTool(List<Employee> list) throws IOException {

        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                String str = reader.readLine();
                String pattern = "[a-zA-Z, ]+";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(str);
                if (!m.matches()) {

                    throw new InputDataException();

                } else {
                    int countName = 0;
                    for (Employee person : list) {
                        if (person.getName().toLowerCase().contains(str.toLowerCase())) {
                            Main.printEmployee(person);
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
                System.out.println("Неверный ввод данных");
            }

        } while (true);
    }


}