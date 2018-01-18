package by.itacademy.homeWork16;

import by.itacademy.homeWork16.Data.Downloader.FileDownload;

import java.io.File;

public class DownloadThread extends Thread {
    private ParsingThread parsingThread;

    public void setParsingThread(ParsingThread parsingThread) {
        this.parsingThread = parsingThread;
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Downloading JSON file");
            FileDownload fd1 = new FileDownload();
            File file1 = fd1.download(1);

            this.notifyAll();//put in sinchronize block

                System.out.println("Parsing wait");

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            System.out.println("Downloading XML file");
            FileDownload fd2 = new FileDownload();
            File file2 = fd2.download(2);

            this.notifyAll();

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
