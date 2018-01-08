package by.itacademy.Lesson14.Task3;

public class Task3Main {
    public static void main(String[] args) {
        System.out.println("start main");
        Task3 thread1 = new Task3();
        thread1.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.setFinish(true);

        System.out.println("end main");
    }
}
