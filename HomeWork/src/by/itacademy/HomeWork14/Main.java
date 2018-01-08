package by.itacademy.HomeWork14;

import by.itacademy.HomeWork14.Entity.Mp3File;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Mp3File> mp3FileList = new ArrayList<>();
        FolderScanner folderScanner = new FolderScanner();
        File[] listOfFiles = folderScanner.listFilesFromFolder(args[0]);
        AudioParser audioParser = new AudioParser();
        mp3FileList = audioParser.mp3Parser(listOfFiles);

        System.out.println();
        Catalogizator catalogizator = new Catalogizator();
        catalogizator.mp3DataConverter(mp3FileList);
        System.out.println();

        CheckSum checkSum = new CheckSum();
        checkSum.checkSumCompare(mp3FileList);


    }
}
