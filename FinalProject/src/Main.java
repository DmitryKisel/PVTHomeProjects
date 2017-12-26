import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
   private static String menuCase = "99";
   private static String downloadChoice = "0";



    public static void main(String[] args) throws IOException {
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
        String pattern1 = "[1,2]";
        try {
            checkInput(str, pattern1);
        } catch (InputDataException e) {
            System.out.println("Неверный ввод данных");
        }

        downloadChoice = str;
        FileDownload fd = new FileDownload();

      switch (downloadChoice){
          case "1":{
              System.out.println("Данные из файла birthdays.json успешно загружены");
              root = fd.download(Integer.parseInt(downloadChoice));
              break;

          }

          case "2": {
              System.out.println("Данные из файла birthdays.xml успешно загружены");
              root = fd.download(Integer.parseInt(downloadChoice));
              break;
          }

          default:{
              downloadChoice = "0";

          }
      }


    }while(downloadChoice.equals("0"));

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
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

            menuCase = reader1.readLine();
            String pattern2 = "[0-3]";
            try {
                checkInput(menuCase, pattern2);
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

                        String pattern3 = "[0,1,2,3,4]";
                        try {
                            checkInput(str3, pattern3);
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
                                    printEmployee(employee);
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
     * This method prints employee's data in specific format
     * @param employee
     */
     static void printEmployee(Employee employee) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        System.out.printf("%-30s%-5s%-5d%-30s%-17s%-14s%-7d%-9s%-200s%n", "Ф.И.О: " + employee.getName(),  " ID: ",  employee.getId(),"" +
                " Дата рождения: "  + sdf.format(employee.getDateOfBirth()), " Степень: " + employee.getDegree(),
                " Опыт работы:", employee.getYearEperience(), "e-mails: ", employee.getEmails());
        System.out.println();
    }


    static void checkInput(String str, String ptrn) throws InputDataException{

            String pattern = ptrn;
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(str);
            if (!m.matches()) {

                throw new InputDataException();

            }

    }
}
