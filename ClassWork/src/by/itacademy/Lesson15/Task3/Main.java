package by.itacademy.Lesson15.Task3;

public class Main {
    private volatile   String value;

    public static void main(String[] args) {
        Main main = new Main();
        Thread thread = new Thread( new Runnable() {
            @Override
            public void run() {
                main.value = "kjdkwjdkwj";
            }
        });

        Thread thread2 = new Thread( new Runnable() {
            @Override
            public void run() {

                main.value = main.value + "AAAAAAAA";
            }
        });

        thread.start();
        thread2.start();

    }

}
