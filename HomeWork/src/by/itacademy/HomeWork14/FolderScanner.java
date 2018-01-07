package by.itacademy.HomeWork14;

import java.io.File;

public class FolderScanner {
    public File[] listFilesFromFolder(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        return fList;
    }
}
