package by.itacademy.Lesson5.Task2;

public class Main {
    public static void main(String[] args) {
        Figure figure = null;

        int input =1;
        switch (input){
            case 1:{
                figure = new Triangle(10, 20);
                break;
            }
            case 2:{
                figure = new Square(50);
                break;
            }
            default:{
                System.out.println("Такой фигуры нет");
            }
        }
        printFigureSqr(figure);
    }

    private static  void printFigureSqr(Figure figure){
        System.out.println("площадь фигуры " + figure.getSqr());
        if(figure instanceof Triangle) System.out.println("треугольник");
        if(figure instanceof Square) System.out.println("квадрат");

    }
}
