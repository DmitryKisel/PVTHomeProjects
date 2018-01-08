package by.itacademy.Lesson14.Task5;

import java.util.concurrent.LinkedBlockingQueue;

public class Task5Main {
    private  static LinkedBlockingQueue<Integer> list = new LinkedBlockingQueue<>();
    private static StringBuilder stringBuilder = new StringBuilder();
    private static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {

        System.out.println("start main");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //все что написано внутри run, будет запущено в этом патоке
                for (int i = 0; i < 10; i++) {
                    stringBuilder.append(i);
                    stringBuffer.append(i);

                    list.peek();

                    try {
                        Thread.sleep(100);
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
                for (int i = 10; i > 0; i--) {
                    stringBuilder.append(i);
                    stringBuffer.append(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread1.setName("111");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.isAlive();
        thread2.setDaemon(true);
        thread2.start();

        System.out.println("end main");
        try {
            thread1.join();thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(stringBuilder.toString());
        System.out.println(stringBuffer.toString());
    }
}
