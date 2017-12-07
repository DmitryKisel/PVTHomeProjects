package by.itacademy.HomeWork8.Task1;

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

    public double count(double x, double y, String operand){
        switch (operand){
            case ("+"):{
                return  this.addition(x , y);}
            case ("-"):{
                return  this.substraction(x , y);}
            case ("*"):{
                return  this.multiplication(x , y);}
            case ("/"):{
                return  this.division(x , y);}

            default: return 0;

            }
        }
    }

