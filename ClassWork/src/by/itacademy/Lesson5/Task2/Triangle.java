package by.itacademy.Lesson5.Task2;

public class Triangle extends Figure {
    private  double h;
    private double a;

    public Triangle(double h, double a) {
        this.h = h;
        this.a = a;

    }

    @Override
    public double getSqr() {
        return 05*h*a;
    }
}
