package by.itacademy.Lesson14.Task2;

public class Task2Main {
    public static void main(String[] args) {
        System.out.println("start main");
        Task2 thread1 = new Task2();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //все что написано внутри run, будет запущено в этом патоке
                for(int i = 0; i < 10; i++){
                    System.out.println("thread2 i = " + i);
                    test();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();

        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end main");
    }
    public static void test(){

    }
}
