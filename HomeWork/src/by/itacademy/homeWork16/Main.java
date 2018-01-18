package by.itacademy.homeWork16;

public class Main {
    public static void main(String[] args) {

        ParsingThread parsingThread = new ParsingThread();
        DownloadThread downloadThread = new DownloadThread();

        parsingThread.setDownloadThread(downloadThread);
        downloadThread.setParsingThread(parsingThread);

        downloadThread.start();
        parsingThread.start();

    }

}
