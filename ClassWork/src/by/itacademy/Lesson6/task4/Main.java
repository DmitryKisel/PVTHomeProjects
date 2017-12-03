package by.itacademy.Lesson6.task4;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Button button = new Button();
        button.setMain(main);



        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){}

        button.emulateClickOnButton();
    }

    public void onClick(){
        System.out.println("Click");
    }
}
