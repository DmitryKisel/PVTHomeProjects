package by.itacademy.HomeWork8.Task2;

public class Calc {

    public  double addition (double x, double y){
        return  x + y;
    }

    public  double multiplication (double x, double y){
        return  x * y;
    }

    public  double division (double x, double y){
        return  x / y;
    }

    public  double substraction (double x, double y){
        return x - y;
    }

    public double count(double x, double y, String operand) throws ZeroException {
        switch (operand){
            case ("+"):{
                return  this.addition(x , y);}
            case ("-"):{
                return  this.substraction(x , y);}
            case ("*"):{
                return  this.multiplication(x , y);}
            case ("/"):{
                if(y==0) throw  new ZeroException();
                return  this.division(x , y);}

            default: return 0;

        }
    }
}


