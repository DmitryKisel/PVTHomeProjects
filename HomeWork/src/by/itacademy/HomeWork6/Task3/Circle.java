package by.itacademy.HomeWork6.Task3;

public class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }



    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }
}