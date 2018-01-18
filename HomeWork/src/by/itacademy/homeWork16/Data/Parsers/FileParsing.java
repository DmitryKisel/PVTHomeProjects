package by.itacademy.homeWork16.Data.Parsers;


import by.itacademy.homeWork16.Domain.Entity.Root;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface FileParsing {
    Root parseFile(String fileName) throws IOException, ParserConfigurationException, SAXException;
}
