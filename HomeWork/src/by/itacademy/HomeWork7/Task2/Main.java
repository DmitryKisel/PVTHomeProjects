package by.itacademy.HomeWork7.Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    static Date currentDate = new Date();
    static int currentYear = currentDate.getYear()+ 1900;
    static int currentMonth = currentDate.getMonth()+1;
    static int currentDay = currentDate.getDate();
    public static int menuCase = 99;
    static List<Student> students = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        do {
            System.out.println("1. Ввод нового студента");
            System.out.println("2. Рассчет среднего возраста");
            System.out.println("0. выход");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            menuCase = Integer.parseInt(reader.readLine());
            switch (menuCase) {
                case 1: {

                    BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Введите фамилию студента");
                    String lastName = reader1.readLine();
                    System.out.println("Введите имя студента");
                    String firstName = reader1.readLine();
                    System.out.println("Введите дату рождения студента(день месяц год)");
                    String birthDate = reader1.readLine();

                    String[] bdate = birthDate.split("\\pP");
                    String inputDate = bdate[0] + "." + bdate[1] + "." + bdate[2];
                    Date data = null;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        data = sdf.parse(inputDate);
                    } catch (ParseException e) {}

                    Student student = new Student(lastName, firstName, data);
                    students.add(student);
                    menuCase = 99;
                    break;
                }
                case 2: {
                    averageAge(students);
                    menuCase = 99;
                }

            }

        } while (menuCase != 0);
    }

    /**
     * This method calculates average value of student age and calls method
     * printAverageAge to print this value
     * @param list
     */
        public static void averageAge(List<Student> list) {
        int count = 0;
        int monthSum = 0;

        for (int i = 0; i < list.size(); i++) {
            Date date = list.get(i).getBirthDate();
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(date);
            int month = gc.get(GregorianCalendar.MONTH)+ 1;
            int year = gc.get(GregorianCalendar.YEAR);
            int ageYears = currentYear - year;
            int ageMonth = currentMonth - month;
                if (ageMonth < 0) {
                ageYears = ageYears - 1;
                ageMonth = 12 + ageMonth;
            }

            monthSum = monthSum + ageYears*12+ ageMonth;
            count++;
        }

        int averageYears = (monthSum/12)/count;
        int averageMonth = Math.round((monthSum - averageYears*12*count)/count);
        printAverageAge(averageYears, averageMonth);

    }


    /**
     * This method prints average value of student age in special format.
     * @param averageYears
     * @param averageMonth
     */
    public static void printAverageAge(int averageYears, int averageMonth) {
        StringBuilder sb = new StringBuilder();
        sb.append("Средний возраст составляет ");
        sb.append(averageYears);

        switch (averageYears%10){
            case 1: { sb.append(" год ");}
            case 2: { sb.append(" года ");}
            case 3: { sb.append(" года ");}
            case 4: { sb.append(" года ");}
            default:  { sb.append(" лет ");}

        }

        if (averageMonth == 0) {
            System.out.println(sb.toString().trim());
        }
        else {
            sb.append("и ");
            sb.append(averageMonth);
            switch (averageMonth){
                case 1: {
                    sb.append(" месяц");
                    break;
                }
                case 2: {
                    sb.append(" месяца");
                    break;
                }
                case 3: {
                    sb.append(" месяца");
                    break;
                }
                case 4: {
                    sb.append(" месяца");
                    break;
                }
                default: {
                    sb.append(" месяцев");
                    break;
                }
            }
            System.out.println(sb.toString().trim());
        }

    }
}
