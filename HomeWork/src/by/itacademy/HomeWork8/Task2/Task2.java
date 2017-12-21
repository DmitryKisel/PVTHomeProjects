package by.itacademy.HomeWork8.Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) throws IOException, InputDataException {
        Calc myCalc = new Calc();
        double result = 0;
        String menuCase = "work";
        String firstN = null;
        String secondN = null;
        String operand = null;
        double firstNumber = 0;
        double secondNumber = 0;

        System.out.println("Вас приветстует программа \"Калькулятор\" ");
        System.out.println("Для выходя наберите \"exit\"");
        do{
            BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));


            System.out.println("Введите первое число");
            try{
                firstN = reader.readLine();
            if (exitCheck(firstN)){
                String pattern = "-?\\d+\\.?\\d*";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(firstN);

                if(!m.matches()) {
                    menuCase = "work";
                    throw  new InputDataException("Число не соответствует формату ввода");


                }
                else {
                    firstNumber = Double.parseDouble(firstN);
                    menuCase = "work";
                }
            }
            else {
                menuCase = "exit";
                break;}
            }
            catch (InputDataException e) {
                System.out.println(e.getRussianMessage());
            }


            System.out.println("Введите операцию");
            try {
                operand = reader.readLine();
                if (exitCheck(operand)) {
                    String pattern = "[+, *, /, \\-]";
                    Pattern p = Pattern.compile(pattern);
                    Matcher m = p.matcher(operand);

                    if (!m.matches()) {
                        menuCase = "work";
                        throw new InputDataException("Математический символ не соответствует формату ввода");


                    }
                } else {
                    menuCase = "exit";
                    break;
                }
            }
            catch (InputDataException e) {
                System.out.println(e.getRussianMessage());
            }

            System.out.println("Введите второе число");
            try{
                secondN = reader.readLine();
                if (exitCheck(secondN)){
                    String pattern = "-?\\d+\\.?\\d*";
                    Pattern p = Pattern.compile(pattern);
                    Matcher m = p.matcher(secondN);

                    if(!m.matches()) {
                        menuCase = "work";
                        throw  new InputDataException("Число не соответствует формату ввода");


                    }
                    else {
                        secondNumber = Double.parseDouble(secondN);
                        menuCase = "work";
                    }
                }
                else {
                    menuCase = "exit";
                    break;}
            }
            catch (InputDataException e) {
                System.out.println(e.getRussianMessage());
            }

            try {
                result = myCalc.count(firstNumber,secondNumber, operand );
            } catch (ZeroException e){
                System.out.println(e.getRussianMessage());
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


}
