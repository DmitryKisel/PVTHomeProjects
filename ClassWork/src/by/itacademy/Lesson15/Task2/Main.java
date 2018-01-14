package by.itacademy.Lesson15.Task2;


public class Main {
    private  static Object object = new Object();

    public static void main(String[] args) {
     Thread thread = new Thread( new Runnable() {
            @Override
            public void run() {
            Main main = new Main();
                main.print10();
            }
        });

        Thread thread2 = new Thread( new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
                main.print10();
            }
        });

        thread.start();
        thread2.start();

    }
    public void print10(){
        synchronized (object) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
