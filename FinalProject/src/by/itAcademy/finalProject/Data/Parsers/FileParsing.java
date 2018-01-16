package by.itAcademy.finalProject.data.parsers;

import by.itAcademy.finalProject.domain.entity.Root;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface FileParsing {
    Root parseFile(String fileName) throws IOException, ParserConfigurationException, SAXException;
}
