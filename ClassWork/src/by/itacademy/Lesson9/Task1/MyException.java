package by.itacademy.Lesson9.Task1;

public class MyException extends Exception {
    private  String russianMessage;

    public MyException( String russianMessage) {
        this.russianMessage = russianMessage;
    }


    public String getRussianMessage() {
        return russianMessage;
    }
}
