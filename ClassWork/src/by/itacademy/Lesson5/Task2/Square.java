package by.itacademy.Lesson5.Task2;

public class Square extends Figure{
   private double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double getSqr() {
        return a*a;
    }
}
