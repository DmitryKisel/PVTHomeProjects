package by.itacademy.homeWork17.task1;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    String path;
    List<FileClass> mp3FileClassList;
    List<FileClass> xmlFileClassList;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<FileClass> getMp3FileClassList() {
        return mp3FileClassList;
    }

    public void setMp3FileClassList(List<FileClass> mp3FileClassList) {
        this.mp3FileClassList = mp3FileClassList;
    }

    public List<FileClass> getXmlFileClassList() {
        return xmlFileClassList;
    }

    public void setXmlFileClassList(List<FileClass> xmlFileClassList) {
        this.xmlFileClassList = xmlFileClassList;
    }

    public Folder() {
        mp3FileClassList = new ArrayList<>();
        xmlFileClassList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Folder{" +
                "path='" + path + '\'' +
                ", mp3FileClassList=" + mp3FileClassList +
                ", xmlFileClassList=" + xmlFileClassList +
                '}';
    }
}
