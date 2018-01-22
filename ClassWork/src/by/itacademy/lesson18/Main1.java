package by.itacademy.lesson18;

import by.itacademy.Lesson16.Task.FileClass;

import java.io.File;

public class Main1 {
    public static void main(String[] args) {

    }

    public static void readFolder(String path){
        File file = new File(path);
        for(File f : file.listFiles()){
            if(f.isDirectory()){
                readFolder(f.getAbsolutePath());
            }else {

            }
        }
    }

    // сколько раз метод может вызвать сам себя(рекурсия)
}
