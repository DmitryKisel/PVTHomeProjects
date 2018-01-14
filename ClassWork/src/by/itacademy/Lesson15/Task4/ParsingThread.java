package by.itacademy.Lesson15.Task4;

public class ParsingThread extends Thread {
    private DownloadThread downloadThread;

    public void setDownloadThread(DownloadThread downloadThread) {
        this.downloadThread = downloadThread;
    }

    @Override
    public void run() {
        System.out.println("parsing wait");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("json parsing");
        // parsing JSON

        downloadThread.notify();//put in sinchronize block
        System.out.println("Parsing wait");

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //parsing XML


    }
}
