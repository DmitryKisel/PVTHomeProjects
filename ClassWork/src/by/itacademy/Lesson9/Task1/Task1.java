package by.itacademy.Lesson9.Task1;

public class Task1 {
    public static void main(String[] args) {
        try {
            test(5);
        } catch (MyException e){
            System.out.println(e.getRussianMessage());
        }
    }

    public static void test(int a) throws MyException{
        if (a == 5){
            throw  new MyException("5 недопустимый символ");
        }
    }
}
