package by.itacademy.homeWork18.task1.listeners;

import java.io.File;

public class MessageNotificationListener implements EventListener {
    private String message;

    public MessageNotificationListener(String message) {
        this.message = message;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Message to " + message + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}
