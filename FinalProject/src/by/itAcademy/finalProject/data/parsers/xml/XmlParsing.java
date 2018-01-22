package by.itAcademy.finalProject.data.parsers.xml;

import by.itAcademy.finalProject.data.parsers.FileParsing;
import by.itAcademy.finalProject.domain.entity.Root;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class XmlParsing implements FileParsing {

    /**
     * This method is implemented form FileParsing interface and runs parsing xml-file
     * @param fileName
     * @return
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    @Override
    public Root parseFile(String fileName) throws IOException, ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        try {
            parser.parse(fileName, handler);
        } catch (SAXException e){
            System.out.println("Ошибка парсинга xml файла " + e.toString());
        }
        return handler.getRoot();
    }
}
