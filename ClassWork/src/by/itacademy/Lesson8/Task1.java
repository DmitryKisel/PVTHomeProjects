package by.itacademy.Lesson8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task1 {
    public static void main(String[] args) {
  /*      try {
            // блок кода в котором потенциально может быть  проблема
            int a = 5 / 1;
            SimpleDateFormat sdf = new SimpleDateFormat("");
            Date date = sdf.parse(" wjdjwd");
        } catch (ArithmeticException e) {

            // блок кодавыполнится если в блоке try
            // произошла ошибка
            System.out.println("Ошибка - деление на ноль" + e.toString());
        } catch (ParseException e) {
            System.out.println("Ошибка с датой");

        } finally {
            System.out.println("finaly");
        }

// Два эксепшина можно заменить на Exception - который является общим родительским
// классом для других видов исключений


        *//*ВАЖНО! Если в каскаде исключений первым буде Exception - то до других дело
        не дойдет, а если наоборот то более частные исключения выполнятся,
        *
        * e.toString() - позволяет более полно понять ошибку
        * *//*
        System.out.println("Продолжение программы");*/
        try {
            double result = test(1, 5);
        } catch (FiveException e) {
            System.out.println("Ошибка, вводить на 5 запрещено");
        }


    }

    public static double test (int a, int b) throws FiveException  {
        if (b == 5) {
            throw  new FiveException();
        }
        return a/b;

    }



}

