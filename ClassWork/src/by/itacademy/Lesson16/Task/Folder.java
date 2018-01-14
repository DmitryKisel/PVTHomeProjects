package by.itacademy.Lesson16.Task;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    String path;
    List<FileClass> fileClassList;

    public Folder(){
        fileClassList = new ArrayList<>();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<FileClass> getFileClassList() {
        return fileClassList;
    }

    public void setFileClassList(List<FileClass> fileClassList) {
        this.fileClassList = fileClassList;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "path='" + path + '\'' +
                ", fileClassList=" + fileClassList +
                '}';
    }
}
