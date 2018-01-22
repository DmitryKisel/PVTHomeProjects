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
import java.util.List;

public class ToXML {

    void createXML(List<Folder> folderList) throws ParserConfigurationException, TransformerException {
        Document document = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().newDocument();

        Element files = document.createElement("files");
        document.appendChild(files);
        Element ext1 = document.createElement("ext");
        files.appendChild(ext1);
        for ( Folder ff : folderList) {
            for (FileClass fileClass : ff.getMp3FileClassList()) {
                Element file = document.createElement("file");
                Attr name = document.createAttribute("name");
                name.setTextContent("mp3");
                ext1.setAttributeNode(name);
                ext1.appendChild(file);

                Element filename = document.createElement("name");
                filename.setTextContent(fileClass.getName());
                ext1.appendChild(filename);

                Element path = document.createElement("path");
                path.setTextContent(fileClass.getPath());
                ext1.appendChild(path);

                Element size = document.createElement("size");
                long a = fileClass.getSize();
                size.setTextContent(String.valueOf(a));
                ext1.appendChild(size);

                Element date = document.createElement("date");
                long d = fileClass.getSize();
                date.setTextContent(String.valueOf(d));
                ext1.appendChild(date);

            }
        }

        Element ext2 = document.createElement("ext");
        files.appendChild(ext2);
        for ( Folder ff : folderList) {
            for (FileClass fileClass : ff.getXmlFileClassList()) {
                Element file = document.createElement("file");
                Attr name = document.createAttribute("name");
                name.setTextContent("xml");
                ext2.setAttributeNode(name);
                ext2.appendChild(file);

                Element filename = document.createElement("name");
                filename.setTextContent(fileClass.getName());
                ext2.appendChild(filename);

                Element path = document.createElement("path");
                path.setTextContent(fileClass.getPath());
                ext2.appendChild(path);

                Element size = document.createElement("size");
                long a = fileClass.getSize();
                size.setTextContent(String.valueOf(a));
                ext2.appendChild(size);

                Element date = document.createElement("date");
                long d = fileClass.getSize();
                date.setTextContent(String.valueOf(d));
                ext2.appendChild(date);

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
