package by.itacademy.HomeWork4.Task1;

import  java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        Patient[]  patient = new Patient[5];
        patient[0]  = new Patient ("Петров Петр Павлович", "аритмия", 65, true);
        patient[1]  = new Patient ("Петровский Сергей Иванович", "ОРВИ", 19, false);
        patient[2]  = new Patient ("Нестеров Сергей Александрович", "остеохондроз", 28, true);
        patient[3]  = new Patient("Карпович Дмитрий Александрович", "ОРВИ", 25, true);
        patient[4] =  new Patient ("Сафронова Анна Ивановна", "ангина", 28, false);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        label: do {
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
                TimeUnit.SECONDS.sleep(3);
                continue label;}
            else {
                byte operationNumber = Byte.parseByte(operationNumberStr);
                if (operationNumber == 1) {

                    System.out.println("Введите Ф.И.О");
                    String str = reader.readLine();

                    String pattern = "[а-яА-Я, ]+";
                    Pattern p = Pattern.compile(pattern);
                    Matcher m = p.matcher(str);

                    if (!m.matches()) {
                        printError();
                        TimeUnit.SECONDS.sleep(3);
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
                            TimeUnit.SECONDS.sleep(3);
                            continue label;
                        }
                        TimeUnit.SECONDS.sleep(5);
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
                        TimeUnit.SECONDS.sleep(3);
                        continue label;
                    } else {
                        int incomingAge = Integer.parseInt(incomingAgeStr);
                        if (incomingAge < 0 || incomingAge > 120) {
                            printError();
                            TimeUnit.SECONDS.sleep(3);
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
                                TimeUnit.SECONDS.sleep(3);
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
                        TimeUnit.SECONDS.sleep(3);
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
                            TimeUnit.SECONDS.sleep(3);
                            continue label;
                        }
                        TimeUnit.SECONDS.sleep(3);
                        continue label;

                    }


                } else if (operationNumber == 4) {

                } else if (operationNumber == 0) {
                    System.out.println("До свидания! Хорошего дня");
                    break;
                }
            }
        } while(true);

    }


    public static void printPatient(Patient patient){
        System.out.printf("%-40s%-34s%-11s%3d", "Ф.И.О: " + patient.getName(),"  Текущий диагноз: " +  patient.getDiagnostic(),"  Возраст: ", patient.getAge());
        if(patient.isPatientChartIsAvailable())
            System.out.println("    медицинская карта в наличии");
        else System.out.println("    медицинская карта отсутствует");

    }

    public static void printFail() {
        System.out.println("Пациент с такими данными не найден");
    }

    public static void printError(){
        System.out.println("Вы ввели недопустимое значение");
    }

}
