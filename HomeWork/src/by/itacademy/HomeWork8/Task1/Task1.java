package by.itacademy.HomeWork8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
       public static void main(String[] args) {
        Calc myCalc = new Calc();
        double result = 0;
        String menuCase = "work";
        String firstN = null;
        String secondN = null;
        String operand = null;
        double firstNumber;
        double secondNumber;

        System.out.println("Вас приветстует программа \"Калькулятор\" ");
        System.out.println("Для выходя наберите \"exit\"");
        do{
            BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));


            System.out.println("Введите первое число");
            try{
                firstN = reader.readLine();}
            catch (IOException e) {
                System.out.println("Ошибка ввода данных");
            }
            if (exitCheck(firstN)){
                String pattern = "-?\\d+\\.?\\d*";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(firstN);

                if(!m.matches()) {
                    printError();
                    menuCase = "work";
                    break;
                }
                else {
                    firstNumber = Double.parseDouble(firstN);
                    menuCase = "work";
                }
            }
            else {menuCase = "exit"; break;}


            System.out.println("Введите операцию");
            try{
                operand = reader.readLine();}
            catch (IOException e) {
                System.out.println("Ошибка ввода данных");
            }
            if (exitCheck(operand)){
                String pattern = "[+, \\-, *, /]";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(operand);

                if(!m.matches()) {
                    printError();
                    menuCase = "work";
                    break;
                }
            }
            else {menuCase = "exit"; break;}

            System.out.println("Введите второе число");
            try{
                secondN = reader.readLine();}
            catch (IOException e) {
                System.out.println("Ошибка ввода данных");
            }
            if (exitCheck(secondN)){
                String pattern = "\\d+\\.?\\d*";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(secondN);

                if(!m.matches()) {
                    printError();
                    menuCase = "work";
                    break;
                }
                else {
                    secondNumber = Double.parseDouble(secondN);
                    menuCase = "work";
                }
            }
            else {menuCase = "exit"; break;}

            try {
                result = myCalc.count(firstNumber,secondNumber, operand );
            } catch (ArithmeticException e){
                System.out.println(e.toString());
                menuCase = "work";
                break;

            }

            System.out.println("Результат:");
            System.out.println(result);
            menuCase = "work";





        }while (!menuCase.equals("exit"));


    }

    public  static boolean exitCheck(String str){
        if (str.toLowerCase().equals("exit")){
            return false;
        }
        else {
            return  true;
        }
    }

    public  static  void printError(){
        System.out.println("Ошибка ввода данных");
    }
}
