package by.itacademy.HomeWork6.Task3;

public class Square extends Shape {
    private  double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public  double getArea() {
        return a*a;
    }
}
