package by.itacademy.HomeWork6.Task3;

public class Triangle extends Shape{
    double a;
    double b;
    double angelB;

    public Triangle(double a, double b, double angelB) {
        this.a = a;
        this.b = b;
        this.angelB = angelB;
    }

    @Override
    public double getArea() {

        double radians = Math.toRadians(angelB);
        return  0.5*(Math.sin(radians)*b)*a;

    }
}
