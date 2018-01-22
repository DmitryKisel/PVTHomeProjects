package by.itacademy.homeWork17.task1;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskMain {
    static  List<Folder> folderList = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        for (String item : args) {
            readFolder(item);
        }

        ToXML toXML = new ToXML();
        toXML.createXML(folderList);
    }

        public static void readFolder(String path){
            Folder folder = new Folder();
            folder.setPath(path);
            File file = new File(path);
            for(File f : file.listFiles()){
                if(f.isDirectory()){
                    readFolder(f.getAbsolutePath());
                }else if (f.getName().endsWith(".mp3") ){
                        FileClass fileClass = new FileClass();
                        fileClass.setName(f.getName());
                        fileClass.setPath(f.getPath());
                        fileClass.setSize(f.length());
                        //        fileClass.setDate(file.lastModified());
                        folder.getMp3FileClassList().add(fileClass);
                    }


                    else  if (f.getName().endsWith(".xml") ){
                        FileClass fileClass = new FileClass();
                        fileClass.setName(f.getName());
                        fileClass.setPath(f.getPath());
                        fileClass.setSize(f.length());
                        //        fileClass.setDate(file.lastModified());
                        folder.getXmlFileClassList().add(fileClass);
                    }
                }
                folderList.add(folder);
            }
        }



