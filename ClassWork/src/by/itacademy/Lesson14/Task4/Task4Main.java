package by.itacademy.Lesson14.Task4;

public class Task4Main {
    public static void main(String[] args) {
        System.out.println("start main");
        Task4 thread1 = new Task4();
        thread1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }

        thread1.interrupt();

        System.out.println("end main");
    }
    public synchronized static void openFile(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
