package by.itacademy.Lesson5.Task2;

public class Rectangle extends Figure{
     private double a;
     private double b;


    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getSqr() {
        return a*b;
    }
}
