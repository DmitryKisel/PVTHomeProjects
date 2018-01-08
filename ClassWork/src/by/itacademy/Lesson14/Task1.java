package by.itacademy.Lesson14;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("start main");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //все что написано внутри run, будет запущено в этом патоке
                for(int i = 0; i < 10; i++){
                    System.out.println("thread1 i = " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //все что написано внутри run, будет запущено в этом патоке
                for(int i = 0; i < 10; i++){
                    System.out.println("thread2 i = " + i);
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

        System.out.println("end main");
    }
}
