package by.itacademy.homeWork16;

import by.itacademy.homeWork16.Data.Parsers.JSON.JsonParsing;
import by.itacademy.homeWork16.Data.Parsers.XML.XmlParsing;
import by.itacademy.homeWork16.Domain.Entity.Root;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ParsingThread extends Thread {
    private DownloadThread downloadThread;
    public  Root root;

    public void setDownloadThread(DownloadThread downloadThread) {
         this.downloadThread = downloadThread;
    }
    @Override
    public void run() {
        synchronized (downloadThread) {
            System.out.println("parsing wait");
            try {
                downloadThread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        System.out.println("json parsing");

        JsonParsing jsonParsing = new JsonParsing();
        try {
            root = jsonParsing.parseFile("birthdays.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

            downloadThread.notify();

        System.out.println("Parsing wait");

            try {
                downloadThread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        System.out.println("xml parsing");
        XmlParsing xmlParsing = new XmlParsing();
        try {
            root = xmlParsing.parseFile("birthdays.xml");
            System.out.println("Данные в программу загружены");
        } catch (ParserConfigurationException e) {
            System.out.println("Ошибка XML парсинга");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Ошибка SAX XML парсинга");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        downloadThread.notify();
    }
    }
}