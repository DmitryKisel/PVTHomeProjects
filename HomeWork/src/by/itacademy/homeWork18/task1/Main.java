package by.itacademy.homeWork18.task1;

import by.itacademy.homeWork18.task1.subscriber.Subscriber;
import by.itacademy.homeWork18.task1.listeners.MessageNotificationListener;
import by.itacademy.homeWork18.task1.listeners.LogOpenListener;

public class Main {
    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber();
        subscriber.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        subscriber.events.subscribe("save", new MessageNotificationListener("admin212"));

        try {
            subscriber.openFile("test.txt");
            subscriber.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
