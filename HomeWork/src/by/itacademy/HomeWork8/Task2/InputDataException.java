package by.itacademy.HomeWork8.Task2;


public class InputDataException extends Exception{
    private String russianMessage;

    public InputDataException( String russianMessage) {
        this.russianMessage = russianMessage;
    }


    public String getRussianMessage() {
        return russianMessage;
    }
}

