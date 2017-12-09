package by.itacademy.Lesson9.Task2;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static String createCase = "Y";
    public static void main(String[] args) throws IOException, InterruptedException {
        List<Student> students = new ArrayList<>();

        do {
            String inputName = null;
            String ages = null;
            int age = 0;

                BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Введите Ф.И.О.");
                inputName = rdr.readLine();
                System.out.println("Введите возраст");
                ages = rdr.readLine();
                age = Integer.parseInt(ages);
                Student st = new Student(inputName, age);
                students.add(st);

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

        for(Student student : students){
            System.out.println(student.getName() + " " + student.getAge());
        }


        Student student1 = new Student("Gooo", 47);
        Student student2 = new Student("Goooo", 47);

            System.out.println(student1.equals(student2));

        // первый вариант применяется если нужен только один вар сортировки
        Collections.sort(students);

        // второй вариант применяется если несколько вар сортировки по разным параметрам
        Comparator sortByAge = new SortByAgeComparator();
        Collections.sort(students, sortByAge);

    }
}
