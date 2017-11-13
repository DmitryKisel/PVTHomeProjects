import java.io.*;

/*
Задача 4.
Условие:
Имеется целое число (любое), это число — сумма денег в рублях.
Вывести это число, добавив к нему слово «рублей» в правильном падеже.
 */

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int number = Integer.parseInt(s);
        int lastTwoDigit = number%100;
        if (lastTwoDigit >=11 && lastTwoDigit<=19)
        {System.out.println(number + " рублей");}
        else { int lastDigit = number % 10;
        switch (lastDigit) {
            case 1: {
                System.out.println(number + " рубль");
                break;
            }

            case 2: {
                System.out.println(number + " рубля");
                break;
            }
            case 3: {
                System.out.println(number + " рубля");
                break;
            }

            case 4: {
                System.out.println(number + " рубля");
                break;
            }

            default: {
                System.out.println(number + " рублей");
                break;
            }
        }
        }
    }
}