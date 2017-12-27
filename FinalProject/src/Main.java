import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        String menuCase = "99";
        String downloadChoice = "0";

        Root root = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Вас приветсвует приложение \"Календарь дней рождений\"");
        System.out.println("Для дальнейшей работы выберите формат файла из которого вы хотитезагрузить данные");
        System.out.println();

        do{
        System.out.println("1. Введите 1, если хотите загрузить данные из формата JSON");
        System.out.println();
        System.out.println("2. Введите 2, если хотите загрузить данные из формата XML");
        String str = reader.readLine();

        try {
            checkInput(str, "[1,2]");
        } catch (InputDataException e) {
            System.out.println("Неверный ввод данных");
        }

        downloadChoice = str;
        FileDownload fd = new FileDownload();

      switch (downloadChoice){
          case "1":{
              root = fd.download(Integer.parseInt(downloadChoice));
              System.out.println("Данные из файла birthdays.json успешно загружены");
              break;
          }

          case "2": {
              root = fd.download(Integer.parseInt(downloadChoice));
              System.out.println("Данные из файла birthdays.xml успешно загружены");
              break;
          }

          default:{
              downloadChoice = "0";
          }
      }

    }while(downloadChoice.equals("0"));
        do {
            System.out.println();
            System.out.println();
            System.out.println("Список возможных операций");
            System.out.println();
            System.out.println("1) Поиск сотрудников по Ф.И.О");
            System.out.println();
            System.out.println("2) Поиск сотрудников по опыту работы");
            System.out.println();
            System.out.println("3) Операции с датой рождения сотрудников");
            System.out.println();
            System.out.println("0) Выход из программы");
            System.out.println();
            System.out.println("Введите номер операции ");
            menuCase = reader.readLine();

            try {
                checkInput(menuCase, "[0-3]");
            } catch (InputDataException e) {
                System.out.println("Неверный ввод данных");
                menuCase = "99";
            }

            switch (menuCase) {
                case "0": {
                    break;
                }

                case "1": {
                    System.out.println("Введите Ф.И.О (для ввода используйте латинские буквы)");
                    SearchName searchName = new SearchName();
                    searchName.searchTool(root.getEmployees());
                    break;
                }

                case "2": {
                  SearchByExperiance searchByExperiance = new SearchByExperiance();
                  searchByExperiance.searchTool(root.getEmployees());
                  break;
                }

                case "3": {
                    do {
                        System.out.println();
                        System.out.println();
                        System.out.println("Список возможных операций");
                        System.out.println();
                        System.out.println("1) Поиск сотрудников по дате рождения");
                        System.out.println();
                        System.out.println("2) Поиск юбиляров в текущем году");
                        System.out.println();
                        System.out.println("3) Расчет среднего возраста сотрудников");
                        System.out.println();
                        System.out.println("4) Сортировка всех сотрудников по дате рождения");
                        System.out.println();
                        System.out.println("0) Возврат в основное меню");
                        System.out.println();
                        System.out.println("Введите номер операции");

                        String str3 = reader.readLine();
                        try {
                            checkInput(str3, "[0-4]");
                        } catch (InputDataException e) {
                            System.out.println("Неверный ввод данных");
                        }

                        menuCase = "3"+str3;

                        switch (menuCase) {
                            case "31": {
                                System.out.println("Введите дату в формате dd.mm.yyyy");
                                SearchDate searchDate = new SearchDate();
                                searchDate.searchTool(root.getEmployees());
                                break;
                            }

                            case "32": {
                                Jubilee jubilee = new Jubilee();
                                jubilee.jubileeFind(root.getEmployees());
                                break;
                            }

                            case "33": {
                                AverageAge averageAge = new AverageAge();
                               averageAge.averageAge(root.getEmployees());
                                break;
                            }

                            case "34": {
                                System.out.println("Отсортированный список сотрудников");
                                System.out.println();
                                Comparator sortByBirthDay = new SortByBirthDayComporator();
                                Collections.sort(root.getEmployees(), sortByBirthDay);
                                System.out.println();
                                for(Employee employee: root.getEmployees()){
                                    Employee.printEmployee(employee);
                                }
                                break;
                            }
                        }
                    } while (!menuCase.equals("30"));
                }

                default: {
                    menuCase = "99";
                }
            }
        } while (!menuCase.equals("0"));
    }

    /**
     * This method prints when search found no result
      */
    static void printSearchFail() {
        System.out.println("Поиск не дал результатов. Совпадений не найдено");
    }




    /**
     * This method checks incoming data for corresponding to pattern
     * @param str
     * @param pattern
     * @throws InputDataException
     */
    static void checkInput(String str, String pattern) throws InputDataException{

            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(str);
            if (!m.matches()) {
                throw new InputDataException();
            }
    }
}
