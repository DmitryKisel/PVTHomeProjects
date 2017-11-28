package by.itacademy.HomeWork6.Task3;

public class Rectangle extends  Shape{
    double a;
    double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return  a*b;
    }
}
