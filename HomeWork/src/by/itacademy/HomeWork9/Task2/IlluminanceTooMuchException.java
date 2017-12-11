package by.itacademy.HomeWork9.Task2;

public class IlluminanceTooMuchException extends Exception {
    private  String russianMessage;

    public IlluminanceTooMuchException( String russianMessage) {
        this.russianMessage = russianMessage;
    }


    public String getRussianMessage() {
        return russianMessage;
    }
}
