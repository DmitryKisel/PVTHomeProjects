package by.itacademy.Lesson14.Task4;

public class Task4 extends Thread{

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            if(isInterrupted()) {
                System.out.println("Stop by if");
                return;}
            System.out.println("thread1 i = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Stop by InterraptedException");
                return;
            }
        }
    }
}
