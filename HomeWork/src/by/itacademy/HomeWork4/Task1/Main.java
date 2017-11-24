package by.itacademy.HomeWork4.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Patient[] patient = new Patient[5];
        for (int i = 0; i < patient.length; i++) {
            patient[i] = addNewPatient();
        }

        /*
        patient[0]  = new Patient ("Петров Петр Павлович", "аритмия", 63, true);
        patient[1]  = new Patient ("Петровский Сергей Иванович", "ОРВИ", 17, false);
        patient[2]  = new Patient ("Нестеров Сергей Александрович", "остеохондроз", 107, true);
        patient[3]  = new Patient("Карпович Дмитрий Александрович", "ОРВИ", 46, true);
        patient[4] =  new Patient ("Сафронова Анна Ивановна", "ангина", 46, false);
        */

        for (Patient person: patient){
            printPatient(person);
        }
        for (Patient person: patient){
             System.out.println("Пациент " + person.getName() + " - Возраст = " + ageToWord(person.getAge()));
        }


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        label:
        do {
            System.out.println("Список возможных операций");
            System.out.println();
            System.out.println("1) Поиск пациента по Ф.И.О");
            System.out.println();
            System.out.println("2) Поиск пациента по возрасту");
            System.out.println();
            System.out.println("3) Поиск пациента по дагнозу");
            System.out.println();
            System.out.println("4) Поиск медкарты");
            System.out.println();
            System.out.println("0) Выход из программы");
            System.out.println();
            System.out.println("Введите номер операции");


            String operationNumberStr = reader.readLine();


            String patternMain = "[0, 1, 2, 3, 4]";
            Pattern pMain = Pattern.compile(patternMain);
            Matcher m1 = pMain.matcher(operationNumberStr);

            if (!m1.matches()) {
                printError();
                TimeUnit.SECONDS.sleep(1);
                continue label;
            } else {
                byte operationNumber = Byte.parseByte(operationNumberStr);


                if (operationNumber == 1) {

                    System.out.println("Введите Ф.И.О (должны начинаться с заглавной буквы)");
                    String str = reader.readLine();

                    String pattern = "[а-яА-Я, ]+";
                    Pattern p = Pattern.compile(pattern);
                    Matcher m = p.matcher(str);

                    if (!m.matches()) {
                        printError();
                        TimeUnit.SECONDS.sleep(1);
                        continue label;
                    } else {
                        int countName = 0;
                        for (Patient person : patient) {
                            if (person.getName().contains(str)) {
                                printPatient(person);
                                countName++;
                            }
                        }
                        if (countName == 0) {
                            printFail();
                            TimeUnit.SECONDS.sleep(1);
                            continue label;
                        }
                        TimeUnit.SECONDS.sleep(3);
                        continue label;
                    }


                } else if (operationNumber == 2) {

                    System.out.println("Введите возраст");
                    String incomingAgeStr = reader.readLine();

                    String pattern = "[0-9]+";
                    Pattern p = Pattern.compile(pattern);
                    Matcher m = p.matcher(incomingAgeStr);

                    if (!m.matches()) {
                        printError();
                        TimeUnit.SECONDS.sleep(1);
                        continue label;
                    } else {
                        int incomingAge = Integer.parseInt(incomingAgeStr);
                        if (incomingAge < 0 || incomingAge > 120) {
                            printError();
                            TimeUnit.SECONDS.sleep(1);
                            continue label;

                        } else {
                            int countAge = 0;
                            for (Patient person : patient) {
                                if (person.getAge() == incomingAge) {
                                    printPatient(person);
                                    countAge++;
                                }
                            }
                            if (countAge == 0) {
                                printFail();
                                TimeUnit.SECONDS.sleep(1);
                                continue label;
                            }

                            TimeUnit.SECONDS.sleep(3);
                            continue label;
                        }
                    }


                } else if (operationNumber == 3) {
                    System.out.println("Введите диагноз");
                    String str = reader.readLine();

                    String pattern = "[а-яА-Я, ]+";
                    Pattern p = Pattern.compile(pattern);
                    Matcher m = p.matcher(str);

                    if (!m.matches()) {
                        printError();
                        TimeUnit.SECONDS.sleep(1);
                        continue label;
                    } else {
                        int countName = 0;
                        for (Patient person : patient) {
                            if (person.getDiagnostic().contains(str)) {
                                printPatient(person);
                                countName++;
                            }
                        }
                        if (countName == 0) {
                            printFail();
                            TimeUnit.SECONDS.sleep(1);
                            continue label;
                        }
                        TimeUnit.SECONDS.sleep(3);
                        continue label;

                    }


                } else if (operationNumber == 4) {
                    System.out.println("Список возможных операций");
                    System.out.println();
                    System.out.println("1) Поиск медкарты по Ф.И.О");
                    System.out.println();
                    System.out.println("2) Вывод списка всех пациентов без медкарты");

                    String str = reader.readLine();
                    String pattern = "[1, 2]";
                    Pattern p = Pattern.compile(pattern);
                    Matcher m = p.matcher(str);

                    if (!m.matches()) {
                        printError();
                        TimeUnit.SECONDS.sleep(1);
                        continue label;
                    } else {
                        byte operation = Byte.parseByte(str);


                        if (operation == 1) {
                            System.out.println("Введите Ф.И.О");
                            String str1 = reader.readLine();

                            String pattern2 = "[а-яА-Я, ]+";
                            Pattern p2 = Pattern.compile(pattern2);
                            Matcher m2 = p2.matcher(str1);

                            if (!m2.matches()) {
                                printError();
                                TimeUnit.SECONDS.sleep(1);
                                continue label;
                            } else {
                                int countName = 0;
                                for (Patient person : patient) {
                                    if (person.getName().contains(str1)) {
                                        printPatientChart(person);
                                        countName++;
                                    }
                                }
                                if (countName == 0) {
                                    printFail();
                                    TimeUnit.SECONDS.sleep(1);
                                    continue label;
                                }
                                TimeUnit.SECONDS.sleep(3);
                                continue label;
                            }
                        } else if (operation == 2) {
                            System.out.println("Список пациентов без медкарт");
                            for (Patient person : patient) {
                                if (!person.isPatientChartIsAvailable()) printPatient(person);
                            }
                        }
                    }


                } else if (operationNumber == 0) {
                    System.out.println("До свидания! Хорошего дня");
                    break;
                }
            }
        } while (true);

    }


    public static void printPatient(Patient patient) {
        System.out.printf("%-40s%-34s%-11s%3d", "Ф.И.О: " + patient.getName(), "  Текущий диагноз: " + patient.getDiagnostic(), "  Возраст: ", patient.getAge());
        if (patient.isPatientChartIsAvailable())
            System.out.println("    медицинская карта в наличии");
        else System.out.println("    медицинская карта отсутствует");

    }

    /**
     * This method shows information about is patient chart available or not
     * @param patient
     */
    public static void printPatientChart(Patient patient) {
        System.out.printf("%-40s", "Ф.И.О: " + patient.getName());
        if (patient.isPatientChartIsAvailable())
            System.out.println("    медицинская карта в наличии");
        else System.out.println("    медицинская карта отсутствует");

    }

    /**
     * This method prints message if search was failed
     */
    public static void printFail() {
        System.out.println("Пациент с такими данными не найден");
    }

    /**
     * This method print message if invalid value was inputted
     */
    public static void printError() {
        System.out.println("Вы ввели недопустимое значение");
    }

    /**
     * This method does incoming age number into words
     * @param number
     * @return
     */
    public static String ageToWord (int number){
        int digit = number%10;
        int decade = (number%100 -digit)/10;
        int hundred = (number - number%100)/100;
        StringBuilder sb = new StringBuilder();


        if (number == 0) {System.out.println("ноль лет"); }
        else {
            if (hundred == 1) sb.append("сто ");
            if (decade == 1) {

                switch (digit) {
                    case 0: {
                        sb.append("десять ");
                        digit = 0; break;
                    }
                    case 1: {
                        sb.append("одиннадцать ");
                        digit = 0;break;
                    }
                    case 2: {
                        sb.append("двенадцать ");
                        digit = 0;break;
                    }
                    case 3: {
                        sb.append("тринадцать ");
                        digit = 0;break;
                    }
                    case 4: {
                        sb.append("четырнадцать ");
                        digit = 0;break;
                    }
                    case 5: {
                        sb.append("пятнадцать ");
                        digit = 0;break;
                    }
                    case 6: {
                        sb.append("шестнадцать ");
                        digit = 0;break;
                    }
                    case 7: {
                        sb.append("семнадцать ");
                        digit = 0;break;
                    }
                    case 8: {
                        sb.append("восемнадцать ");
                        digit = 0;break;
                    }
                    case 9: {
                        sb.append("девятнадцать ");
                        digit = 0;break;
                    }
                }
            } else {
                switch (decade) {
                    case 0: {
                        break;
                    }
                    case 2: {
                        sb.append("двадцать ");
                        break;
                    }
                    case 3: {
                        sb.append("тридцать ");
                        break;
                    }
                    case 4: {
                        sb.append("сорок ");
                        break;
                    }
                    case 5: {
                        sb.append("пятьдесят ");
                        break;
                    }
                    case 6: {
                        sb.append("шестьдесят ");
                        break;
                    }
                    case 7: {
                        sb.append("семдесят ");
                        break;
                    }
                    case 8: {
                        sb.append("восемьдесят ");
                        break;
                    }
                    case 9: {
                        sb.append("девяносто ");
                        break;
                    }
                }
            }
            switch (digit) {
                case 0: {
                    sb.append("лет");
                    break;
                }
                case 1: {
                    sb.append("один год");
                    break;
                }
                case 2: {
                    sb.append("два года");
                    break;
                }
                case 3: {
                    sb.append("три года");
                    break;
                }
                case 4: {
                    sb.append("четыре года");
                    break;
                }
                case 5: {
                    sb.append("пять лет");
                    break;
                }
                case 6: {
                    sb.append("шесть лет");
                    break;
                }
                case 7: {
                    sb.append("семь лет");
                    break;
                }
                case 8: {
                    sb.append("восемь лет");
                    break;
                }
                case 9: {
                    sb.append("девять лет");
                    break;
                }
            }
        }
    return sb.toString();
    }


    /**
     * This method adds new patient to array;
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static Patient addNewPatient() throws IOException, InterruptedException {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите Ф.И.О. пациента");
        System.out.println("При вводе данных используйте, пожалуйста, только кирилицу");
        String name = rdr.readLine();

        System.out.println("Введите возраст пациента");
        System.out.println("При вводе данных используйте, пожалуйста, значения от 0 до 120");
        int age = Integer.parseInt(rdr.readLine());

        System.out.println("Введите диагноз");
        System.out.println("При вводе данных используйте, пожалуйста, только кирилицу");
        String diag = rdr.readLine();

        System.out.println("Введите данные о наличии медкарты");
        System.out.println("1 - если карта в наличии, 0 - если нет");
        int chart = Integer.parseInt(rdr.readLine());
        boolean isAvalableChart;
        if (chart == 1) isAvalableChart = true;
        else isAvalableChart = false;


        Patient patient = new Patient(name, diag, age, isAvalableChart);
        return patient;
    }

}




