package by.itacademy.Lesson14.Task2;

public class Task2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("thread1 i = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
