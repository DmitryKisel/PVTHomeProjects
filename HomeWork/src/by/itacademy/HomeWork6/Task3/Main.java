package by.itacademy.HomeWork6.Task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int menuCase;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Shape shape = null;

        do {
            System.out.println("Список возможных операций");
            System.out.println();
            System.out.println("1) Расчет площади квадрата");
            System.out.println();
            System.out.println("2) Расчет площади круга ");
            System.out.println();
            System.out.println("3) Расчет площади треугольника");
            System.out.println();
            System.out.println("4) Расчет площади прямоугольника");
            System.out.println();
            System.out.println("0) Выход из программы");
            System.out.println();
            System.out.println("Введите номер операции");

            menuCase = Integer.parseInt(reader.readLine());

            switch (menuCase) {
                case 1: {
                    System.out.println("Вевдите длину стороны квадрата");
                    double a = Double.parseDouble(reader.readLine());
                    shape = new Square(a);
                    printArea(shape);
                    menuCase = 99;
                    break;
                }

                case 2: {
                    System.out.println("Вевдите радиус круга");
                    double r = Double.parseDouble(reader.readLine());
                    shape = new Circle(r);
                    printArea(shape);
                    menuCase = 99;
                    break;
                }
                case 3: {
                    System.out.println("Вевдите длину стороны треугольника");
                    double a = Double.parseDouble(reader.readLine());
                    System.out.println("Вевдите длину второй стороны треугольника");
                    double b = Double.parseDouble(reader.readLine());
                    System.out.println("Вевдите угол треугольника");
                    double angleA = Double.parseDouble(reader.readLine());
                    shape = new Triangle(a, b, angleA);
                    printArea(shape);
                    menuCase = 99;
                    break;
                }

                case 4: {
                    System.out.println("Вевдите длину стороны прямоугольника");
                    double a = Double.parseDouble(reader.readLine());
                    System.out.println("Вевдите длину второй стороны прямоугольника");
                    double b = Double.parseDouble(reader.readLine());
                    shape = new Rectangle(a, b);
                    printArea(shape);
                    menuCase = 99;
                    break;
                }
            }
        } while (menuCase != 0);


    }
    public  static void printArea(Shape shape){
        System.out.println("Площадь равна: " + shape.getArea() );
    }
}
