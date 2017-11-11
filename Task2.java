import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Задача 2.
Условие:
Создайте любое число(вводится с консоли). Определите, является ли последняя цифра числа семеркой.

 */
public class Task2  {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);

        if ((n % 10) == 7) System.out.println("Последняя цифра является семеркой");
          else System.out.println("Последняя цифра не является семеркой");

    }
}
