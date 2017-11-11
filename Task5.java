import java.io.*;

/*
Задача 5.
Условие:
Имеется строка, которая содержит символы ? и символы #.
Замените все символы ? на HELLO, а # - удалите. Результат вывести на экран.

 */
public class Task5  {
    public static void main(String[] args) throws IOException{


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (s.contains("?")) {
           s =  s.replace("?", "HELLO");
        }
        if (s.contains("#")) {
            s = s.replace("#", "");
        }
        System.out.println(s);
    }
}
