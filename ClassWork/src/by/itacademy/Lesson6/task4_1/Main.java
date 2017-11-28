package by.itacademy.Lesson6.task4_1;

public class Main {
    public static void main(String[] args) {
        UI main = new UI();
        Button button = new Button();
        button.setButtonClick(main);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        button.emulateClickOnButton();
    }
}
