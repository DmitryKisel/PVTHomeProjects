package by.itacademy.HomeWork8.Task4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main implements ListAdd{
    public static int menuCase = 99;
    public static String createCase = "Y";
    public static void main(String[] args) throws IOException, InterruptedException {
       List<Employee> employees = new ArrayList<>();
       Main main = new Main();
        File file = new File("D:\\employees.txt");
        if (file.exists()){
            try (BufferedReader fis = new BufferedReader( new InputStreamReader( new FileInputStream(file)))){
                String line;
                while ((line = fis.readLine()) != null) {
                    String[] employee = line.split("\\s");
                    StringBuilder sbFIO = new StringBuilder();
                    sbFIO.append(employee[0] + " " + employee[1] + " " + employee[2]);
                    String occup = employee[3];
                    String bd = employee[4];
                    Date data = null;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        data = sdf.parse(bd);
                    } catch (ParseException e) {
                        System.out.println("Ошибка даты");
                    }

                    Employee empl = new Employee(sbFIO.toString(), occup, data);
                    employees.add(empl);


                }
                fis.close();
            } catch (IOException e) {   System.out.println("Ошибка чтения файла");        }
        }
        else {
            System.out.println("Файл не найден. Создаем новый файл");
            file.createNewFile();
            do {
                main.addEmployee(employees);
                System.out.println("Хотите добавить еще одного сотрудника? Если нет - нажмите \"N\" и ввод, если да - любую клавишу и ввод" );

                BufferedReader rdr1 = new BufferedReader(new InputStreamReader(System.in));
                String str = rdr1.readLine();
                if (str.toLowerCase().equals("n")){
                    createCase = "N";
                }
                else {
                    createCase = "Y";
                }

            } while (createCase != "N");

            StringBuilder stringBuilder = new StringBuilder();
            BufferedWriter fos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
            for (Employee employee: employees){
                stringBuilder.append(employee.getFullName());
                stringBuilder.append(" ");
                stringBuilder.append(employee.getOccupation());
                stringBuilder.append(" ");
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy");
                String bd = sdf1.format(employee.getDateOfBirth());
                stringBuilder.append(bd);
                stringBuilder.append("\\n");


            }
            fos.write(stringBuilder.toString());
            fos.flush();
            fos.close();

        }



        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Список возможных операций");
            System.out.println();
            System.out.println("1) Поиск сотрудников по Ф.И.О");
            System.out.println();
            System.out.println("2) Поиск сотрудников по должности");
            System.out.println();
            System.out.println("3) Поиск сотрудников по дате рождения");
            System.out.println();
             System.out.println("0) Выход из программы");
            System.out.println();
            System.out.println("Введите номер операции");

            menuCase = Integer.parseInt(reader.readLine());

            switch (menuCase) {
                case 1: {
                    System.out.println("Введите Ф.И.О");
                    Search srch = new SearchName();
                    srch.searchTool(employees);
                    break;
                }

                case 2: {
                    System.out.println("Введите должность");
                    Search srch = new SearchOccupation();
                    srch.searchTool(employees);
                    break;
                }
                case 3: {
                    do {
                        System.out.println("Список возможных операций");
                        System.out.println();
                        System.out.println("1) Поиск сотрудников по дате рождения");
                        System.out.println();
                        System.out.println("0) Возврат в основное меню");
                        System.out.println();
                        System.out.println("Введите номер операции");

                        menuCase = Integer.parseInt(reader.readLine())+30;
                        switch (menuCase) {
                            case 31: {
                                System.out.println("Введите дату рождения сотрудника в формате число.месяц.год");
                                System.out.println();
                                try{
                                    Search search = new SearchDate();
                                    search.searchTool(employees);
                                } catch (NumberFormatException e) {
                                    System.out.println("Ошибка ввода даты");
                                }

                                break;
                            }

                        }

                    } while (menuCase != 30);

                }

            }
        } while (menuCase != 0);

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

    public static void printEmployee(Employee employee) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        System.out.printf("%-40s%-34s%-15s", "Ф.И.О: " + employee.getFullName(), "  Должность: " + employee.getOccupation(), "Дата рождения "  + sdf.format(employee.getDateOfBirth()));
        System.out.println();
    }

    @Override
    public List<Employee> addEmployee(List<Employee> list) {
        String inputName = null;
        String birthDate = null;
        String ocupation = null;
        try {
            BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите Ф.И.О.");
            inputName = rdr.readLine();
            System.out.println("Введите должность");
            ocupation = rdr.readLine();
            System.out.println("Введите дату рождения (день месяц год)");
            birthDate = rdr.readLine();

        } catch (IOException e){
            System.out.println("Ошибка ввода данных");
        }

        String[] bdate = birthDate.split("\\pP");
        String inputDate = bdate[0] + "." + bdate[1] + "." + bdate[2];
        Date data = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            data = sdf.parse(inputDate);
        } catch (ParseException e) {}

        Employee empl = new Employee(inputName, ocupation, data);
        list.add(empl);
        return list;
    }


}

