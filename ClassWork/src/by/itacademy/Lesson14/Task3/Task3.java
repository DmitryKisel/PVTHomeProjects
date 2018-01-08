package by.itacademy.Lesson14.Task3;

public class Task3 extends Thread{
    private boolean isFinish = false;

    public void setFinish(boolean finish){
        isFinish = finish;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            if(isFinish) return;
            System.out.println("thread1 i = " + i);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
