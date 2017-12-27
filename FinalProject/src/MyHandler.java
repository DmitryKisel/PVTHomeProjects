import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is calling from XmlParsing class and returns back  data from XML file
 */

public class MyHandler extends DefaultHandler {
    private Root root;
    private boolean isFileName;
    private boolean isStart;
    private Employee employee;
    private String thisElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isStart = true;
        thisElement = qName;
        if (qName.equals("root")) {
            root = new Root();
            isFileName = true;
            root.setEmployees(new ArrayList<>());
        } else  if (qName.equals("employees")) {
            employee = new Employee();
            employee.setEmails(new ArrayList<>());
            isFileName = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isStart = false;
        if (qName.equals("employees")) {
            root.getEmployees().add(employee);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isStart) {
            switch (thisElement) {
                case "name": {
                    if (isFileName) {
                        root.setName(new String(ch, start, length));
                    } else {
                        employee.setName(new String(ch, start, length));
                    }
                    break;
                }

                case "location":{
                    root.setLocation(new String(ch, start, length));
                    break;}

                case "baseSalary":{
                    root.setBaseSalary(Integer.parseInt(new String(ch, start, length)));
                    break;}

                case "id":{
                    employee.setId(Integer.parseInt(new String(ch, start, length)));
                    break;}

                case "degree":
                    employee.setDegree(new String(ch, start, length));
                    break;

                case "dateOfBirth": {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        employee.setDateOfBirth(sdf.parse(new String(ch, start, length)));
                    } catch (ParseException e){
                        System.out.println("Ошибка парсинга в Date " + e.toString());
                    }
                    break;
                }

                case "yearEperience": {
                    employee.setYearEperience(Integer.parseInt(new String(ch, start, length)));
                    break;
                }

                case "emails": {
                    employee.getEmails().add(new String(ch, start, length));
                    break;
                }

                case "visible": {
                    employee.setVisible(Boolean.parseBoolean(new String(ch, start, length)));
                    break;
                }
            }
        }
    }
    Root getRoot() {
        return root;
    }
}
