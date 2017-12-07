package by.itacademy.HomeWork8.Task2;

import java.io.IOException;

public class InputDataException extends IOException{


    public  InputDataException() {
        super.getMessage();
    }

    public String getRussianMessage(){
        String text = "Ошибка ввода данных";
        return text;
    }
}
