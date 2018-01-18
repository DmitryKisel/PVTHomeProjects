package by.itacademy.homeWork15;

public class MyThread extends Thread{
    private  Main main = new Main();

    @Override
    public void run() {
        int count =1;
        for (int i = 0; i < 10; i++) {
            count=main.print10(count);

            if (Thread.currentThread().getName().equals("myThread1")){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) { }
            }else{
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) { }
            }
        }

    }
}
