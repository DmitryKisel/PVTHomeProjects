package by.itacademy.Lesson16.Task;

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
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        List<Folder> folderList = new ArrayList<>();
        for (String item : args) {
            Folder folder = new Folder();
            folder.setPath(item);
            File directory = new File(folder.getPath());
            File[] fList = directory.listFiles();
            for (File file : fList) {
                FileClass fileClass = new FileClass();
                fileClass.setName(file.getName());
                fileClass.setPath(file.getPath());
                fileClass.setSize(file.length());
//                       fileClass.setDate(file.lastModified());
                folder.getFileClassList().add(fileClass);
            }
            folderList.add(folder);
        }


        for (Folder folder : folderList) {
            for (int i = 0; i < folder.getFileClassList().size(); i++) {
                System.out.println(folder.getFileClassList().get(i).getPath());
            }
        }

        Document document = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().newDocument();


    Element folder = document.createElement("folder");
    document.appendChild(folder);
    for ( Folder ff : folderList) {
    for (FileClass fileClass : ff.getFileClassList()) {
        Element file = document.createElement("file");
        folder.appendChild(file);
        Element name = document.createElement("name");
        name.setTextContent(fileClass.getName());
        file.appendChild(name);

        Element path = document.createElement("path");
        path.setTextContent(fileClass.getPath());
        file.appendChild(path);

        Element size = document.createElement("size");
        long a = fileClass.getSize();
        size.setTextContent(String.valueOf(a));
        file.appendChild(size);

        Element date = document.createElement("date");
        long d = fileClass.getSize();
        date.setTextContent(String.valueOf(d));
        file.appendChild(date);

    }
}
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(
                    new File(System.getProperty("user.dir")
                            + File.separator + "result.xml"));

            transformer.transform(source, result);
        System.out.println("save");
        }
    }


