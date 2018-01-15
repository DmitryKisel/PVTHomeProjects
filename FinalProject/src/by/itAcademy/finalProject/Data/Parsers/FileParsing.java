package by.itAcademy.finalProject.Data.Parsers;

import by.itAcademy.finalProject.Domain.Entity.Root;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface FileParsing {
    Root parseFile(String fileName) throws IOException, ParserConfigurationException, SAXException;
}
