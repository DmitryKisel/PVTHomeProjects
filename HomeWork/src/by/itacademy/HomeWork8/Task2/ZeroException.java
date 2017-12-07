package by.itacademy.HomeWork8.Task2;

public   class ZeroException extends Exception {

    public  ZeroException() {
        super.getMessage();
    }

    public String getRussianMessage(){
        String text = "Ошибка: деление на ноль";
        return text;
    }


}
