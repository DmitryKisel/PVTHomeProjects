package by.itacademy.homeWork18.task1.subscriber;

import by.itacademy.homeWork18.task1.publisher.EventManager;

import java.io.File;

public class Subscriber {
    public EventManager events;
    private File file;

    public Subscriber() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}
